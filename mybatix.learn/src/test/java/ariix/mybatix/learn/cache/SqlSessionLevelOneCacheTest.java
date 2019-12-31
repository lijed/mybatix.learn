package ariix.mybatix.learn.cache;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;

/**
 * 
 * December 29 2019, testing level one cache is for session level
 * 
 */
public class SqlSessionLevelOneCacheTest extends TestCase {

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
		
		System.err.println("First Load");
		CustomerDomain customer = customerMapper.getCustomerById(customerId);

		assertEquals(customerId, customer.getCustId());

		String nativeName = customer.getFullNativeName();
		System.err.println("Second Load");
		customer = customerMapper.getCustomerById(customerId);
		assertEquals(nativeName, customer.getFullNativeName());
		
		try {
			if (session != null) {
				session.close();
			}
		} catch (Exception e) {
		}
		
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		customerMapper = session.getMapper(CustomerMapper.class);
		
		System.err.println("Third Load for new session");
		customer = customerMapper.getCustomerById(customerId);
		nativeName = customer.getFullNativeName();
	
	
		assertEquals(customerId, customer.getCustId());
		
		try {
			if (session != null) {
				session.close();
			}
		} catch (Exception e) {
		}
	}

}
