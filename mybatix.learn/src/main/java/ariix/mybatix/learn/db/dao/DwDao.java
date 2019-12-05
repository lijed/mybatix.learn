package ariix.mybatix.learn.db.dao;

import org.apache.ibatis.session.SqlSession;

import ariix.mybatix.learn.db.DatabaseUtils;
import ariix.mybatix.learn.db.mapper.DwMapper;

public class DwDao {

	public static void main(String[] args) {
		try (SqlSession sqlSession = DatabaseUtils.getSqlSessionFactory().openSession()) {
			
			DwMapper dwMapper = sqlSession.getMapper(DwMapper.class);
			String phone = dwMapper.distPhone("26166");
			System.out.println(phone);
			
		} catch (Exception e) {
			
		} finally {
			//resource clear
		}
	}

}
