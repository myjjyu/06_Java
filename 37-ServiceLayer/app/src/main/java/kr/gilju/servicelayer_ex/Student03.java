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

public class Student03 {
  public static void main(String[] args) throws Exception {
    /** 1) log4j2 객체 생성 */
    Logger logger = LogManager.getLogger(Student03.class);

    /** 2) 수정할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("수정할 학생이름: ");
    String name = scanner.nextLine();

    System.out.print("수정할 학생아이디: ");
    String userid = scanner.nextLine();

    System.out.print("수정할 학생학년: ");
    int grade = scanner.nextInt();

    scanner.nextLine(); // Consume newline

    System.out.print("수정할 주민번호: ");
    String idnum = scanner.nextLine();

    System.out.print("수정할 생일: ");
    String birthdate = scanner.nextLine();

    System.out.print("수정할 전화번호: ");
    String tel = scanner.nextLine();

    System.out.print("수정할 키(cm): ");
    int height = scanner.nextInt();

    System.out.print("수정할 몸무게(kg): ");
    int weight = scanner.nextInt();

    System.out.print("현재 학과번호: ");
    int deptno = scanner.nextInt();

    System.out.print("현재 담당교수번호: ");
    Integer profno = scanner.nextInt();

    System.out.print("현재 학생학번: ");
    int studno = scanner.nextInt();

    scanner.close();

    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) 수정할 학생 데이터 생성 */
    Student model = new Student();
    model.setName(name);
    model.setUserid(userid);
    model.setGrade(grade);
    model.setIdnum(idnum);
    model.setBirthdate(birthdate);
    model.setTel(tel);
    model.setHeight(height);
    model.setWeight(weight);
    model.setDeptno(deptno);
    model.setProfno(profno);
    model.setStudno(studno);

    /** 5) 데이터 처리 수행 */
    StudentService studentService = new StudentServiceImpl(sqlSession);
    // 결과값을 저장할 변수
    Student result = null;

    // 학과수정하기
    try {
      result = studentService.editItem(model);
    } catch (ServiceNoResultException e) {
      sqlSession.rollback();
      logger.error("[수정된 결과가 없습니다]");
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

    if (result != null) {
      logger.debug("학생 이름: " + result.getName()); 
      logger.debug("학생 ID: " + result.getUserid()); 
      logger.debug("학생 학년: " + result.getGrade()); 
      logger.debug("학생 주민번호: " + result.getIdnum()); 
      logger.debug("학생 생일: " + result.getBirthdate()); 
      logger.debug("학생 전화번호: " + result.getTel()); 
      logger.debug("학생 키: " + result.getHeight()); 
      logger.debug("학생 몸무게: " + result.getWeight());
      logger.debug("현재 학과 번호: " + result.getDeptno()); 
      logger.debug("현재 담당 교수 번호: " + result.getProfno());
      logger.debug("학생 학번: " + result.getStudno());
    } else {
      logger.debug("수정된 데이터가 없습니다");
    }

    logger.debug("==========================================");

    /** 7) 데이터베이스 접속 해제 */
    sqlSession.close();
  }
}
