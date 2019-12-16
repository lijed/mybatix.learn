package ariix.mybatix.learn.db.mapper;

import ariix.mybatix.learn.db.vo.CustomerDomain;
import ariix.mybatix.learn.db.vo.CustomerIdsDomain;

public interface CustomerMapper {
	
	public CustomerDomain selectCustomerById(Long custId);
	
	public CustomerIdsDomain selectGovernmentIdById(Long custId);
}
