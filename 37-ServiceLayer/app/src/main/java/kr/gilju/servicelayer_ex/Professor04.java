package kr.gilju.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Professor;
import kr.gilju.services.ProfessorService;
import kr.gilju.services.impl.ProfessorServiceImpl;

public class Professor04 {
  public static void main(String[] args) {
    Logger logger = LogManager.getLogger(Professor02.class);

    /** 2 조회할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("조회할 교수 번호: ");
    int profno = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) delete 를 수행할 데이터 생성 */
    Professor model = new Professor();
    model.setProfno(profno);


    /** 5) 데이터 처리 수행 */
    ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

    // 결과값을 저장할 변수
    Professor result = null;

      // 학과 수정하기
      try {
        result = professorService.getItem(model);
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

   if (result !=null) {
        logger.debug("교수 이름: " + result.getName()); // 교수 이름 출력
            logger.debug("교수 직급: " + result.getPosition()); // 교수 직급 출력
            logger.debug("교수 ID: " + result.getUserid()); // 교수 ID 출력
            logger.debug("교수 급여: " + result.getSal()); // 교수 급여 출력
            logger.debug("교수 입사날짜: " + result.getHiredate()); // 교수 입사 날짜 출력
            logger.debug("교수 성과금: " + result.getComm()); // 교수 성과금 출력
            logger.debug("현재 학과 번호: " + result.getDeptno()); // 현재 학과 번호 출력
      } else {
        logger.debug("수정된 데이터가 없습니다");
      }

    logger.debug("==========================================");
    /** 7) 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}