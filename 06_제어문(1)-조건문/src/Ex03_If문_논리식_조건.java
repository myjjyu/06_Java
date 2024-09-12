import java.util.Scanner;

public class Ex03_If문_논리식_조건 {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.print("점수를 입력하세요");
    int point = reader.nextInt();
    reader.close();

    // 변수가 19와 같은 경우에 "참"
    if (point > 70 && point <=80) {
      System.out.println("c학점 입니다");
    }
    if (point > 70 || point <=80) {
      System.out.println("c학점이 아닙니다");
    }
  }
}