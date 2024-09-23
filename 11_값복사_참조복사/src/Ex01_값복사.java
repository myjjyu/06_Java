public class Ex01_값복사 {
  public static void main(String[] args) {
    int a = 10; //원본
    int b = a; //복사본
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    System.out.println("-------");

    a += 10; //원본수정
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    System.out.println("-------");

    b -= 10; //복사본수정
    System.out.println("a=" + a);
    System.out.println("b=" + b);
  }
}
