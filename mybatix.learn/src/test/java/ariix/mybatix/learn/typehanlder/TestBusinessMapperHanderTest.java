package ariix.mybatix.learn.typehanlder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.DwMapper;
import ariix.mybatix.learn.db.mapper.TestBusinessMapper;
import ariix.mybatix.learn.db.vo.TestBusiness;
import ariix.mybatix.learn.db.vo.WebCategory;


public class TestBusinessMapperHanderTest extends TestCase {

	SqlSession session;
	TestBusinessMapper dbMapper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		dbMapper = session.getMapper(TestBusinessMapper.class);
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
	@Ignore
	public void testSaveWebCategory() {
		TestBusiness testBusiness = new TestBusiness();
		testBusiness.setUserId(2);
		List<Integer> business = new ArrayList<Integer>();
		business.add(1);
		business.add(2);
		testBusiness.setBusiness(business );
		dbMapper.saveTestBusiness(testBusiness );
		session.commit();
	}
	
	
	@Test
	public void testGetBusinessById() {
		TestBusiness testBusiness = dbMapper.getTestBusinessById(2);
		System.out.println(testBusiness.toString());
		assertEquals("Business ID expected 2", 2, testBusiness.getUserId().intValue());
	}

}
