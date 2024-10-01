package kr.gilju.openapi_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.BoxOffice;
import kr.gilju.model.BoxOffice.BoxOfficeResult.DailyBoxOfficeList;
import kr.gilju.service.BoxOfficeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;

import java.util.Scanner;

public class App01 {
    public static void main(String[] args) {
        // 사용자로부터 날짜를 입력받는다
        Scanner scanner = new Scanner(System.in);
        System.out.println("조회할 날짜를 입력하세요 : yyyynndd ");
        String targetDt = scanner.nextLine();
        scanner.close();

        // Retrofit 객제생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://www.kobis.or.kr/");

        // Retrofit에게 인터페이스를 연결
        // 통신 객체로부터 서비스에 대한 구현체 자동 생성
        BoxOfficeService service = retrofit.create(BoxOfficeService.class);

        // 메서드를 호출하고 콜 객체를 리턴
        Call<BoxOffice> call = service.getBoxOffice(targetDt);

        // http 통신으로 제이슨 데이터 요청하기
        call.enqueue(new Callback<BoxOffice>() {

            @Override
            public void onResponse(Call<BoxOffice> call, Response<BoxOffice> response) {
                BoxOffice boxOffice = response.body();
                List<DailyBoxOfficeList> list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

                for (DailyBoxOfficeList item : list) {
                    System.out.printf("제목:%s\n", item.getMovieNm());
                    System.out.printf("관람객수: %d\n\n", item.getAudiCnt());
                }
            }
            // 통신에 실패한경우
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
