package kr.gilju.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Student;

public class Student03 {
  public static void main(String[] args) throws Exception {
    /** 1) log4j2객체 생성 */
    Logger logger = LogManager.getLogger(Student02.class);

    /** 2 수정할 데이터와 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("수정할 학생이름: ");
    String name = scanner.nextLine();

    System.out.print("수정할 학생아이디: ");
    String userid = scanner.nextLine();

    System.out.print("수정할 학생학년: ");
    int grade = scanner.nextInt();

    scanner.nextLine();

    System.out.print("수정할 주민번호: ");
    String idnum = scanner.nextLine();

    System.out.print("수정할 생일:");
    String birthdate = scanner.nextLine();

    System.out.print("수정할 전화번호: ");
    String tel = scanner.nextLine();

    System.out.print("수정할 키(cm): ");
    int height = scanner.nextInt();

    System.out.print("수정할 몸무게(kg): ");
    int weight = scanner.nextInt();

    System.out.print("현재 학과번호: ");
    int deptNo = scanner.nextInt();

    System.out.print("현재 담당교수번호: ");
    Integer profNo = scanner.nextInt();

    System.out.print("현재 학생학번 ");
    int stuDno = scanner.nextInt();

    scanner.close();
    /** 3) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 4) update를 수행할 데이터 생성 */
    Student model = new Student(); // Student 객체 생성
    model.setName(name);
    model.setUserid(userid);
    model.setGrade(grade);
    model.setIdnum(idnum);
    model.setBirthdate(birthdate);
    model.setTel(tel);
    model.setHeight(height);
    model.setWeight(weight);
    model.setDeptNo(deptNo);
    model.setProfNo(profNo);
    model.setStuDno(stuDno);

    /** 5) 데이터 수정 */
    int result = 0;
    try {
      result = sqlSession.update("StudentMapper.update", model);

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