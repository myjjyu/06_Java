public class Ex03_논리값_원소_반전 {
  public static void main(String[] args) {
    boolean[] checked = { true, false, false, true, false };

    for (int i = 0; i < checked.length; i++) {
      checked[i] = !checked[i];
    }
    // 배열의 전체원소 출력
    for (int i = 0; i < checked.length; i++) {
      System.out.print(checked[i] + "\t");
    }
  }
}