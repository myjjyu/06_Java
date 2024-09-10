public class Ex03_강제형변환 {
  public static void main(String[] args) {
    // double 자료형에 정수를 대입하면 자동 형변환이 발생하여 100.0이 된다
    double score = 100;
    System.out.println(score);

    // 강제로 형변환을 처리할 경우 대입할 변수 앞에 변환하고자 하는 타입을 명시
    int score2=(int) score;
    System.out.println(score2);

    double pi = 3.141592D;
    System.out.println(pi);

    //실수 타입을 정수로 변환할 경우 소수점 이하는 모두 버린다
    // ---> 데이터의 손실을 감수함
    int pint = (int)pi;
    System.out.println(pint);
  }
}
