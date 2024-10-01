package kr.gilju.openapi_ex;

import java.util.List;
import java.util.Scanner;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.BoxOffice;
import kr.gilju.model.BoxOffice.BoxOfficeResult.DailyBoxOfficeList;
import kr.gilju.service.BoxOfficeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        // 사용자로부터 날짜를 입력받는다
        Scanner scanner = new Scanner(System.in);
        System.out.println("조회할 날짜를 입력하세요 : yyyynndd ");
        String targetDt = scanner.nextLine();
        scanner.close();

        // Retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://www.kobis.or.kr/");

        // Retrofit에게 인터페이스를 연결
        BoxOfficeService service = retrofit.create(BoxOfficeService.class);

        // 메서드를 호출하고 콜 객체를 리턴
        Call<BoxOffice> call = service.getBoxOffice(targetDt);

        // http 통신으로 제이슨 데이터 요청하기
        call.enqueue(new Callback<BoxOffice>() {
            @Override
            public void onResponse(Call<BoxOffice> call, Response<BoxOffice> response) {
                // API 응답을 로그로 출력
                System.out.println("API Response: " + response.body());

                // 응답이 성공적인지 확인하고 null 체크
                if (response.isSuccessful() && response.body() != null) {
                    BoxOffice boxOffice = response.body();
                    List<DailyBoxOfficeList> list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

                    // 리스트가 null인지 체크
                    if (list == null) {
                        System.out.println("리스트가 null입니다.");
                        return;
                    }

                    // 리스트의 각 항목 출력
                    for (DailyBoxOfficeList item : list) {
                        System.out.printf("제목: %s\n", item.getMovieNm());
                        System.out.printf("관람객수: %d\n\n", item.getAudiCnt());
                    }
                } else {
                    // 응답이 실패했을 때의 처리
                    System.out.println("응답이 실패했습니다. 응답 코드: " + response.code());
                }
            }

            // 통신에 실패한 경우
            @Override
            public void onFailure(Call<BoxOffice> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });
        RetrofitHelper.getInstance().shutdown();
    }
}
