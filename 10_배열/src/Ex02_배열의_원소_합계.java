public class Ex02_배열의_원소_합계 {
  public static void main(String[] args) {
    int[] point = {98, 72, 86, 90, 80, 77};
    int sum = 0;

    //배열의 모든 원소를 탐색할수있는 반목문 
    for(int i =0; i<point.length; i++){
      sum += point[i];
    }

    int avg = sum / point.length;
    System.out.printf("총점은 %d, 평균은 %d 입니다.\n", sum, avg);
  }
}