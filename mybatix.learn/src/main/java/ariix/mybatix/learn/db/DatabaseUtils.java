package ariix.mybatix.learn.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseUtils {

	private static final String ENV_ORACLE = "oracle";
	// Life Scope is the application life cycle
	private static SqlSessionFactory sqlSessionFactory;

	static {

		if (sqlSessionFactory == null) {

			synchronized (DatabaseUtils.class) {

				if (sqlSessionFactory == null) {

					try {
						String resource = "config/MyBatisConfiguration.xml";
						Reader reader = Resources.getResourceAsReader(resource);
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, ENV_ORACLE);
						// SqlSessionFactoryBuilder instance should be a local instance
					} catch (IOException e) {
						e.printStackTrace();
						System.exit(1); // terminate JVM
					}
				}
			}
		}

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		System.out.println(sqlSessionFactory);
	}

}
