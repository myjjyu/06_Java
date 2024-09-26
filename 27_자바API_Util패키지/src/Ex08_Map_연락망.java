import java.util.Map;
import java.util.HashMap;

class Member{
  private String phoneNo;
  private String email;

  public Member(String phoneNo, String email) {
    this.phoneNo = phoneNo;
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" + 
    " phoneNo='" + phoneNo + "'" + 
    ", email='" + email + "'"+
    "}";
  }
}

public class Ex08_Map_연락망 {
  public static void main(String[] args) {
    Map<String, Member> map = new HashMap<String, Member>();


    Member mem1 = new Member("010-1234-2345", "member1@naver.com");
  map.put("철수", mem1);

  map.put("수현", new Member("010-2345-3456", "member2@kakao.com"));
  map.put("석훈", new Member("010-3456-4567", "member3@gmail.com"));
  map.put("민영", new Member("010-4567-5678", "member4@hanmail.com"));
  map.put("호영", new Member("010-5678-6789", "member5@icloud.com"));

  Member output = map.get("호영");
  System.out.println(output.toString());
  }
}
