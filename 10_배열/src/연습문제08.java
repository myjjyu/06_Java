public class 연습문제08 {
  public static void main(String[] args) {
    String[] names = { "재석", "민영", "종민", "광수", "승기", "새정" };
    int[] points = { 82, 91, 54, 62, 88, 90 };

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        if (points[i] < points[j]) {
          int temp = points[i];
          points[i] = points[j];
          points[j] = temp;

          String tempName = names[i];
          names[i] = names[j];
          names[j] = tempName;
        }
      }
    }
    for (int i = 0; i < names.length; i++) {
      System.out.printf("%s: %d점\n", names[i], points[i]);
    }

  }
}
