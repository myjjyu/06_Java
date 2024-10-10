package kr.gilju.mybaits_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Student;

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
    int deptNo = scanner.nextInt();

    System.out.print("담당교수번호: ");
    Integer profNo = scanner.nextInt();

    scanner.close();

    // 입력값을 로그로 기록함
    logger.debug("입력된 데이터:" + name + ", " + userid + ", " + grade + ", " + idnum + ", " + birthdate + ", " + tel + ", " + height + ", " + weight + ", " + deptNo + ", " + profNo);
    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3)insert 를 수행할 데이터생성 */
    Student student = new Student(); // Student 객체 생성
        student.setName(name);
        student.setUserid(userid);
        student.setGrade(grade);
        student.setIdnum(idnum);
        student.setBirthdate(birthdate);
        student.setTel(tel);
        student.setHeight(height);
        student.setWeight(weight);
        student.setDeptNo(deptNo);
        student.setProfNo(profNo);

    /** 4) 데이터 저장 */
    int result = 0;

    try {
     // StudentMapper라는 namespace를 갖는 xml에서
     // id 값이 insert인 <insert> 태그를 호출한다.
      sqlSession.insert("StudentMapper.insert", student);
      // 이때 , 저장할 데이터를 담고 있는 beans를 파라미터로 전달하고, 자동으로 생성된 pk는 beans에 저장된다
      result = student.getStuDno();
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

