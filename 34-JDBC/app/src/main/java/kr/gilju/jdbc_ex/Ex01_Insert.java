package kr.gilju.jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01_Insert {
  public static void main(String[] args) {
    // 데이터베이스에 저장할 값을 사용자에게 입력 받음
    Scanner scanner = new Scanner(System.in);

    System.out.print("학과 이름을 입력하세요 :");
    String dname = scanner.nextLine();

    System.out.print("학과의 위치를 입력하세요 :");
    String loc = scanner.nextLine();

    scanner.close();

    /** 1) 데이터베이스에 접속하기 위한 정보를 변수로 구성 */
    String db_hostname = "127.0.0.1";
    int db_portnumber = 3306;
    String db_database = "myschool";
    String db_charset = "utf8";
    String db_username = "root";
    String db_password = "rlfwn";

    /** 2) 데이터베이스 접속 ==> mysql -uroot -p */
    // 접속객체 선언
    Connection conn = null;

    // 접속 주소 구성
    String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
    String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);
    // System.out.println(url);

    // MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager 클레스에 등록한다.

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      // DriverManager 객체를 사용하여 DB에 접속한다
      // 접속url, 아이디, 비밀번호 전달
      // Connection 객체를 리턴받는다
      // import java.sql.DriverManager 필요함
      conn = DriverManager.getConnection(url, db_username, db_password);
    } catch (ClassNotFoundException e) {
      System.out.println("======MySQL Driver Loading Fail=====");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("======MySQL Connection Loading Fail=====");
      e.printStackTrace();
    }
    /** 3) 수행할 SQL문을 문자열 변수로 준비 */
    String sql = "INSERT INTO department (dname, loc) VALUES ('" + dname + "','" + loc + "')";

    /** 4) mysql에게 sql문을 전달하고 결과를 반환닫기 */
    // sql문을 실행할수 있는 객체
    Statement stmt = null;
    // 결과값 (저장된 데이터의 수)
    int result = 0;

    // sql문을 실행할수 있는 객체 생성(예외처리 요구됨)

    try {
      stmt = conn.createStatement();
      result = stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println("========Query Error =========");
      e.printStackTrace();
    } finally {

      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    // 결과출력
    System.out.println(result + "개의 데이터가 저장됨");
    if (conn != null) {
      try {
        conn.close();
      } catch (Exception e) {
        System.out.println("======MySQL Disconnection Fail ====");
        System.out.println(e.getMessage());
      }
    }
  }
}
