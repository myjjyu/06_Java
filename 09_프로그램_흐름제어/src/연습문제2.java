public class 연습문제2 {
  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {// 행
      for (int j = 0; j < 4; j++) {// 열
        System.out.printf("%d", i + j);
      }
      System.out.println();
    }
  }
}

