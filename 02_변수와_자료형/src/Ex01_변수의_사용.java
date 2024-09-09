public class Ex01_변수의_사용 {
  public static void main(String[] args) {
    /** 1)선언(declaration) 과 할당(정의, defintion)을 분리 */
    // 정수령 변수 a를 선언--> 메모리의 특정 위치에 4칸을 점유
    int a;
    // a에 100을 할당 (기록)
    a = 100;
    System.out.println(a);

    /** 2) 선언과 할당을 통합 */
    // 정수형 변수 b를 선언하고 a에 기록된 내용을 복사
    int b = a;
    System.out.println(b);

    /** 3) 실수형 변수 */
    // double 타입은 메모리의 8칸을 점유하고 소수점을 포함한 값을 저장한다
    double c = 3.14;
    System.out.println(c);

    /** 4) 논리형 변수 */
    boolean d = true;
    System.out.println(d);
  }
}
