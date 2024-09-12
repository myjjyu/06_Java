public class Ex08_Switch {
  public static void main(String[] args) {
    String grade = "B";

    switch (grade) {
      case "A":
        System.out.println("91~100 점 사이 입니다--(1)");
        break;

      case "B":
        System.out.println("81~90 점 사이 입니다--(2)");
        break;

      case "C":
        System.out.println("71~80 점 사이 입니다--(3)");
        break;
      default:
        System.out.println("70점 이하입니다--(4)");
    }

    // switch 문을 if 문으로 변경한 예시
    if (grade == "A") {
      System.out.println("91~100점 사이입니다---(2)");
    } else if (grade == "B") {
      System.out.println("81~90점 사이입니다---(2)");
    } else if (grade == "C") {
      System.out.println("71~80점 사이입니다---(2)");
    } else {
      System.out.println("70점 이하 입니다---(2)");
    }
  }
}
