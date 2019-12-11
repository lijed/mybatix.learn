package ariix.mybatix.learn.db.dw;

import org.apache.ibatis.session.SqlSession;

import ariix.mybatix.learn.db.DatabaseUtils;

public class SqlSessionGoodPractice {
	

	public static void main(String[] args) {
		SqlSessionGoodPractice instance = new SqlSessionGoodPractice();
		instance.goodPracticeSinceJDK7();
		instance.goodPracticeBeforeJDK7();
	}
	
	
	/**
	 * remember to release Session finally
	 */
	public void goodPracticeSinceJDK7() {
		//SqlSession is closeable, use try with 
		
		// Since JDK7
		try (SqlSession sqlSession = DatabaseUtils.getSqlSessionFactory().openSession()) {
		
			String phone = sqlSession.selectOne("ariix.mybatix.learn.db.mapper.DwMapper.distPhone", 26166);
			System.out.println(phone);
			
		} finally {
			
		}
	}
	
	
	/**
	 * remember to release Session finally
	 */
	public void goodPracticeBeforeJDK7() {
		//SqlSession is closeable, use try with 
		
		// Since JDK7
		 SqlSession sqlSession = DatabaseUtils.getSqlSessionFactory().openSession();
		try {
			String phone = sqlSession.selectOne("ariix.mybatix.learn.db.mapper.DwMapper.distPhone", 26166);
			System.out.println(phone);
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
