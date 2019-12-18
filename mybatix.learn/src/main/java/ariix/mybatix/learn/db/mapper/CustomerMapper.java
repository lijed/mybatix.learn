package ariix.mybatix.learn.db.mapper;

import java.util.List;

import ariix.mybatix.learn.db.vo.CustomerDomain;
import ariix.mybatix.learn.db.vo.CustomerIdsDomain;
import ariix.mybatix.learn.db.vo.SearchCriteria;

public interface CustomerMapper {
	
	public CustomerDomain getCustomerById(Long custId);
	
	public CustomerIdsDomain getGovernmentIdById(Long custId);
	
	public List<CustomerDomain> findCustomersBy(SearchCriteria searchCriteria);
}
