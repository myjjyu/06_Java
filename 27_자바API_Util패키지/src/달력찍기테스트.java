
import java.time.LocalDate;
import java.util.Scanner;

public class 달력찍기테스트 {

    public static void makeCalender(int year, int month) {

        int date = 1;       // 일
        int day;            // 요일

        LocalDate firstDate = LocalDate.of(year, month, date); // 해당월 1일 설정
        day = firstDate.getDayOfWeek().getValue();

        // 달력 출력
        System.out.println(month >= 10 ?
                String.format("[%d년 %d월]", year, month) : String.format("[%d년 %02d월]", year, month));

        System.out.println("일\t월\t화\t수\t목\t금\t토\t");

        // 1일 전까지의 공백 생성
        for (int i = 0; i < day % 7; i++) {
            System.out.print("\t");
        }

        // 달력 일 출력
        for(int i=1; i<=firstDate.lengthOfMonth(); i++) {
            System.out.printf("%02d\t", date++);
            day++;

            if(day % 7 == 0) {                // 다음 주로 줄 바꿈
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int year;
        int month;

        Scanner kb = new Scanner(System.in);

        while(true) {
            System.out.println("[달력 출력 프로그램]");
            System.out.print("달력의 년도를 입력해 주세요. (yyyy) : ");
            year = kb.nextInt();
            // 년도 음수 입력 방지
            if(year < 0) {
                System.out.println("년도 입력이 잘못되었습니다. 다시 시작합니다.\n");
                continue;
            }

            System.out.print("달력의 월을 입력해 주세요. (mm) : ");
            month = kb.nextInt();
            // 월 1~12 외 입력 방지
            if(month <= 0 || month > 12) {
                System.out.println("월 입력이 잘못되었습니다. 다시 시작합니다.\n");
                continue;
            }
            break;
        }

        System.out.println();
        makeCalender(year, month);
    }
}