package kr.gilju.mybaits_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Professor;

public class Professor03 {
  public static void main(String[] args) throws Exception {
    /** 1) log4j2객체 생성 */
    Logger logger = LogManager.getLogger(App02.class);

    /** 2 수정할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("수정할 교수이름: ");
    String name = scanner.nextLine();

    System.out.print("수정할 직급: ");
    String position = scanner.nextLine();

    System.out.print("수정할 교수ID: ");
    String userid = scanner.nextLine();

    System.out.print("수정할 급여: ");
    int sal = scanner.nextInt();

    scanner.nextLine();

    System.out.print("수정할 입사날짜(YYYYMMDD): ");
    String hiredate = scanner.next();

    System.out.print("수정할 성과금: ");
    Integer comm = scanner.hasNextInt() ? scanner.nextInt() : null;

    System.out.print("현재 학과 번호: ");
    int deptNo = scanner.nextInt();

    System.out.print("현재 교수 번호: ");
    int profNo = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) update를 수행할 데이터 생성 */
    Professor model = new Professor();
    model.setName(name);
    model.setUserid(userid);
    model.setPosition(position);
    model.setSal(sal);
    model.setHiredate(hiredate);
    model.setComm(comm);
    model.setDeptNo(deptNo);
    model.setProfNo(profNo); 

    /** 5) 데이터 수정 */
    int result = 0;
    try {
      result = sqlSession.update("ProfessorMapper.update", model);

      if (result == 0) {
        throw new Exception("수정된 데이터가 없습니다");
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    /** 6) 결과판별 */
    logger.debug(result + "개의 데이터 수정됨");

    /** db 접속 해제 */
    sqlSession.commit();
    sqlSession.close();
  }
}
