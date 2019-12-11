package ariix.mybatix.learn;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.DwMapper;
import ariix.mybatix.learn.db.vo.WebCategory;


public class DwMapperTest extends TestCase {

	SqlSession session;
	DwMapper dbMapper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = DatabaseUtils.getSqlSessionFactory().openSession();
		dbMapper = session.getMapper(DwMapper.class);
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
		String phone = dbMapper.distPhone("1700998");
		Assert.assertEquals("801813300", phone);
	}
	
	@Test
	@Ignore
	public void testSaveWebCategory() {
		WebCategory wc = new WebCategory();
		wc.setItemCode("test_jed");
		wc.setCategoryKey("test");
		wc.setDisplayOrder(1);
		wc.setDisclaimer(0);
		wc.setStartDate(Calendar.getInstance().getTime());
		wc.setEndDate(Calendar.getInstance().getTime());
		dbMapper.saveWebCategory(wc);
		session.commit();
	}
	
	@Ignore
	@Test
	public void testUpdateResultVisibleToClose() {
		// In one Connection, first you get it, then update it, finally you get it and the final result is the result before your update
		// Because of the local Cache of Mybatis.  
		// If you want to make the update results visible to the following select statements, set flushCache = "true" of Update element 
		WebCategory wc = new WebCategory();
		wc.setItemCode("test_jedLi");
		wc.setCategoryKey("test");
		wc.setDisplayOrder(1);
		wc.setDisclaimer(0);
		wc.setStartDate(Calendar.getInstance().getTime());
		wc.setEndDate(Calendar.getInstance().getTime());
		WebCategory resultBeforeUpdate = dbMapper.getWebCategory(wc);
		Assert.assertNotNull(resultBeforeUpdate);
		Assert.assertEquals(wc, resultBeforeUpdate);
		
		wc.setDisplayOrder(1003);
		dbMapper.updateWebCategory(wc);
		
		WebCategory resultAfterUpdate = dbMapper.getWebCategory(wc);
		Assert.assertNotNull(resultAfterUpdate);
		Assert.assertEquals(resultBeforeUpdate, resultAfterUpdate);
		
		session.commit();
	}
	
	
	@Test
	@Ignore
	public void testDeleteResultVisibleToClose() {
		// In one Connection, first you get it, then delete it, finally you get it and the final result is null,
		// the property flushCase of <delete> is true by default
		WebCategory wc = new WebCategory();
		wc.setItemCode("test_jed_1");
		wc.setCategoryKey("test");
		wc.setDisplayOrder(1);
		wc.setDisclaimer(0);
		wc.setStartDate(Calendar.getInstance().getTime());
		wc.setEndDate(Calendar.getInstance().getTime());
		WebCategory resultBeforeUpdate = dbMapper.getWebCategory(wc);
		Assert.assertNotNull(resultBeforeUpdate);
		Assert.assertEquals(wc, resultBeforeUpdate);
		
		wc.setDisplayOrder(1003);
		dbMapper.deleteWebCategory(wc);
		
		WebCategory resultAfterUpdate = dbMapper.getWebCategory(wc);
		Assert.assertNull(resultAfterUpdate);
		
		session.commit();
	}
	
	

	@Test
	@Ignore
	public void testGetWebCategory() {
		// In one Connection, the result of insert statement is visible to following select
		WebCategory wc = new WebCategory();
		wc.setItemCode("test_jedLi");
		wc.setCategoryKey("test");
		wc.setDisplayOrder(1);
		wc.setDisclaimer(0);
		wc.setStartDate(Calendar.getInstance().getTime());
		wc.setEndDate(Calendar.getInstance().getTime());
		dbMapper.saveWebCategory(wc);
		
		// the result is the result just inserted
		WebCategory result = dbMapper.getWebCategory(wc);
		Assert.assertNotNull(result);
		Assert.assertEquals(wc, result);
		
		wc.setDisplayOrder(1000);
		dbMapper.updateWebCategory(wc);
		
		// the old result, because of Mybatis local cache
		result = dbMapper.getWebCategory(wc);
		Assert.assertNotNull(result);
		Assert.assertEquals(wc, result);
		
		session.commit();
	}
	
	
	@Ignore
	@Test
	public void testFindWebCategoryList() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -10);
		Date startDate = c.getTime();
		
		c.add(Calendar.DAY_OF_MONTH, 23);
		Date endDate = c.getTime();
		
		List<WebCategory> wcList = dbMapper.findWebCategoryList(startDate, endDate);
		Assert.assertTrue("Result should be more than one", wcList.size() >= 1);
	}

}
