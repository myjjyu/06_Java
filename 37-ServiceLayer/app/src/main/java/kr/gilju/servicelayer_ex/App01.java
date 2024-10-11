
package kr.gilju.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Department;
import kr.gilju.services.DepartmentService;
import kr.gilju.services.impl.DepartmentServiceImpl;

public class App01 {
  public static void main(String[] args) {
    /** 처리 결과를 기록할 Log4j 객체생성 */
    Logger logger = LogManager.getFormatterLogger(App01.class);

    /** 저장할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("학과명:");
    String dname = scanner.nextLine();

    System.out.print("위치:");
    String loc = scanner.nextLine();

    scanner.close();

    // 입력값을 로그로 기록함
    logger.debug("입력된 데이터:" + dname + "," + loc);

    /** 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 저장될 데이터를 담고 있는 beans 객체 생서 */
    Department dept = new Department();
    dept.setDname(dname);
    dept.setLoc(loc);

    /** 데이터 처리 수행 */
    // 비즈니스 로직을 위한 service 객체 생성
    DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);
    // 저장된 결과를 리턴받기 위힌 beans 객체
    Department result = null;

    // 저장된 결과를 리턴받기 위한 beans객체

    try {
      result = departmentService.addItem(dept);
    } catch (ServiceNoResultException e) {
      sqlSession.rollback();
      logger.error("[저장된 결과가 없습니다.]");
      logger.error(e.getMessage());

    } catch (Exception e) {
      sqlSession.rollback();
      logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요]");
      logger.error(e.getMessage());

    } finally {
      sqlSession.commit();
    }

    /** 처리 결과 출력 */
    if (result != null) {
      logger.debug("==========================================");
      logger.debug(result.toString());
      logger.debug("==========================================");

    } else {
      logger.error("저장된 데이터가 없습니다");
    }
    /** 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}