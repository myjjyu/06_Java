public class Calc {
  private static Calc current;

  public static Calc getInstance() {
    if (current == null) {
      current = new Calc();
    }

    return current;
  }

  private Calc() {
    super();
  }

  // 런타임 에러가 발생할 가능성이 있는 메서드 안에서 직접 try~catch 를 사용
  public int divied(int x, int y) {
    int z = 0;

    try {
      z = x / y;
    } catch (Exception e) {
      System.out.println("[divied 에러] 0으로 나눌 수 없습니다");
    }
    return z;
  }

  public int diviedEx(int x, int y) throws Exception {
    return x / y;
  }
}
