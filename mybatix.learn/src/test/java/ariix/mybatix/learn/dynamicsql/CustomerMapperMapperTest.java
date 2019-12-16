package ariix.mybatix.learn.dynamicsql;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;


public class CustomerMapperMapperTest extends TestCase {

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
	public void testDistPhone() {
		Long customerId=  6000001L;
		CustomerDomain custdomer = customerMapper.selectCustomerById(customerId);
		
		assertEquals("should be same", "vicky - 5", custdomer.getrFirstName());
	}

}
