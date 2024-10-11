package kr.gilju.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Professor;

public class Professor05 {
  public static void main(String[] args) {
    Logger logger = LogManager.getLogger(Professor02.class);
    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3) 데이터 조회 */
    List<Professor> result = null;

    try {
      result = sqlSession.selectList("ProfessorMapper.selectList", null);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    /** 4) 결과판별 */

    if (result == null) {
      System.out.println("조회결과 없음");
    } else {
      for (int i = 0; i < result.size(); i++) {
        Professor item = result.get(i);

        logger.debug("교수번호: " + item.getProfNo());
        logger.debug("교수이름: " + item.getName());
        logger.debug("교수아이디: " + item.getUserid());
        logger.debug("교수직급: " + item.getPosition());
        logger.debug("교수급여: " + item.getSal());
        logger.debug("입사날짜: " + item.getHiredate());
        logger.debug("성과금: " + item.getComm());
        logger.debug("학과번호: " + item.getDeptNo());
      }
    }
    /** db 접속 해제 */
    sqlSession.close();
  }
}
