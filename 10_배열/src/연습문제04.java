public class 연습문제04 {
  public static void main(String[] args) {
    int[] price = { 38000, 20000, 17900, 17900 };
    int[] qty = { 6, 4, 3, 5 };

    int max = 0;

    for (int i = 1; i < price.length; i++) {
      int money = price[i] * qty[i];
      // System.out.println(money);
      if (money > max) {
        max = money;
      }
    }

    System.out.printf("가장 비싼 항목의 금액은: %d\n", max);
  }
}
