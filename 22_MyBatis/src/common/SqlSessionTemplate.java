package common;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class SqlSessionTemplate {
	
	// mybatis-config.xml, *-mapper.xml 파일 생성을 완료했다면,
	// common 패키지를 만들어 싱글톤을 적용한 Template 클래스를 만들고
	// SqlSession을 반환해주는 static 메소드를 작성한다.
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		String resource = "/mybatis-config.xml";
		try {
			// 1. mybatis-config.xml의 설정 정보를 InputStream 객체를 통해 읽어온다.
			InputStream stream = Resources.getResourceAsStream(resource);
			
			// 2. SqlSessionFactoryBuilder 객체를 생성하고 build() 메소드를 통해
			//    SqlSessionFactory 객체를 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(stream);
			
			// 3. SqlSessionFactory 객체의 openSession() 메소드를 통해 SqlSession 객체 생성
			session = factory.openSession(false);
			
			
		} catch (IOException e) {
		}
		return session;
	}
	
}
