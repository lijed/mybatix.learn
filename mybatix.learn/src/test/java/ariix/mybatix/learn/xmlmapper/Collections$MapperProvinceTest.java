package ariix.mybatix.learn.xmlmapper;

import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.ProvinceMapper;
import ariix.mybatix.learn.db.vo.City;
import ariix.mybatix.learn.db.vo.Province;

/**
 * ResultMap, use collection to build up the object
 * 
 * one to many: <Collection>
 *
 * 
 */
public class Collections$MapperProvinceTest extends TestCase {

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

	@Test
	public void testOneToManyMappingWithCollection() {
		Province peking = new Province();
		peking.setProvince("北京市");
		List<Province> provinces = provinceMapper.getProvinces(peking);
		System.out.println(provinces.size());
		for (Province p : provinces) {
			System.out.println("Provice：---" + p.getProvince());
			for (City city : p.getCitys()) {
				System.out.println("  City-------：" + city.getCity());
				for (String district : city.getDistrcts()) {
					System.out.println("  District----------：" + district);
				}
			}
		}
	}

	@Test
	public void testGetProvinceNameBy() {
		String pekingName = "北京市";
		String proviceName = provinceMapper.getProvinceNameBy(pekingName);
		Assert.assertEquals("should be 北京市", pekingName, proviceName);
	}

	/**
	 * mainly for parameters
	 */
	@Test
	public void testFindByProvinceWithCollection() {
		String provinceName = "河北省";
		String cityName = "秦皇岛市";
		List<Province> provinces = provinceMapper.findProvinceBy(provinceName,
				cityName);
		System.out.println(provinces.size());
		for (Province p : provinces) {
			System.out.println("Provice：---" + p.getProvince());
			for (City city : p.getCitys()) {
				System.out.println("  City-------：" + city.getCity());
				for (String district : city.getDistrcts()) {
					System.out.println("  District----------：" + district);
				}
			}
		}
	}

}
