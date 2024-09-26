
import java.util.Calendar;
import java.util.Scanner;

public class 날짜처리응용 {
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    Scanner cal2 = new Scanner(System.in);

    // 년도입력하기
    System.out.print("년도를 입력하세요 :" );
    int year = cal2.nextInt();
    // 월입력하기
    System.out.print("월을 입력하세요 : ");
    int month = cal2.nextInt() - 1;
  
    // 데이타받기
    cal.set(year, month, 1);


    //이번달은 몇 주로 되어 있는가?
    int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

    // 이번달은 몇 일까지 있는가?
    int dayCout = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    // 이번달의 1일은 무슨 요일인가?
    cal.set(Calendar.DAY_OF_MONTH, 1);
    int firstDay = cal.get(Calendar.DAY_OF_WEEK);


    // 달력만들기
    int[][] data = new int[weekCount][7];
    int count = 1;

    // 행의 수 만큼 반복 ---> "주"수만큼 반복
    for (int i = 0; i < data.length; i++) {
      // 요일만큼 반복
      for (int j = 0; j < data[i].length; j++) {
        if (!(i == 0 && j + 1 < firstDay) && count <= dayCout) {
          data[i][j] = count;
          count++;
        }
      }
    }

    // 배열출력을 위한 반복문
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i][j] == 0) {
          System.out.print("\t");
        } else {
          System.out.printf("%2d\t", data[i][j]);
        }
      }
      System.out.println();
    }
  }
}
