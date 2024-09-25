import java.util.Scanner;

public class Ex05_예외처리2 {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.print("x를 입력하세요: ");
    int x = reader.nextInt();

    System.out.print("y를 입력하세요: ");
    int y = reader.nextInt();

    reader.close();

    Calc c = Calc.getInstance();

    int z = c.divied(x, y);
    System.out.printf("[divied] %d 나누기 %d는 %d입니다\n", x, y, z);
    System.out.println("---------------");

    //throws 가 적용된 메서드를 호출할때는 try-catch에 대한 사용이 강제된다,
    // throw : 강제로 에러를 만든다

    int a = 0;

    try {
      a = c.divied(x, y);
    } catch (Exception e) {
    System.out.println("[diviedEx 에러] 0으로 나눌 수 없습니다");
    }
    System.out.printf("[divied] %d 나누기 %d는 %d입니다\n", x, y, a);
  }
}
