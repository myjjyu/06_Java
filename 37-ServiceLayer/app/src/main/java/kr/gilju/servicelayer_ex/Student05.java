package kr.gilju.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Student;
import kr.gilju.services.StudentService;
import kr.gilju.services.impl.StudentServiceImpl;

public class Student05 {
  public static void main(String[] args) {
    /** 1) 처리 결과를 기록할 Log4j 객체생성 */
    Logger logger = LogManager.getLogger(Professor02.class);
    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3) 데이터 처리 수행 */
    StudentService studentService = new StudentServiceImpl(sqlSession);

    /** 4) 데이터 조회 */
    List<Student> result = null;

    // 학과 수정하기
    try {
      result = studentService.getList(null);
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

    /** 5) 결과 출력 */
    logger.debug("==================================");

    if (result != null) {
      int size = result.size();

      for (int i = 0; i < size; i++) {
        Student item = result.get(i);

        logger.debug("학생학번: {}", item.getStudno());
        logger.debug("학생이름: {}", item.getName());
        logger.debug("학생아이디: {}", item.getUserid());
        logger.debug("학년: {}", item.getGrade());
        logger.debug("주민번호: {}", item.getIdnum());
        logger.debug("생일: {}", item.getBirthdate());
        logger.debug("전화번호: {}", item.getTel());
        logger.debug("키: {}", item.getHeight());
        logger.debug("몸무게: {}", item.getWeight());
        logger.debug("학과: {}", item.getDeptno());
        logger.debug("담당교수번호: {}", item.getProfno());

        if (i + 1 < size) {
          logger.debug("-----------------------------------------");
        }
      }
    } else {
      logger.debug("조회된 데이터가 없습니다");
    }
    logger.debug("==========================================");
    /** 6) 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}