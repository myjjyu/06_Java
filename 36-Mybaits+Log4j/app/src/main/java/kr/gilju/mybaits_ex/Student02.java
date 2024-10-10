package kr.gilju.mybaits_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.gilju.MyBatisConnectionFactory;
import kr.gilju.models.Student;

public class Student02 {
  public static void main(String[] args) throws Exception {
    /** 1) log4j2객체 생성 */
        Logger logger = LogManager.getLogger(Student02.class);

          /** 2 저장할 데이터와 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 학생 학번: ");
        int stuDno = scanner.nextInt();

        scanner.close();

        /**3) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        /** 4) delete 를 수행할 데이터 생성 */
        Student model = new Student();
        model.setStuDno(stuDno);

        /** 5)데이터 삭제  */
        int result = 0;
        try {
          result = sqlSession.delete("StudentMapper.delete", model);
        } catch (Exception e) {
          logger.error(e.getMessage());
        }
        /** 6) 결과판별 */
        logger.debug(result + "개의 데이터 삭제됨");
        
        /** db 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
      }
    }

