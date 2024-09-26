import java.util.Calendar;
import kr.gilju.helper.DatePrinter;

public class Ex03_날짜연산 {
  public static void main(String[] args) {
     Calendar cal = Calendar.getInstance();
    DatePrinter.printfDateTime(cal);

    cal.add(Calendar.DAY_OF_MONTH,100);
    DatePrinter.printfDateTime(cal);

    cal.add(Calendar.YEAR,-75);
    DatePrinter.printfDateTime(cal);

    cal.add(Calendar.HOUR,9);
    DatePrinter.printfDateTime(cal);

    cal.add(Calendar.MONTH,8);
    DatePrinter.printfDateTime(cal);
  }
}
