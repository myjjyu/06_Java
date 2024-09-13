public class Ex06_중첩반목분 {
  public static void main(String[] args) {
    for(int i = 0; i < 3; i++) {
      System.out.println("j에 대한 반복수행 >> i=" + i);

      int j = 0;  // j를 for 루프 외부에서 선언
      for(j = 0; j < 5; j++) {
        System.out.printf("\ti=%d, j=%d\n", i, j);
      }
      
      System.out.println("j에 대한 반복 수행 종료 >> j = " + j);
    }
  }
}
