import java.util.Scanner;

public class Ex05_IfElse {
  public static void main(String[] args) {
    //점수값 입력받기
    Scanner reader = new Scanner(System.in);
    System.out.print("점수를 입력하세요");
    int score = reader.nextInt();
    reader.close();

    System.out.println("시험 시작");

    if (score >= 60){
      System.out.println("합격입니다");
    }else{
      System.out.println("불합격입니다");
    }
    System.out.println("시험 끝80
    ");
  }
}
