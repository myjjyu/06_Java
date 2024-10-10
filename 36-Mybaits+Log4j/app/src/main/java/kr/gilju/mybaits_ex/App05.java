package kr.gilju.mybaits_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Department;


public class App05 {
  public static void main(String[] args) {
     Logger logger = LogManager.getLogger(App02.class);

       /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /**3) 데이터 조회 */
    List<Department> result = null;

    try {
      result = sqlSession.selectList("DepartmentMapper.selectList", null);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    /** 4) 결과판별 */

    if (result == null) {
      System.out.println("조회결과 없음");
    } else {
      for (int i = 0; i < result.size(); i++) {
        Department item = result.get(i);

        logger.debug("학과번호: " + item.getDeptNo());
        logger.debug("학과명: " + item.getDname());
        logger.debug("위치: " + item.getLoc());
      }
    }
    /** db 접속 해제 */
    sqlSession.close();
  }
}