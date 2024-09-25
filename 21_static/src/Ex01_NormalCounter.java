class NormalCounter {
  private int count = 0;

  public NormalCounter() {
    count++;
  }

  public int getCount() {
    return count;
  }
}


public class Ex01_NormalCounter {
public static void main(String[] args) {
  NormalCounter c1 = new NormalCounter();
  NormalCounter c2 = new NormalCounter();

  System.out.printf("c1의 count: %d\n",c1.getCount());
  System.out.printf("c2의 count: %d\n",c2.getCount());
}
}