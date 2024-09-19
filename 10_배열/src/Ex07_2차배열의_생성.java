public class Ex07_2차배열의_생성 {
  public static void main(String[] args) {
    int[][] arr1;

    //2차 배열의 할당 --> 2개의 행으로만 생성
    arr1 = new int[2][];

    int[] hello = {10, 20, 30};
    int[] world = {40, 50, 60};
    arr1[0] = hello;
    arr1[1] = world;

    // 2차배열의 생성
    int[][] arr2;
    //2차 배열의 할당 --> 2행 3열
    arr2 = new int[2][3];
    arr2[0] = hello;
    arr2[1] = world;

    System.out.println(arr2[0][0]);
    System.out.println(arr2[0][1]);
    System.out.println(arr2[0][2]);
    System.out.println(arr2[1][0]);
    System.out.println(arr2[1][1]);
    System.out.println(arr2[1][2]);
    System.out.println("--------");

    // 2차 배열의 생성 일괄지정
    int[][] arr3 = {{1,2,3},{10,20,30}};
    System.out.println(arr3[0][0]);
    System.out.println(arr3[0][1]);
    System.out.println(arr3[0][2]);
    System.out.println(arr3[1][0]);
    System.out.println(arr3[1][1]);
    System.out.println(arr3[1][2]);
  }
}