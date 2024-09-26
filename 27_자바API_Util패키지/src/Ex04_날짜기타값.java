import java.util.Calendar;

public class Ex04_날짜기타값 {
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();

    int day = cal.get(Calendar.DAY_OF_WEEK);
    System.out.println("요일 인덱스="+day);

    String[] day_name = {"일","월","화","수","목","금","토"};
    System.out.println("요일="+day_name[day - 1]);

    int week_count = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
    System.out.println("이번 달은="+week_count + "주로 되어 있다");

    int day_count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    System.out.println("이번 달은="+day_count + "일 까지 있다");

    cal.set(Calendar.DAY_OF_MONTH, 1);
    int frist_day = cal.get(Calendar.DAY_OF_WEEK);
    System.out.println("이번 달의 시작 요일 인덱스=" + frist_day);
    System.out.println("이번 달의 시작 요일 =" + day_name[frist_day - 1]);
  }
}
