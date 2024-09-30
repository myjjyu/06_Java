package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Titanic;
import kr.gilju.service.MySchoolService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App06 {
  public static void main(String[] args) {
    /** 1) 접속 초기화 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

    /** 2) 비즈니스 로직 처리 */
    MySchoolService service = retrofit.create(MySchoolService.class);

    // 메서드를 호출해서 call 객체를 리턴받는다
    Call<List<Titanic>> call = service.getTitanics();

    // Http 통신으로 json 데이터 요청하기
    call.enqueue(new Callback<List<Titanic>>() {
      @Override
      public void onResponse(Call<List<Titanic>> call, Response<List<Titanic>> response) {
        List<Titanic> list = response.body();

        for (Titanic d : list) {
          System.out.printf("승개id : %d,\n", d.getId());
          System.out.printf("생존여부 : %s,\n", d.isSurvived()? "생존" : "사망");
          System.out.printf("객식등급 : %d,\n", d.getPclass());
          System.out.printf("이름 : %s,\n", d.getName());
          System.out.printf("성별 : %s,\n", d.getSex());
          System.out.printf("나이: %s,\n", d.getAge());
          System.out.printf("형제 및 자매: %d,\n", d.getSibsp());
          System.out.printf("부모 및 자녀: %d,\n", d.getParch());
          System.out.printf("티켓: %s,\n", d.getTicket());
          System.out.printf("요금: %.2f,\n", d.getFare());
          System.out.printf("객실번호: %s,\n", d.getCabin());
          System.out.printf("탑승번호: %s,\n", d.getEmbarked());
        }
      }

      @Override
      public void onFailure(Call<List<Titanic>> call, Throwable t) {
        System.out.println("[통신 에러 발생~!!]");
        System.out.println(call.toString());
        t.printStackTrace();
      }
    });
    // 통신을 종료한다
    RetrofitHelper.getInstance().shutdown();
  }
}