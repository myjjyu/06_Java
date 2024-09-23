class Student {
  String name;
  int level;
  int age;

  Student(String n, int l, int a) {
    System.out.println("----------" + "이의 생성자가 실행되었습니다. ------");
  name = n;
  level = l;
  age = a;
  }
}


public class Ex02_ConstructorParams {
  public static void main(String[] args) {
    Student s1 = new Student("민철",4,24);
    Student s2 = new Student("영민",3,22);

    System.out.printf("%s, %d학년, %d세\n", s1.name, s1.level, s1.age);
    System.out.printf("%s, %d학년, %d세\n", s2.name, s2.level, s2.age);
  }
  
}
