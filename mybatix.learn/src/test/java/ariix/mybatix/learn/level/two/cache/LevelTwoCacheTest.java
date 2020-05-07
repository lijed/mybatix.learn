package ariix.mybatix.learn.level.two.cache;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;

/**
 * December 31, 2019
 * 
 * Level two cache
 *
 * 
 */
public class LevelTwoCacheTest extends TestCase {

	SqlSession session;
	CustomerMapper customerMapper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testLevelTwoCache() {
		Long customerId = 6000001L;
		Long customerId2 = 1701017L;
		
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		customerMapper = session.getMapper(CustomerMapper.class);
		
		System.out.println("First Load in sesison with hashcode:" + session.hashCode());
		CustomerDomain customer = customerMapper.getCustomerById(customerId);
		CustomerDomain customer2 = customerMapper.getCustomerById(customerId2);
		assertEquals(customerId, customer.getCustId());
		session.close();
		System.out.println("close level one cache.");
		
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		customerMapper = session.getMapper(CustomerMapper.class);
		System.out.println("Second Load in sesison with hashcode:" + session.hashCode());
		customer = customerMapper.getCustomerById(customerId);
		customer2 = customerMapper.getCustomerById(customerId2);
		assertEquals(customerId, customer.getCustId());
		session.close();
		
		
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		customerMapper = session.getMapper(CustomerMapper.class);
		System.out.println("Third Load in sesison with hashcode:" + session.hashCode());
		customer = customerMapper.getCustomerById(customerId);
		customer2 = customerMapper.getCustomerById(customerId2);
		assertEquals(customerId, customer.getCustId());
		session.close();
	}

}
