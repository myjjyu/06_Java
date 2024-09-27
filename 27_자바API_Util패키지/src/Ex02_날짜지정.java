
import java.util.Calendar;
import kr.gilju.helpers.DatePrinter;


public class Ex02_날짜지정 {
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    DatePrinter.printfDateTime(cal);

    cal.set(Calendar.YEAR, 2024);
    cal.set(Calendar.MONTH, 9);
    cal.set(Calendar.DAY_OF_MONTH, 10);
    cal.set(Calendar.HOUR_OF_DAY, 15);
    cal.set(Calendar.MINUTE, 30);
    cal.set(Calendar.SECOND, 33);
    DatePrinter.printfDateTime(cal);

    cal.set(1982, 4,17);
    DatePrinter.printfDateTime(cal);

    cal.set(1982, 5,18,13,2,3);
    DatePrinter.printfDateTime(cal);

  }
}
