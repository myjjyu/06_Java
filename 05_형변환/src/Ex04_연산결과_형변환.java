public class Ex04_연산결과_형변환 {
  public static void main(String[] args) {
    // 기본적으로 연산 결과는 피연산자의 데이터타입을 따름
    // 정수끼리의 연산결과는 정수 
    int x = 100;
    int y = 50;
    System.out.println(x+y);

    //서로다른 타입의 연산결과는 더 큰 범위의 데이터 타입으로 결과가 생성
    double m = 123.45;
    int n = 67;
    System.out.println(m + n);

    // 연산 결과에 대해 자동 형변환 가능
  int i = 10;
  int j = 20;
  double k = i + j;
  System.out.println(k);

  // 연산결과에 대하 강제 형변환 가능
  int a = (int)(10.2+3.1);
  System.out.println(a);
  }
}



