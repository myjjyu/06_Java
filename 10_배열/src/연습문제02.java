public class 연습문제02 {
  public static void main(String[] args) {
    int[] time ={7, 5, 5, 5, 5, 10, 7};
    int sum = 0;

    for(int i = 0; i<time.length; i++){
      sum += time[i] * ((i < 4) ? 4500 : 5200);
    }

    System.out.printf("총 급여: %d\n",sum);
  }
}
