public class Ex03_예외처리 {
  public static void main(String[] args) {
    int[] k = { 10, 20, 30 };

    try {
      for (int i = 0; i < 5; i++);
    } catch (Exception e) {
      System.out.println("에러가 발생했습니다");
      System.out.println("에러의 원인:" + e.getMessage());


      // 시스템에 의해 출력되는 에러메시지 전문을 강제로 출력함
      System.out.println("-----------");
      e.printStackTrace();
      System.out.println("-----------");
    }finally{
      System.out.println("배열 탐색 종료");
    }
    System.out.println("fin :)");
  }
}
