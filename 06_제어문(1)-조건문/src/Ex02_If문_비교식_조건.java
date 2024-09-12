import java.util.Scanner;

public class Ex02_If문_비교식_조건 {
  public static void main(String[] args) {
    // 입력값을 통해 정수령 변수를 준비
    Scanner reader = new Scanner(System.in);
    System.out.print("나이를 입력하세요");
    int myage = reader.nextInt();
    reader.close();

    // 변수가 19와 같은 경우에 "참"
    if (myage == 19) {
      System.out.println("19살 입니다 ....(1)");
    }
    if (myage != 19) {
      System.out.println("19살이 아닙니다 ....(2)");
    }
    if (myage > 19) {
      System.out.println("성인입니다 ....(3)");
    }
    if (myage <= 19) {
      System.out.println("학생입니다 ....(4)");
    }
  }
}