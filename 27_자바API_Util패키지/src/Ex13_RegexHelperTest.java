
import kr.gilju.exceptions.StringFormatException;
import kr.gilju.helpers.RegexHelper;

public class Ex13_RegexHelperTest {
  public static void main(String[] args) {
    RegexHelper regexHelper = RegexHelper.getInstance();

    String name = "송길주";
    String age = "22";
    String email = "rlfwn528@gmail.com";
    String phone = "01012345678";

    try {
      // System.out.println("이름 검사 시작");
      regexHelper.isValue(name, "이름을 입력하세요");
      regexHelper.isKor(name, "이름은 한글만 입력하세요");
      // System.out.println("이름 검사 통과");

      // System.out.println("나이 검사 시작");
      regexHelper.isValue(age, "나이를 입력하세요");
      regexHelper.isNum(age, "나이는 숫자만 입력 가능합니다");
      // System.out.println("나이 검사 통과");

      // System.out.println("이메일 검사 시작");
      regexHelper.isValue(email, "이메일을 입력하세요");
      regexHelper.isEmail(email, "이메일 형식이 잘못되었습니다");
      // System.out.println("이메일 검사 통과");

      // System.out.println("연락처 검사 시작");
      regexHelper.isValue(phone, "연락처를 입력하세요");
      regexHelper.isPhone(phone, "연락처 형식이 잘못되었습니다");
      // System.out.println("연락처 검사 통과");


    } catch (StringFormatException e) {
      System.err.println("[Error]" + e.getMessage());
      System.err.println("-----------------------");
      e.printStackTrace();
    }
  }
}
