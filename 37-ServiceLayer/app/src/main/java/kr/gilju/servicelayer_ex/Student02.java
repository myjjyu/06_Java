package kr.gilju.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Student;
import kr.gilju.services.StudentService;
import kr.gilju.services.impl.StudentServiceImpl;

public class Student02 {
  public static void main(String[] args) throws Exception {
    /** 1) log4j2객체 생성 */
    Logger logger = LogManager.getLogger(Student02.class);

    /** 2 저장할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("삭제할 학생 학번: ");
    int studno = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
    /** 4) delete 를 수행할 데이터 생성 */
    Student model = new Student();
    model.setStudno(studno);

    /** 5) 데이터 처리 수행 */
    StudentService studentService = new StudentServiceImpl(sqlSession);

    // 결과값을 저장할 변수
    int result = 0;

    // 학과 삭제하기
    try {
      result = studentService.deleteItem(model);

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
