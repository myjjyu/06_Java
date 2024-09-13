public class Ex16_While_Break {
  public static void main(String[] args) {
    int times = 1; // 2배씩 커지는 값을 저장할 변수
    int count = 0;// 반복 횟루를 저장할 변수

    while (true) {
      count++;
      times *= 2; // 2배 증가
      System.out.println(times);

      if (times > 500) {
        break;// 강제종료
      }
    }

    System.out.println("총" + count + "회 수행했습니다");
  }

}
