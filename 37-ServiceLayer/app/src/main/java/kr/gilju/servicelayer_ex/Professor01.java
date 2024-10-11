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

public class Professor01 {
  public static void main(String[] args) {
    /** new log4h2객체생성 */
    Logger logger = LogManager.getLogger(Professor01.class);

    /** 1) 저장할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("이름: ");
    String name = scanner.nextLine();

    System.out.print("교수아이디: ");
    String userid = scanner.nextLine();

    System.out.print("직급: ");
    String position = scanner.nextLine();

    System.out.print("급여: ");
    int sal = scanner.nextInt();

    scanner.nextLine();

    System.out.print("입사날짜: ");
    String hiredate = scanner.nextLine();

    System.out.print("성과금: ");
    Integer comm = scanner.nextInt();

    System.out.print("학과번호: ");
    int deptno = scanner.nextInt();

    scanner.close();

    // 입력값을 로그로 기록함
    logger.debug("입력된 데이터: " + name + ", " + userid + ", " + position + ", " + sal + ", " + hiredate + ", " + comm +"," + deptno );

    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3)저장될 데이터를 담고 있는 beans 객체 생서 */
    Professor dept = new Professor();
    dept.setName(name);
    dept.setUserid(userid);
    dept.setPosition(position);
    dept.setSal(sal);
    dept.setHiredate(hiredate);
    dept.setComm(comm);
    dept.setDeptno(deptno);

    /** 데이터 처리 수행 */
    // 비즈니스 로직을 위한 service 객체 생성
    ProfessorService professorService = new ProfessorServiceImpl(sqlSession);
    // 저장된 결과를 리턴받기 위힌 beans 객체
    Professor result = null;

   // 저장된 결과를 리턴받기 위한 beans객체
   
    try {
      result = professorService.addItem(dept);
    }catch (ServiceNoResultException e) {
      sqlSession.rollback();
      logger.error("[저장된 결과가 없습니다.]");
      logger.error(e.getMessage());

    } catch (Exception e) {
      sqlSession.rollback();
      logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요]");
      logger.error(e.getMessage());
    
    } finally {
      sqlSession.commit();
    }


    /** 처리 결과 출력 */
    if (result != null) {
      logger.debug("==========================================");
      logger.debug(result.toString());
      logger.debug("==========================================");

    } else {
      logger.error("저장된 데이터가 없습니다");
    }
    /** 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}