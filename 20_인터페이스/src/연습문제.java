interface Meter{
void start();

int stop(int distance);
}
class Taxi implements Meter {

    @Override
    public void start() {
      System.out.println("출발합니다");
    }
  
    @Override
    public int stop(int distance) {
      int pay = distance * 18000;
      return pay;
    }
  }
  
 class Bus implements Meter {
    @Override
    public void start() {
      System.out.println("출발합니다");
    }
  
    @Override
    public int stop(int distance) {
      return 1500;
    }
  }


public class 연습문제 {
  public static void main(String[] args) {
    Taxi t = new Taxi();
    t.start();

    int taxiPay = t.stop(5);
    System.out.printf("택시요금: %d원\n", taxiPay);

    Bus b = new Bus();
    b.start();

    int busPay = b.stop(5);
    System.out.printf("버스요금: %d원\n", busPay);
  }
}


// 각각의 파일이 있어야 하는데 파일이 없기 때문에 
//public 생략함