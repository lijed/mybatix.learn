package ariix.mybatix.learn.cache;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.mapper.DwMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;
import ariix.mybatix.learn.db.vo.WebCategory;

/**
 * December 13, 2019
 * 
 * One to one mapping, use <association>
 *
 * 
 */
public class LevelOneCacheClearExecuteOtherMapperTest extends TestCase {

	SqlSession session;
	CustomerMapper customerMapper;
	DwMapper dwMapper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		customerMapper = session.getMapper(CustomerMapper.class);
		dwMapper = session.getMapper(DwMapper.class);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testOneToOneMapping() {
		Long customerId = 6000001L;
		
		System.out.println("First Load");
		CustomerDomain customer = customerMapper.getCustomerById(customerId);

		assertEquals(customerId, customer.getCustId());

		String nativeName = customer.getFullNativeName();
		System.out.println("Second Load");
		customer = customerMapper.getCustomerById(customerId);
		assertEquals(nativeName, customer.getFullNativeName());
		
		//update will flush the level one cache
		WebCategory name = new WebCategory();
		name.setItemCode("001.010101");
		name.setCategoryKey("revvnrg");
		name.setDisplayOrder(0);
		dwMapper.updateWebCategory(name);
		
		System.out.println("Third Load");
		customer = customerMapper.getCustomerById(customerId);
		nativeName = customer.getFullNativeName();
	
	
		assertEquals(customerId, customer.getCustId());
	}

}
