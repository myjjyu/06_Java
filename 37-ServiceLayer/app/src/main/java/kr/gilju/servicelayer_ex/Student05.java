package kr.gilju.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Student;

public class Student05 {
  public static void main(String[] args) {
    Logger logger = LogManager.getLogger(Student02.class);
    /** 2) 데이터베이스 접속 */
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

    /** 3) 데이터 조회 */
    List<Student> result = null;

    try {
      result = sqlSession.selectList("StudentMapper.selectList", null);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    /** 4) 결과판별 */

    if (result == null) {
      System.out.println("조회결과 없음");
    } else {
      for (int i = 0; i < result.size(); i++) {
        Student item = result.get(i);

        logger.debug("학생학번: " + item.getStuDno());
        logger.debug("학생이름: " + item.getName());
        logger.debug("학생아이디: " + item.getUserid());
        logger.debug("학년: " + item.getGrade());
        logger.debug("주민번호: " + item.getIdnum());
        logger.debug("생일: " + item.getBirthdate());
        logger.debug("전화번호: " + item.getTel());
        logger.debug("키: " + item.getHeight());
        logger.debug("몸무게: " + item.getWeight());
        logger.debug("학과: " + item.getDeptNo());
        logger.debug("담당교수번호: " + item.getProfNo());
      }
    }
    /** db 접속 해제 */
    sqlSession.close();
  }
}