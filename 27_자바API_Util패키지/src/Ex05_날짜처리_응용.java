
import java.util.Calendar;


public class Ex05_날짜처리_응용 {
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();

    int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

    //이번달은 몇 일까지 있는가?
    int dayCout = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    //이번달의 1일은 무슨 요일인가?
    cal.set(Calendar.DAY_OF_MONTH, 1);
    int firstDay = cal.get(Calendar.DAY_OF_WEEK);

    //달력만들기
    int[][] data = new int[weekCount][7];
    int count = 1;

    //행의 수 만큼 반복 ---> "주"수만큼 반복
    for(int i = 0; i<data.length; i++){
      // 요일만큼 반복
      for (int j = 0; j<data[i].length; j++){
        if(!(i == 0 && j+1 < firstDay) && count <= dayCout) {
          data[i][j] = count;
          count++;
        }
      }
    }
    for (int i =0; i< data.length; i ++) {
      for(int j = 0; j< data[i].length; j++) {
        if (data[i][j] == 0){
          System.out.print("\t");
        }else {
          System.out.printf("-\t", data[i][j]);
        }
      }
      System.out.println();
    }
  }
}
