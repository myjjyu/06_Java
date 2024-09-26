import java.util.ArrayList;
import java.util.List;

class User {
  private String name;
  private String phoneNo;
  private String email;

  public User(String name, String phoneNo, String email) {
    this.name = name;
    this.phoneNo = phoneNo;
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" +
        " name='" + name + "'" +
        ", phoneNo='" + phoneNo + "'" +
        ", email='" + email + "'" +
        "}";
  }
}

public class Ex10_List_주소록 {
  public static void main(String[] args) {
    List<User> list = new ArrayList<User>();

    list.add(new User("철수", "010-1234-2345", "member@naver.com"));
    list.add(new User("수현", "010-2345-3456", "member2@kakao.com"));
    list.add(new User("석훈", "010-3456-4567", "member3@gmail.com"));
    list.add(new User("민영", "010-4567-5678", "member4@hanmail.com"));
    list.add(new User("호영", "010-5678-6789", "member5@icloud.com"));

    for (int i = 0; i < list.size(); i++) {
      User item = list.get(i);
      System.out.println(item.toString());
    }
  }
}
