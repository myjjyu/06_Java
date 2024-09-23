public class Ex02_팩토리얼_재귀호출 {
  public static void main(String[] args) {
    long result = factorial(5);
    System.out.println(result);
  }

  // 팩토리얼을 리턴하는 재귀 메소드
  public static int factorial(int n) {
    if (n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}
