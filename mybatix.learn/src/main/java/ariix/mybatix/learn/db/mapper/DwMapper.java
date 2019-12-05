package ariix.mybatix.learn.db.mapper;

import java.util.Date;
import java.util.List;

public interface DwMapper {
	
	String distPhone(String distId);
	
	int saveWebCategory(WebCategory web);
	
	WebCategory getWebCategory(WebCategory web);
	
	void updateWebCategory(WebCategory web);
	
	int deleteWebCategory(WebCategory web);
	
	List<WebCategory> findWebCategoryList(Date startDate,Date endDate);
}
