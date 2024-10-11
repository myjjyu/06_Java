package kr.gilju.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Department;
import kr.gilju.services.DepartmentService;
import kr.gilju.services.impl.DepartmentServiceImpl;

public class App05 {
  public static void main(String[] args) {

    /** 1) 처리 결과를 기록할 Log4j 객체생성 */
    Logger logger = LogManager.getFormatterLogger(App02.class);

    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3) 데이터 처리 수행 */
    DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

    // 조회결과가 저장될 객체
    List<Department> result = null;

    // 학과 목록 조회하기
    try {
      result = departmentService.getList(null);
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
    /** 4) 결과 출력 */
    logger.debug("==================================");

    if (result != null) {
      int size = result.size();

      for (int i = 0; i < size; i++) {
        Department item = result.get(i);

        logger.debug("학과 번호: %d", item.getDeptno());
        logger.debug("학과 이름: %s", item.getDname());
        logger.debug("학과 위치: %s", item.getLoc());

        if (i + 1 < size) {
          logger.debug("-----------------------------------------");
        }
      }
    } else {
      logger.debug("조회된 데이터가 없습니다");
    }
    logger.debug("==========================================");
    /** 5) 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}