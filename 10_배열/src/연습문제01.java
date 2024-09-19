public class 연습문제01 {
    public static void main(String[] args) {
        int[] grade = { 75, 82, 91 };
        int sum = 0;

        for (int i = 0; i < grade.length; i++) {
            sum += grade[i];
        }

        int avg = sum / grade.length;
        System.out.printf("총점: %d\t  평균: %d\n", sum, avg);
    }
}
