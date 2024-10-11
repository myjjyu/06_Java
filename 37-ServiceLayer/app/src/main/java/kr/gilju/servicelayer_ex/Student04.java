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

public class Student04 {
   public static void main(String[] args) {
    Logger logger = LogManager.getLogger(Student02.class);

    /** 2 조회할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("조회할 학생 학번: ");
    int studno = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) select 수행할 데이터 생성 */
    Student model = new Student();
    model.setStudno(studno);



    /** 5) 데이터 처리 수행 */
    StudentService studentService = new StudentServiceImpl(sqlSession);

    /** 5) 데이터 조회 */
    Student result = null;

     // 학과 수정하기
      try {
        result = studentService.getItem(model);
      } catch (ServiceNoResultException e) {
        sqlSession.rollback();
        logger.error("[조회된 결과가 없습니다]");
        logger.error(e.getMessage());
      } catch (Exception e) {
        sqlSession.rollback();
        logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요]");
        logger.error(e.getMessage());
      } finally {
        sqlSession.commit();
      }

    /** 6) 결과 출력 */
    logger.debug("==================================");

    if (result != null) {
      logger.debug("학생 이름: " + result.getName()); 
      logger.debug("학생 ID: " + result.getUserid()); 
      logger.debug("학생 학년: " + result.getGrade()); 
      logger.debug("학생 주민번호: " + result.getIdnum()); 
      logger.debug("학생 생일: " + result.getBirthdate()); 
      logger.debug("학생 전화번호: " + result.getTel()); 
      logger.debug("학생 키: " + result.getHeight()); 
      logger.debug("학생 몸무게: " + result.getWeight());
      logger.debug("현재 학과 번호: " + result.getDeptno()); 
      logger.debug("현재 담당 교수 번호: " + result.getProfno());
      logger.debug("학생 학번: " + result.getStudno());
    } else {
      logger.debug("수정된 데이터가 없습니다");
    }

    logger.debug("==========================================");

    /** 7) 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}
