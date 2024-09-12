public class Ex10_Break제어 {
  public static void main(String[] args) {
    String grade = "B";

    switch (grade) {
      case "A":
      case "B":
      case "C":
        System.out.println("pass--(1)");
        break;
      default:
        System.out.println("not-pass -- (1)");
        break;
    }


    // 위와같음 스위치를 이프문으로 바꿈
    if(grade == "A" || grade == "B" || grade == "C"){
      System.out.println("pass--(2)");
    }else{
      System.out.println("not-pass--(2)");
    }
  }
}
