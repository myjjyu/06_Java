public class Ex02_While문_합계 {
  public static void main(String[] args) {
    int sum = 0;

    int j = 1;
    while (j < 11) {

      sum += j;

      System.out.printf("j=%d, sum=%d\n", j, sum);
      j++;
    }
  }
}