package ariix.mybatix.learn.xmlmapper;

import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.ProvinceMapper;
import ariix.mybatix.learn.db.vo.City;
import ariix.mybatix.learn.db.vo.DistrictCity;
import ariix.mybatix.learn.db.vo.Province;

/**
 * ResultMap, use collection to build up the object
 * 
 * one to many: <Collection>
 *
 * 
 */
public class Discriminator$ResultMap$MapperProvinceTest extends TestCase {

	SqlSession session;
	ProvinceMapper provinceMapper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		provinceMapper = session.getMapper(ProvinceMapper.class);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		try {
			if (session != null) {
				session.close();
			}
		} catch (Exception e) {
		}
	}

	
	/**
	 *  主要是为了Mybatis的鉴别器
	 */
	@Test
	public void testResultMap$Discriminator() {
		Province peking = new Province();
		peking.setProvince("北京市");
		List<Province> provinces = provinceMapper.getProvincesWithDiscriminator(peking);
		System.out.println(provinces.size());
		for (Province p : provinces) {
			System.out.println("Provice：---" + p.getProvince());
			if (p instanceof DistrictCity) {
				System.out.println("District City: " + ((DistrictCity)p).getCity());
			}
			for (City city : p.getCitys()) {
				System.out.println("  City-------：" + city.getCity());
				for (String district : city.getDistrcts()) {
					System.out.println("  District----------：" + district);
				}
			}
		}
	}
}
