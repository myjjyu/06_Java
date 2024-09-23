class HelloWorld {
  String message;

  void sayHello() {
    System.out.println(message);
  }

  void setEng() {
    message = "Hello Java";
  }

  void setKor() {
    message = "안녕하세요. 자바";
  }
}

public class Ex03_메서드와_변수를_갖는_클래스 {
  public static void main(String[] args) {
    HelloWorld hello = new HelloWorld();

    hello.setEng();
    hello.sayHello();

    hello.setKor();
    hello.sayHello();
  }
}
