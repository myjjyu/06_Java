public class Ex17_While_Continue {
  public static void main(String[] args) {
    // int x = 0;

    // while(x<10){
    //   x++;
    //   if(x % 2 == 0){
    //     continue;//짝수인 경우  조건식으로 강제이동
    //   }
    //   System.out.println(x);
    // }

    ///// 위의 예제를 더 간결하게 만들기
    int y = 0;
    while(y<10){
      y++;
      if(y%2 !=0){
        //홀수만 출력
        System.out.println(y);
      }
    }

    System.out.println("---------------");
  }
}
///// 위의 예제를 더 간결하게 만들기

