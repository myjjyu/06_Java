package kr.gilju.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Student;
import kr.gilju.services.StudentService;
import kr.gilju.services.impl.StudentServiceImpl;

public class Student01 {
  public static void main(String[] args) {
    /** new log4h2객체생성 */
    Logger logger = LogManager.getLogger(Student01.class);

    /** 1) 저장할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("이름: ");
    String name = scanner.nextLine();

    System.out.print("학생아이디: ");
    String userid = scanner.nextLine();

    System.out.print("학년: ");
    int grade = scanner.nextInt();

    scanner.nextLine();

    System.out.print("주민번호: ");
    String idnum = scanner.nextLine();

    System.out.print("생일:");
    String birthdate = scanner.nextLine();

    System.out.print("전화번호: ");
    String tel = scanner.nextLine();

    System.out.print("키(cm): ");
    int height = scanner.nextInt();

    System.out.print("몸무게(kg): ");
    int weight = scanner.nextInt();

    System.out.print("학과번호: ");
    int deptno = scanner.nextInt();

    System.out.print("담당교수번호: ");
    Integer profno = scanner.nextInt();

    scanner.close();

    // 입력값을 로그로 기록함
    logger.debug("입력된 데이터:" + name + ", " + userid + ", " + grade + ", " + idnum + ", " + birthdate + ", " + tel + ", "
        + height + ", " + weight + ", " + deptno + ", " + profno);
    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3)insert 를 수행할 데이터생성 */
    Student dept = new Student(); // Student 객체 생성
    dept.setName(name);
    dept.setUserid(userid);
    dept.setGrade(grade);
    dept.setIdnum(idnum);
    dept.setBirthdate(birthdate);
    dept.setTel(tel);
    dept.setHeight(height);
    dept.setWeight(weight);
    dept.setDeptno(deptno);
    dept.setProfno(profno);

    /** 데이터 처리 수행 */
    // 비즈니스 로직을 위한 service 객체 생성
    StudentService studentService = new StudentServiceImpl(sqlSession);
    // 저장된 결과를 리턴받기 위힌 beans 객체
    Student result = null;

    // 저장된 결과를 리턴받기 위한 beans객체

    try {
      result = studentService.addItem(dept);
    } catch (ServiceNoResultException e) {
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