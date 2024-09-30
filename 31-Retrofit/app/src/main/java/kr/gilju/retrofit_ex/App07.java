package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.TrafficAcc;
import kr.gilju.service.MySchoolService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App07 {
  public static void main(String[] args) {
    /** 1) 접속 초기화 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

    /** 2) 비즈니스 로직 처리 */
    MySchoolService service = retrofit.create(MySchoolService.class);

    // 메서드를 호출해서 call 객체를 리턴받는다
    Call<List<TrafficAcc>> call = service.getTrafficAccs();

    // Http 통신으로 json 데이터 요청하기
    call.enqueue(new Callback<List<TrafficAcc>>() {
      @Override
      public void onResponse(Call<List<TrafficAcc>> call, Response<List<TrafficAcc>> response) {
        List<TrafficAcc> list = response.body();

        for (TrafficAcc d : list) {
          System.out.printf("ID: %d,\n", d.getId());
          System.out.printf("연도: %d,\n", d.getYear());
          System.out.printf("월: %d,\n", d.getMonth());
          System.out.printf("건수: %d,\n", d.getAccident());
          System.out.printf("사망자 수: %d,\n", d.getDeath());
          System.out.printf("부상자 수: %d,\n", d.getInjury());
        }
      }

      @Override
      public void onFailure(Call<List<TrafficAcc>> call, Throwable t) {
        System.out.println("[통신 에러 발생~!!]");
        System.out.println(call.toString());
        t.printStackTrace();
      }
    });
    // 통신을 종료한다
    RetrofitHelper.getInstance().shutdown();
  }
}