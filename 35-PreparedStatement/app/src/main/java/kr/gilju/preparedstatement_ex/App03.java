//조회

package kr.gilju.preparedstatement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.gilju.helpers.DBHelper;

public class App03 {
  public static void main(String[] args) {
    /** 1) 조회할 교수의 이름 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("교수이름: ");
    String pname = scanner.nextLine();

    scanner.close();

    /** 2) sql구문 정의하기 */
    // like 연산을 위해 앞뒤에 % 를 붙여준다
    String sql = "SELECT profno, name, userid, position, sal, "
        + "hiredate, comm, deptno FROM professor "
        + "WHERE name LIKE concat('%', ?, '%')";

    /** 3) dbhelper 를 통한 db접속처리 */
    Connection conn = DBHelper.getInstance().open();

    /** 4) sql 구문 실행하기 */
    // sql 문의 템플릿을 사용하여 쿼리 실행을 준비하는 객체
    PreparedStatement pstmt = null;

    // select 결과를 저장할 객체
    ResultSet rs = null;

    try {
      // pstmt 객체할당 --> auto_incrment 값을 받을 필요가 없기 때문에 옵션을 설정하지 않는다
      pstmt = conn.prepareStatement(sql);

      // sql문의 ? 자리에 데이터를 바인딩
      pstmt.setString(1, pname);

      // sql문 실행하기 -> rssultset 리턴됨
      rs = pstmt.executeQuery();

      while (rs.next()) {
        int profNo = rs.getInt("profno");
        String name = rs.getString("name");
        String userId = rs.getString("userid");
        String position = rs.getString("position");
        int sal = rs.getInt("sal");
        String hiredate = rs.getString("hiredate");
        int comm = rs.getInt("comm");
        int deptno = rs.getInt("deptno");

        System.out.printf("교수번호: %d\n", profNo);
        System.out.printf("이름: %s\n", name);
        System.out.printf("아이디: %s\n", userId);
        System.out.printf("직급: %s\n", position);
        System.out.printf("급여: %d\n", sal);
        System.out.printf("입사일: %s\n", hiredate);
        System.out.printf("보직수당: %d\n", comm);
        System.out.printf("학과번호: %d\n", deptno);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (pstmt != null) {
        // 객체닫기
        try {
          pstmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    /** db 접속해제 */
    DBHelper.getInstance().close();
  }
}
