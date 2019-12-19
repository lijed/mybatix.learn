package ariix.mybatix.learn.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import ariix.mybatix.learn.db.vo.CustomerDomain;
import ariix.mybatix.learn.db.vo.CustomerIdsDomain;
import ariix.mybatix.learn.db.vo.SearchCriteria;

public interface CustomerMapper {
	
	public CustomerDomain getCustomerById(Long custId);
	
	public CustomerIdsDomain getGovernmentIdById(Long custId);
	
	public List<CustomerDomain> findCustomersBy(SearchCriteria searchCriteria);
	
	public List<CustomerDomain> findCustomersWithForEach(SearchCriteria searchCriteria);
	
	public List<CustomerDomain> findCustomersByWithTrim(SearchCriteria searchCriteria);
	
	public void updateCustomerWithSet(CustomerDomain cust);
	
	public void updateCustomerWithTrim(CustomerDomain cust);
	
	@Update({
		"<script>",
		"update cust ",
		 "<set>",
		 " <if test='rFirstName != null and rFirstName.length > 0'>r_first_name=#{rFirstName},</if>",
		 " <if test='rMiddleName != null'>R_MIDDLE_NAME=#{rMiddleName},</if>	",
		 " <if test='rLastName != null'>R_LAST_NAME=#{rLastName}</if>	",
		 "</set>",
		"</script>"})
	public void updateCustomerWithScript(CustomerDomain cust);
	
	
	public List<CustomerDomain> findCustomersWithCollection(SearchCriteria searchCriteria);
	
}
