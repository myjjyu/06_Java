public class Ex02_리터럴 {
  public static void main(String[] args) {
    // 정수형태의 리터럴은 int 로 인식된다

    System.out.println(100);
    // 정수의 리터럴은 변수의 datatype 에 따라 자동 식별된다
    int num1 = 100;
    System.out.println(num1);

    double num2 = 100;
    System.out.println(num2);

    // 실수의 리터럴 값 뒤에 데이터 타입의 첫 글자 를 지정해서 구분해야함
    // --> 지정하지 않은경우 double로 인식
    // --> 첫 글자는 대소문자 구분 없음
    float num3 = 3.14F;
    System.out.println(num3);

    double num4 = 3.14D;
    System.out.println(num4);

    // int 형의 리터럴 문자는 없지만 double은 D라고 명시하는것이 가능
    double num5 = 100D;
    System.out.println(num5);
  }
}
