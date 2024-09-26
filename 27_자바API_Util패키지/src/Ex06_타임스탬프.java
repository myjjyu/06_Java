
import java.util.Calendar;


public class Ex06_타임스탬프 {
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    long ms1 = cal.getTimeInMillis();
    System.out.println(ms1);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long ms2 = System.currentTimeMillis();
    System.out.println(ms2);

    long x = ms2 - ms1;
    System.out.println(x);

    long y = x /1000;
    System.out.println(y+ "초 지났음");
  }
}
