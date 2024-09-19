public class 연습문제06 {
  public static void main(String[] args) {
    int[] money = { 209000, 109000, 119000, 109000, 94000 };

    for (int i = 0; i < money.length - 1; i++) {
      for (int j = 0; j < money.length - 1 - i; j++) {
        if (money[j] > money[j + 1]) {
          int tmp = money[j];
          money[j] = money[j + 1];
          money[j + 1] = tmp;
        }
      }
    }
    for (int i = 0; i < money.length; i++) {
      System.out.print(money[i] + "\t");
    }
  }
}
