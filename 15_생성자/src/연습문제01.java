class Cylinder {
  int radius;
  int height;

  // 생성자
  Cylinder(int radius, int height) {
      this.radius = radius;
      this.height = height;
  }

  // 원기둥의 부피 계산
  double getVolume() {
      return ((this.radius * this.radius) * Math.PI) * this.height;
  }

  // 원기둥의 겉넓이 계산
  double getArea() {
      double baseArea = Math.PI * this.radius * this.radius; // 원 하나의 넓이
      double sideArea = 2 * Math.PI * this.radius * this.height; // 옆면 넓이
      return (2 * baseArea) + sideArea; // 윗면, 아랫면의 넓이 + 옆면 넓이
  }
}

public class 연습문제01 {
  public static void main(String[] args) {
      Cylinder c = new Cylinder(4, 5); // 반지름 4, 높이 5
      System.out.printf("원기둥의 부피: %.2f\n", c.getVolume());
      System.out.printf("원기둥의 겉넓이: %.2f\n", c.getArea());
  }
}
