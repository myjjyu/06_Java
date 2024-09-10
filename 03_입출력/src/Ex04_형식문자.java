public class Ex04_형식문자 {
  public static void main(String[] args){
    String name = "토마토";
    int age = 20;
    System.out.printf("%s님은 %d세 입니니다.\n",name, age);

    double temp = 15.789012345;
    double dust = 10.567890123;
    System.out.printf("오늘의 기온은 %f이고 미세먼지 농도는 %g 입니다.\n",temp, dust);

    String place = "신촌";
    int time = 20;
    String result = String.format("%s까지는 약 %d분이 걸립니다\n", place, time);
    System.out.println(result);
  }
}
