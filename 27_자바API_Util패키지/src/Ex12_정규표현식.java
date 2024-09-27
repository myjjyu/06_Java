import java.util.regex.Pattern;

public class Ex12_정규표현식 {
  public static void main(String[] args) {
    String name = "자바돌이";
    String age = "19";
    String email = "user@java.net";
    String phone = "01012345678";

    // 한글여부 검사
    boolean isKor = Pattern.matches("^[ᄀ-ᄒ가-힣]*$", name);

    if (!isKor) {
      System.out.println("이름은 한글로 입력해 주세요");
      return;
    }

    // 숫자인지 검사
    boolean isNum = Pattern.matches("^[0-9]*$", age);

    if (!isNum) {
      System.out.println("나이는 숫자로만 입력해 주세요");
      return;
    }

    // 이메일 검사
    boolean isEmail = Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", email);

    if (!isEmail) {
      System.out.println("이메일 형식이 맞지 않습니다");
      return;
    }

    // 핸드폰 번호 형식 검사
    boolean isPhone = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", phone);

    if (!isPhone) {
      System.out.println("전화번호 형식이 맞지 않습니다");
      return;
    }

    System.out.println("회원가입 절차를 진행합니다");
  }
}
