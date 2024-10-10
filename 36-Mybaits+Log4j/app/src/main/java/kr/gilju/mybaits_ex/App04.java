package kr.gilju.mybaits_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Department;

public class App04 {
  public static void main(String[] args) {
    /** 1) log4j2객체 생성 */
    Logger logger = LogManager.getLogger(App02.class);

    /** 2 조회할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("조회할 학과 번호: ");
    int deptNo = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) select 수행할 데이터 생성 */
    Department model = new Department();
    model.setDeptNo(deptNo);

    /** 5) 데이터 조회 */
    Department result = null;

    try {
      result = sqlSession.selectOne("DepartmentMapper.selectItem", model);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    /** 6) 결과판별 */
    if (result == null) {
      System.out.println("조회결과 없음");
    } else {
      System.out.println(result.toString());
    }
    /** db 접속 해제 */
    sqlSession.close();
  }
}