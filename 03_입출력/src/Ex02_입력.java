// 클래스 정의 상단에 다음의 구문을 추가함 
import java.util.Scanner;

public class Ex02_입력 {
  public static void main(String[] args) {
      // 메인 메서드 첫 라인에서 다음의 구문을 추가함 
      Scanner reader = new Scanner(System.in);

      // 문자열을 입력받고자 하는 경우
      System.out.print("이름을 입력하세요: ");
      String name = reader.nextLine();

      // 숫자값을 입력받고자 하는 경우
      System.out.print("나이를 입력하세요: ");
      int age = reader.nextInt();

      //실수값을 입력받고자 하는 경우
      System.out.print("키를 입력하세요: ");
      double height = reader.nextDouble();

      //입력값을 더 이상 사용하지 않는다면 입력기능 닫기
      reader.close();

      //결과 활용
      System.out.println("--------------");
      System.out.println(name + "님은" + age + "세이고 키는" + height + "cm 입니다.");
      System.out.println("--------------");
  }
}
