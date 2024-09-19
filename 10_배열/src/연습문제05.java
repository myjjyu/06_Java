public class 연습문제05 {
  public static void main(String[] args) {
    int[] price = { 38000, 20000, 17900, 17900 };
    int[] qty = { 6, 4, 3, 5 };

    int sum = 0;

    for (int i = 0; i < price.length; i++) {
      int money = price[i] * qty[i];

      if (money >= 80000) {
        sum++;
      }
    }
    System.out.printf("무료배송은 %d개\n", sum);
  }
}
