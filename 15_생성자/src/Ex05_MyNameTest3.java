
class Bar {
  String name = "자바"; // 인스턴스 변수

  // 매개변수 없는 setMyName()
  public void setMyName() {
    String name;
    this.name = "java"; // 인스턴스 변수를 "java"로 설정
  }

  // 매개변수 있는 setMyName(String name)
  public void setMyName(String name) {
    this.name = name; // 인스턴스 변수를 전달된 name으로 설정
  }

  // 매개변수 없이 name을 출력하는 메서드
  public void printMyName() {
    System.out.println(name); // 인스턴스 변수 name을 출력
  }
}

public class Ex05_MyNameTest3 {
  public static void main(String[] args) {
    Bar b = new Bar();
    b.setMyName(); // 인스턴스 변수 name을 "java"로 설정
    b.printMyName(); // "java" 출력
  }
}
