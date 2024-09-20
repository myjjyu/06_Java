public class Ex01_메서드사용 {
  public static void main(String[] args) {
    f(); // 1회호출
    f(); // 2회호출
    }

    public static void f() {
      int x = 5;
      System.out.println(x + 1);

      x = 10;
      System.out.println(x + 1);
    }
}
