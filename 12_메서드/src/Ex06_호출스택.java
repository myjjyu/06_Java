public class Ex06_호출스택 {
public static void main(String[] args) {
  System.out.println(("-----main 시작---"));
  int a =10;
  int b=f2(a);
  System.out.printf("f2(%d) = %d\n", a, b);
  System.out.println("----main 종료---");
}

public static int f1(int x){
  System.out.println("--- f1시작---");
  System.out.printf("f1(%d) = %d + 1\n", x,x);
  System.out.println("----f1종료----");
  return  x +1;
}

public static int f2(int y){
  System.out.println("--- f2시작---");
  System.out.printf("f2(%d) = f1(%d) * 2\n", y,y);
  int z = f1(y)*2;
  System.out.println("----f2종료----");
  return  z;
}
}
