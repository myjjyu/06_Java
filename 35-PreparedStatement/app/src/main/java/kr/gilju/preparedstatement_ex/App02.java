// 삭제

package kr.gilju.preparedstatement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import kr.gilju.helpers.DBHelper;

public class App02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("학번: ");
    int studno = scanner.nextInt();

    scanner.close();

 /** 2) sql구문 정의하기 */
    String sql = "DELETE FROM student WHERE studno=?";

    /** 3) dbhelper 를 통한 db접속처리 */
    Connection conn = DBHelper.getInstance().open();

    /** 4) sql 구문 실행하기 */
    // sql 문의 템플릿을 사용하여 쿼리 실행을 준비하는 객체
    PreparedStatement pstmt = null;

    // 결과값 (삭제된 데이터의 값)
    int result = 0;

    try {
      // pstmt 객체할당 --> auto_incrment 값을 받을 필요가 없기 때문에 옵션을 설정하지 않는다
      pstmt = conn.prepareStatement(sql);

      // sql문의 ? 자리에 데이터를 바인딩
      pstmt.setInt(1, studno);

      // sql문 실행하기 -> 결과 행 리턴됨 (주의! 파라미터 없음)
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        // 객체닫기
        try {
          pstmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

    /** 5) 결과출력 */
    System.out.println(result + " Record Deleted");
    /** 6) db 접속해제 */
    DBHelper.getInstance().close();
  }
}