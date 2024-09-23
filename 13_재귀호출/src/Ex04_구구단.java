public class Ex04_구구단 {
  public static void main(String[] args) {
    gugudan(1);
  }

  // 파라미터값에 대한 구구단 7단을 출력하는 재귀 메서드ㅜ
  public static void gugudan(int n) {
    if (n > 9) {
      return;
    }
    System.out.printf("%d x %d = %d\n", 7, n, 7 * n);
    gugudan(n + 1);
  }
}
