import java.util.Scanner;

public class 연습문제 {
  public static void main(String[] args) {
    Scanner age = new Scanner(System.in);
    System.out.print("나이를 입력하세요: ");
    int score = age.nextInt();
    age.close();

    switch (score / 10) { // 정수로 떨어지게하기위해
      case 0: // 0-9세
        System.out.println("어린이입니다");
        break;
      case 1: // 10-19세
        System.out.println("10대입니다");
        break;
      case 2: // 20-29세
        System.out.println("20대입니다");
        break;
      case 3: // 30-39세
        System.out.println("30대입니다");
        break;
      case 4: // 40-49세
        System.out.println("40대입니다");
        break;
      case 5: // 50-59세
        System.out.println("50대입니다");
        break;
      default: // 60세 이상
        System.out.println("노년층입니다");
    }
  }
}

// 비만도 구하기
