import java.util.Scanner;

public class Ex01_if문 {
  public static void main(String[] args) {
    // 입력값을 통해 정수형 변수를 준비
    Scanner reader = new Scanner(System.in);
    System.out.print("점수를 입력하세요");
    int score = reader.nextInt();
    reader.close();

    // 입력값에 따른 if문 실행 
    System.out.println("시험 시작");
    if (score >= 60){
      System.out.println("합격입니다");
    }
    System.out.println("시험 끝");
  }
}
