public class Ex04_ArrayCopy {
  public static void main(String[] args) {
    int[] origin = { 1, 2, 3, 4, 5 };
    // 원본과 동일한 사이즈의 배열 생성
    int[] copy = new int[origin.length];

    System.arraycopy(origin, 0, copy, 1, 3);

    for (int i = 0; i < origin.length; i++) {
      System.out.printf("origin[%d]=%d \t copy[%d]=%d\n", i, origin[i], i, copy[i]);
    }
    System.out.println("------------------");

    // 주로 다음과 같이 사용됨 ---> 통째로 복사
    System.arraycopy(origin, 0, copy, 0, origin.length);

    for (int i = 0; i < origin.length; i++) {
      System.out.printf("origin[%d]=%d \t copy[%d]=%d\n", i, origin[i], i, copy[i]);
    }
  }
}
