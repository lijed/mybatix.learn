package ariix.mybatix.learn.cache;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;

/**
 * December 13, 2019
 * 
 * One to one mapping, use <association>
 *
 * 
 */
public class LevelOneCacheFlushTest extends TestCase {

	SqlSession session;
	CustomerMapper customerMapper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		customerMapper = session.getMapper(CustomerMapper.class);
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
	public void testOneToOneMapping() {
		Long customerId = 6000001L;
		
		System.out.println("First Load");
		CustomerDomain customer = customerMapper.getCustomerById(customerId);

		assertEquals(customerId, customer.getCustId());

		String nativeName = customer.getFullNativeName();
		System.out.println("Second Load");
		customer = customerMapper.getCustomerById(customerId);
		assertEquals(nativeName, customer.getFullNativeName());
		
		//Clear the level one cache
		session.clearCache();
		
		customer = customerMapper.getCustomerById(customerId);
		nativeName = customer.getFullNativeName();
		System.out.println("Third Load");
	
		assertEquals(customerId, customer.getCustId());

	}

}
