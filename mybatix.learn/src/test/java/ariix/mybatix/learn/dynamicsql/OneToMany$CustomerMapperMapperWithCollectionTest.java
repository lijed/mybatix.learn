package ariix.mybatix.learn.dynamicsql;

import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.CustomerMapper;
import ariix.mybatix.learn.db.vo.CustomerDomain;
import ariix.mybatix.learn.db.vo.CustomerSearchCriteria;


/**
 * December 13, 2019
 * 
 * One to one mapping, use <association>
 *
 * 
 */
public class OneToMany$CustomerMapperMapperWithCollectionTest extends TestCase {

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
	public void testOneToManyMappingWithCollection() {
		CustomerSearchCriteria searchCriteria = new CustomerSearchCriteria();
		searchCriteria.setCountryCode("USA");
		searchCriteria.setFirstName("Jed");
		List<CustomerDomain> customers = customerMapper.findCustomersWithCollection(searchCriteria);
		System.out.println(customers.size());
	}
	
}
