import java.util.Pattern;

public class Ex12_정규표현식 {
  public static void main(String[] args) {
    String name = "자바돌이";
    String age ="19";
    String email = "user@java.net";
    String phone = "01012345678";

    boolean iskor = Pattern.matches("^[ᄀ-ᄒ가-힣]*$", name);

    if(!iskor) {
      System.out.println("이름은 한글로 입력해 주세요");
    }
  }
}
