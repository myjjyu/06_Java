import java.util.Scanner;

public class Ex09_Break없음 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("점수를 입력하세요");
    int score = scan.nextInt();
    scan.close();

    //브레이크가없는 스위치 문
    switch(score / 10){
      case 9:
      System.out.println("A학점 입니다 ");
      case 8:
      System.out.println("B학점 입니다 ");
      case 7:
      System.out.println("C학점 입니다 ");
      case 6:
      System.out.println("D학점 입니다 ");
      default:
      System.out.println("F학점 입니다 ");
    }
  }
}
