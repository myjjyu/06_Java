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

public class App02 {
  public static void main(String[] args) {

    /** 1) 처리 결과를 기록할 Log4j 객체생성 */
    Logger logger = LogManager.getFormatterLogger(App02.class);

    /** 2) 삭제할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("삭제할 학과 번호: ");
    int deptno = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) delete 를 수행할 데이터 생성 */
    Department model = new Department();
    model.setDeptno(deptno);

    /** 5) 데이터 처리 수행 */
    DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

    // 결과값을 저장할 변수
    int result = 0;

    // 학과 삭제하기
    try {
      result = departmentService.deleteItem(model);

    } catch (ServiceNoResultException e) {
      sqlSession.rollback();
      logger.error("[삭제된 결과가 없습니다]");
      logger.error(e.getMessage());
    } catch (Exception e) {
      sqlSession.rollback();
      logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요]");
      logger.error(e.getMessage());
    } finally {
      sqlSession.commit();
    }

    /** 6) 결과 출력 */
    logger.debug("==========================================");
    logger.debug("삭제된 데이터: " + result + "개");
    logger.debug("==========================================");

    /** 7) 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}