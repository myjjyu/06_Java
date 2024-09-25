public class Ex04_SingleTonPattern {
  public static void main(String[] args) {
    int x = 100;
    int y = 50;

    // 메모리 낭비
    Calc c1 = new Calc();
    System.out.printf("%d + %d = %d\n", x, y, c1.plus(x, y));

    Calc c2 = new Calc();
    System.out.printf("%d - %d = %d\n", x, y, c2.minus(x, y));

    Calc c3 = new Calc();
    System.out.printf("%d * %d = %d\n", x, y, c3.times(x, y));

    Calc c4 = new Calc();
    System.out.printf("%d / %d = %d\n", x, y, c4.divied(x, y));
    System.out.println("--------------");

    // 위의 방법을 메모리 절약에 효율적으로 ~!
    Calc c5 = new Calc();
    System.out.printf("%d + %d = %d\n", x, y, c5.plus(x, y));
    System.out.printf("%d - %d = %d\n", x, y, c5.minus(x, y));
    System.out.printf("%d * %d = %d\n", x, y, c5.times(x, y));
    System.out.printf("%d / %d = %d\n", x, y, c5.divied(x, y));
    System.out.println("---------");

    // 싱글톤 객체 생성하여 활용하기
    CalcSingleTon cs1 = CalcSingleTon.getInstance();
    System.out.printf("%d + %d = %d\n", x, y, cs1.plus(x, y));

    CalcSingleTon cs2 = CalcSingleTon.getInstance();
    System.out.printf("%d - %d = %d\n", x, y, cs2.minus(x, y));

    CalcSingleTon cs3 = CalcSingleTon.getInstance();
    System.out.printf("%d * %d = %d\n", x, y, cs3.times(x, y));

    CalcSingleTon cs4 = CalcSingleTon.getInstance();
    System.out.printf("%d / %d = %d\n", x, y, cs4.divied(x, y));

  }
}
