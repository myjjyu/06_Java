package kr.gilju.helpers;

import java.util.Calendar;

/**
 * 날짜 객체를 출력하는 기능을 제공하는 클래스
 */
public class DatePrinter {
  /**
   * 날짜 객체를 파라미터로 받아서 그 객체가 저장하고 있는 성분값을 추출하여 출력하는 메서드
   * 
   * @param cal Calender 클래스의 객체
   */
  public static void printfDateTime(Calendar cal) {
    int yy = cal.get(Calendar.YEAR);
    int mm = cal.get(Calendar.MONTH);
    int dd = cal.get(Calendar.DAY_OF_MONTH);
    int hh = cal.get(Calendar.HOUR_OF_DAY);
    int mi = cal.get(Calendar.MINUTE);
    int ss = cal.get(Calendar.SECOND);

    System.out.printf("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초\n ",
        yy, mm, dd, hh, mi, ss);
  }
}
