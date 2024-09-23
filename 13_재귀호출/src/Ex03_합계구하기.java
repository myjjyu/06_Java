public class Ex03_합계구하기 {
  public static void main(String[] args) {
    // sum을 호출하여 리턴값을 0에 저장
    int a = sum(10);

    // a의 값을 출력
    System.out.println(a);
  }

  // 1부터 n까지의 합츨 구하는 재귀 메소드
  public static int sum(int n) {
    if (n == 1) {
      return 1;
    }
    return n + sum(n - 1);
  }
}
