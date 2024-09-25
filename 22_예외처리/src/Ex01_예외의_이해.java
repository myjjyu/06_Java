public class Ex01_예외의_이해 {
  public static void main(String[] args) {
    //실행중 발생하는 에러
    // 문법적 문제는 없지만 프로그램이 실행되면서 겪는 논리적 오류로 인해 발생하는 에러
    // 컴파일이 되어 실행되는 과정에서 프로그램이 다운된다
    int[] k = {10,20,30};
    // 인덱스 0~2 
    for (int i=0; i<5; i++){
      // 인덱스가 3인 데이터가 없으므로 i가 3일떼 에러 발생
      System.out.println(k[i]);
    }
    System.out.println("fin :)");
    // 에러가 발생하는 순간 프로그램이 다운되므로 아래 구문 실행 안됨
  }
}
