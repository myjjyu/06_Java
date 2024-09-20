public class Ex08_파라미터_참조복사 {
  public static void main(String[] args) {
    int[] origin = {1, 2};
    System.out.println("origin[0]=" + origin[0]);
    System.out.println("origin[1]=" + origin[1]);
    System.out.println("-------------");


    foo(origin);
    System.out.println("origin[0]=" + origin[0]);
    System.out.println("origin[1]=" + origin[1]);
  }

  public static void foo(int[] copy){
    for(int i=0; i<copy.length, i++) {
      copy[i] += 100;
    }
    System.out.println("copy[0]=" + copy[0]);
    System.out.println("copy[1]=" + copy[1]);
    System.out.println("-------------");
  }
}
