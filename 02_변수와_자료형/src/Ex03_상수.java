public class Ex03_상수 {
  public static void main(String[] args) {
    // 변수는 초기화 이후 다른값으로 변경 가능함
    int age = 20;
    System.out.println(20);

    age = 21;
    System.out.println(21);

    // 상수는 초기화 이후 값을 변경할수 없는 형태
    // 데이터 타입 앞에 final 키워드를 적용하여 생성
    // 선언과 할당이 통합된 형태로만 생성 가능함
    // 상수의 이름은 모두 대문자로 지정하고 스테이크 표기법을 사용하는 것이 관례
     final double PI = 3.14;
     System.out.println(PI);

    // // 상수의 값을 변경하려고 시도 --> 이 위치에서 에러발생함
    PI = 3.14159;

    // // 에러가 발생하는 위치에서 프로그램이 중단되기 때문에 아래 코드는 실행되지 않음
    System.out.println(PI);
  }
}
