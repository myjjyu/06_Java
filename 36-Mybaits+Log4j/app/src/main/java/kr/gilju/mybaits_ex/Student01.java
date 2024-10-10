package kr.gilju.mybaits_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Professor;

public class Student01 {
  public static void main(String[] args) {
    /** new log4h2객체생성 */
    Logger logger = LogManager.getLogger(Professor01.class);

    /** 1) 저장할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    // System.out.print("교수번호: ");
    // int profno = scanner.nextInt();

    // scanner.nextLine();

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

    System.out.print("부서번호: ");
    int deptNo = scanner.nextInt();

    scanner.close();

    // 입력값을 로그로 기록함
    logger.debug("입력된 데이터: " + name + ", " + userid + ", " + position + ", " + sal + ", " + hiredate + ", " + comm +"," + deptNo );

    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3)insert 를 수행할 데이터생성 */
    Professor professor = new Professor();
    professor.setName(name);
    professor.setUserid(userid);
    professor.setPosition(position);
    professor.setSal(sal);
    professor.setHiredate(hiredate);
    professor.setComm(comm);
    professor.setDeptNo(deptNo);

    /** 4) 데이터 저장 */
    int result = 0;

    try {
      // ProfessorMappers 이라는 namespace를 갖는 xml 에서
      // id 값이 add_professor <insert> 태그를 호출한다
      sqlSession.insert("ProfessorMapper.insert", professor);
      // 이때 , 저장할 데이터를 담고 있는 beans를 파라미터로 전달하고, 자동으로 생성된 pk는 beans에 저장된다
      result = professor.getProfNo();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    /** 결과판별 */
    logger.info(result + "번 데이터 저장됨");

    /** db 접속 해제 */
    sqlSession.commit();
    sqlSession.close();
  }
}

