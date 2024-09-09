public class Ex04_문자열 {
  public static void main(String[] args) {
    // 문자열 변수의 선언과 할당
    String name;
    name = "자바학생";
    System.out.print(name);

    // 빈문자열
    // 내용이 없는 문자열 --> 따옴표를 열자마자 닫은 형태
    // 내용은 없지만 메모리 공간은 차지하고 있다는 점에서 존재하는 변수임

    String empty = "";
    System.out.print(empty);

    // 공백문자열
    // 띄어쓰기도 엄연한 글자
    String space = "      ";
    System.out.print(space);

    // null 값
    // 나중에 할당하기 위해서 값을 비워 놓은 형태
    // 빈 문자열이나 공백문자열은 메모리를 소비하지만 null 은 메모리를 차지하지 않는다
    String nValue = null;
    System.out.print(nValue);
  }
}
