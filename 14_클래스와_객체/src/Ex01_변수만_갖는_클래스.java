class Member {
  String userName = "이름";
  String email = "이메일";
  int age = 0;
}

// 퍼블릭 클래스의 이름은 소스파일 이름과 동일해야하며,
// 퍼블릭 클래스는 소스파일 하나당 하나만 존재한다
public class Ex01_변수만_갖는_클래스 {
  public static void main(String[] args) {
    Member m1 = new Member();
    System.out.println(m1.userName);
    System.out.println(m1.email);
    System.out.println(m1.age);

    Member m2 = new Member();
    System.out.println(m2.userName);
    System.out.println(m2.email);
    System.out.println(m2.age);

    m1.userName = "민혁";
    m1.email = "mh@gmail.com";
    m1.age = 20;

    m2.userName = "철수";
    m2.email = "cs@gmail.com";
    m2.age = 19;

    System.out.println(m1.userName);
    System.out.println(m1.email);
    System.out.println(m1.age);

    System.out.println(m2.userName);
    System.out.println(m2.email);
    System.out.println(m2.age);

  }
}