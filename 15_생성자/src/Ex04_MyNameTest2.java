class Foo2{
  String name = "자바";

  public void  setMyName(String name){
    name = "name";
  }
  public void printMyName() {
    System.out.println(name);
  }
}

public class Ex04_MyNameTest2 {
  public static void main(String[] args) {
    Foo2 f = new Foo2();
    f.setMyName("java");
    f.printMyName();
  }
  
}
