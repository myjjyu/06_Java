package kr.gilju.mybaits_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Department;

public class App01 {
  public static void main(String[] args) {
    /** new log4h2객체생성 */
    Logger logger = LogManager.getLogger(App01.class);

    /** 1) 저장할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("학과명: ");
    String dname = scanner.nextLine();

    System.out.print("위치: ");
    String loc = scanner.nextLine();


    scanner.close();

    // 입력값을 로그로 기록함
    logger.debug("입력된 데이터: " + dname + ", " + loc);

    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3)insert 를 수행할 데이터생성 */
    Department department = new Department();
    department.setDname(dname);
    department.setLoc(loc);

    /** 4) 데이터 저장 */
    int result = 0;

    try {
      // DepartmentMapper 이라는 namespace를 갖는 xml 에서
      // id 값이 add_department인 <insert> 태그를 호출한다
      sqlSession.insert("DepartmentMapper.insert", department);
      // 이때 , 저장할 데이터를 담고 있는 beans를 파라미터로 전달하고, 자동으로 생성된 pk는 beans에 저장된다
      result = department.getDeptNo();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    /** 결과판별 */
    logger.info(result + "번 데이터 저장됨");

    /** db 접속 해제 */
    sqlSession.commit();
    sqlSession.close();
  }
}