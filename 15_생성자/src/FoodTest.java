class Food {
  // 필드: 음식 이름과 가격
  private String name;
  private int price;

  // 생성자: 이름과 가격을 받아서 초기화
  public Food(String name, int price) {
      this.name = name;
      this.price = price;
  }
  
  public String toString() {
      return "Food { name: " + name + ", price: " + price + "원 }";
  }
}

// FoodTest 클래스 정의
public class FoodTest {
  public static void main(String[] args) {
      // 음식 객체 생성
      Food chicken = new Food("치킨", 18000);
      Food pizza = new Food("피자", 28000);
      Food sushi = new Food("초밥세트", 22000);

      // 객체 출력
      System.out.println(chicken.toString());
      System.out.println(pizza.toString());
      System.out.println(sushi.toString());
  }
}
