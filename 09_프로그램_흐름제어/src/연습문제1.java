public class 연습문제1 {
  public static void main(String[] args) {
    int x = 0; // 총 경우의수

    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++) {

        if (i + j == 6) {
          System.out.printf("[%d,%d]\n", i, j);
          x++;
        }
      }
    }
    System.out.println(x);
  }
}
