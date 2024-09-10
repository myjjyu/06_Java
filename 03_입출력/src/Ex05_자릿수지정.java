public class Ex05_자릿수지정 {
  public static void main(String[] args){
    //문자열의 자릴수 지정
    System.out.printf("%10s\n","java");
    System.out.printf("%10s\n","java programming");

    // 정수의 자리수 지정
    System.out.printf("%5d\n",123);
    System.out.printf("%5d\n",1234567890);
    System.out.printf("%010d\n",1234567);

    // 실수의 자릴수 지정
    System.out.printf("%010f\n",123.4567);

    // 실수의 빈자리를 0으로 채우기
    System.out.printf("%010f\n",123.4567);
    System.out.printf("%.2f\n",123.4567);
    System.out.printf("%10.2f\n",123.4567);
    System.out.printf("%010.2f\n",123.4567);
  }
}
