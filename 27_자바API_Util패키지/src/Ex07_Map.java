import java.util.HashMap;
import java.util.Map;


public class Ex07_Map {
public static void main(String[] args) {
  //key[데이터이름]로 사용할 값에 대한 데이터 타입과
  // value(저장할 값)로 사용할 값에 대한 데이터 타입을 
  // 객체 선언시 key, value 형식으로 명시 
  Map<String, Integer> map = new HashMap<String, Integer>();

  map.put("나이", 21);
  map.put("키", 175);
  map.put("몸무게", 80);

  System.out.printf("저장된 데이터의 수: %d\n",map.size());


  System.out.printf("AGE: %d\n", map.get("나이"));
  System.out.printf("HEIGHT: %d\n", map.get("키"));
  System.out.printf("WEIGHT: %d\n", map.get("몸무게"));
}
}
