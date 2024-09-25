public class CalcSingleTon {
    private static  CalcSingleTon current;

    private static int count = 0;

    public static  CalcSingleTon getInstance() {
        if (current == null) {
            current = new  CalcSingleTon();
        }

        return current;
    }

    private  CalcSingleTon() {
        super();
        count++;
        System.out.println("CalcSingleTon에 대한 current 객체가 생성됨");
    }

    public int plus(int x, int y){
      return x + y;
    }
    public int minus(int x, int y){
      return x - y;
    }
    public int times(int x, int y){
      return x * y;
    }
    public int divied(int x, int y){
      return x / y;
    }
}