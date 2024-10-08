package kr.gilju.jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02_Select {
   public static void main(String[] args) {
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
        String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno ASC";

        /** 4) mysql 에게 sql문을 전달하고 결과를 반환받기 */
        Statement stmt = null;

        // seleclt 결과를 저장할 객체
        ResultSet rs =null;

        try {
          stmt = conn.createStatement();
          rs =stmt.executeQuery(sql);

          while (rs.next()) {
              int deptNo = rs.getInt("deptno");
              String dname = rs.getString("dname");
              String loc = rs.getString("loc");

              System.out.printf("학과번호 : %d\n", deptNo);
              System.out.printf("학과이름 : %s\n", dname);
              System.out.printf("위치 : %s\n", loc);
              System.out.println();
              
          }
        } catch (SQLException e) {
          System.out.println("========Query Error =========");
          e.printStackTrace();
        }finally {

          if (stmt != null) {
            try {
              stmt.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
        }
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
    