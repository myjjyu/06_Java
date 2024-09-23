public class Ex03_배열의_값복사 {
  public static void main(String[] args) {
    int[] origin = {1 ,2};

    // 원본과 동일한 사이즈의 배열 생성
    int[] copy = new int[origin.length];
    // 각각의 원소를 개별적으로 복사해야한다
    copy[0] = origin[0];
    copy[1] = origin[1];

    System.out.println("origin[0]=" + origin[0]);
    System.out.println("origin[1]=" + origin[1]);
    System.out.println("copy[0]=" + copy[0]);
    System.out.println("copy[1]=" + copy[1]);
    System.out.println("----------------------");

    //복사본을 수정하더라도 원본의 변화가 없다
   copy[0] += 100;
   copy[1] += 200;

   System.out.println("origin[0]=" + origin[0]);
   System.out.println("origin[1]=" + origin[1]);
   System.out.println("copy[0]=" + copy[0]);
   System.out.println("copy[1]=" + copy[1]);
  }
}
