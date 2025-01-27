package kr.gilju;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
  /** 데이터 베이스 접속 객체 */
  private static SqlSessionFactory sqlSessionFactory;

  /** xml에 명시된 접속 정보를 읽어 들인다 */
  // 클래스 초기화 블럭 : 클래스 변수의 복잡한 초기화에 사용된다
  // 클래스가 처음 로딩될 때 한버만 수행된다

  static {
    // 접속 정보를 명시하고 있는 xml의 경로 읽기

    try {
      Reader reader = Resources.getResourceAsReader("config.xml");

      // sqlSessionFactory 가 존재하지 않는다면 생성한다
      if (sqlSessionFactory == null) {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** 데이터베이스 접속 객체를 통해 database 에 접속한 세션을 리턴한다 */
  public static SqlSession getSqlSession() {
    return sqlSessionFactory.openSession();
  }
}
