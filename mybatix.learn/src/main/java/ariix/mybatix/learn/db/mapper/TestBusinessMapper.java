package ariix.mybatix.learn.db.mapper;

import ariix.mybatix.learn.db.vo.TestBusiness;

public interface TestBusinessMapper {
	public Integer saveTestBusiness(TestBusiness testBusiness);
	public TestBusiness getTestBusinessById(Integer userId);
}
