public class 연습문제5 {
  public static void main(String[] args) {
    int number = 0; 

    for (int i = 100; i <= 200; i++) {
      if (i % 3 == 0) { // 3의 배수인지 체크
        number += i; // 3의 배수면 더함
      }
    }
    System.out.println(number);
  }
}

