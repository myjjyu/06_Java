
class Person {
  String name;
  int age;
  String address;

  Person() {
    this.name = " 이름없음 ";
    this.age = 1;
    this.address = "주소없음";
  }

  Person(String name) {
    this.name = name;
    this.age = 1;
    this.address = "주소없음";
  }

  Person(String name, int age) {
    this.name = name;
    this.age = age;
    this.address = "주소없음";
  }

  Person(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }
  public String toString() {
    return String.format("이름:%s, 나이: %d, 주소:%s", this.name, this.age, this.address);
}
}

public class Ex06_생성자_오버로딩 {
  public static void main(String[] args) {
    Person p1 = new Person();
    System.out.println(p1.toString());

    Person p2 = new Person("홍길동");
    System.out.println(p2.toString());

    Person p3 = new Person("김철수", 20);
    System.out.println(p3.toString());

    Person p4 = new Person("이영희", 20, "서울시 강남구");
    System.out.println(p4.toString());
  }
}

