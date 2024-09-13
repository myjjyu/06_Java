public class Ex18_For_Continue {
  public static void main(String[] args) {
    int y = 0;

    for (int i = 0; i < 10; i++) {
      if (i % 2 != 0) {
        y += i;

        System.out.println(y);
      }
    }
  }
}