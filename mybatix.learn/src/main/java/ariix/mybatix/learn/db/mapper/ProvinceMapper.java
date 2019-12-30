package ariix.mybatix.learn.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import ariix.mybatix.learn.db.vo.Province;

/**
 * 
 */
public interface ProvinceMapper {
	
	public List<Province> getProvinces(Province province);
	
	public List<Province> getProvincesWithDiscriminator(Province province);
	
	
	public String getProvinceNameBy(String proviceName);
	
	/**
	 * 
	 * @Param annotation tell the parameter name and code is clear and easy to understand
	 * 
	 * or 
	 * 
	 * you could use the mybatis built-in param used
	 *  for accepting the passed parameters, param1, param2... and the first parameter is param1, and so on.
	 *  #{param2}
	 * 
	 * @param provinceName
	 * @param city
	 * @return
	 */
	public List<Province> findProvinceBy(@Param("provinceName") String provinceName, String city);
	
	
	
//	@Select("select PROVINCE, CITY, DISTRICT, ZIP_CODE  From tb_district_cn where ${column} = #{value}") Good #{value} is prepared
	@Select("select PROVINCE, CITY, DISTRICT, ZIP_CODE  From tb_district_cn where ${column} = ${value}") //Bad ${} will be SQL injection
	@ResultMap("provinceMap")
	public List<Province> findProvinceByColunaNameAndValue(@Param("column") String column, @Param("value") String value);
	
}
