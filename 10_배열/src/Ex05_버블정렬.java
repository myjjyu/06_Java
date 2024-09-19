public class Ex05_버블정렬 {
  public static void main(String[] args) {
    int[] data = {1, 5, 2, 4, 3};

    for(int i=0; i<data.length-1; i++){
      for (int j = 0; j<data.length-1-i; j++){
        if (data[j] > data[j+1]) {
          int tmp = data[j];
          data[j] = data[j+1];
          data[j+1] = tmp;
        }
      }
    }
    for (int i = 0; i<data.length; i++){
      System.out.print(data[i] + "\t");
    }
  }
}