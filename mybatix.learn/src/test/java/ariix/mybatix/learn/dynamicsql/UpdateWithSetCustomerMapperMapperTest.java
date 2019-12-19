package ariix.mybatix.learn.dynamicsql;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;
import ariix.mybatix.learn.db.vo.CustomerIdsDomain;


/**
 * December 13, 2019
 * 
 * One to one mapping, use <association>
 *
 * 
 */
public class UpdateWithSetCustomerMapperMapperTest extends TestCase {

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
		CustomerDomain customer = customerMapper.getCustomerById(customerId);
//		customer.setrFirstName("Thomas");
		customer.setrFirstName("Thomas");
		customer.setrMiddleName("Mi");
		customer.setrLastName("Li");
		customerMapper.updateCustomerWithSet(customer);
		
		CustomerDomain updateCustomer = customerMapper.getCustomerById(customerId);
		assertEquals("should equal", "Li", updateCustomer.getrLastName());
	}

}
