package kr.gilju.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Professor;
import kr.gilju.services.ProfessorService;
import kr.gilju.services.impl.ProfessorServiceImpl;

public class Professor05 {
  public static void main(String[] args) {

    /** 1) 처리 결과를 기록할 Log4j 객체생성 */
    Logger logger = LogManager.getLogger(Professor02.class);
    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3) 데이터 처리 수행 */
    ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

    /** 4) 데이터 조회 */
    List<Professor> result = null;

    // 학과 수정하기
    try {
      result = professorService.getList(null);
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
        Professor item = result.get(i);

        logger.debug("교수 번호: {}", item.getProfno());
        logger.debug("교수 이름: {}", item.getName());
        logger.debug("교수 직급: {}", item.getPosition());
        logger.debug("교수 ID: {}", item.getUserid());
        logger.debug("교수 급여: {}", item.getSal());
        logger.debug("교수 입사 날짜: {}", item.getHiredate());
        logger.debug("교수 성과금: {}", item.getComm());
        logger.debug("현재 학과 번호: {}", item.getDeptno());

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