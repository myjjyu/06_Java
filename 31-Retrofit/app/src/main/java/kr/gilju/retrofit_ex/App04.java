package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Grade;
import kr.gilju.service.MySchoolService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App04 {
  public static void main(String[] args) {
    /** 1) 접속 초기화 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

    /** 2) 비즈니스 로직 처리 */
    MySchoolService service = retrofit.create(MySchoolService.class);

    // 메서드를 호출해서 call 객체를 리턴받는다
    Call<List<Grade>> call = service.getGrades();

    // Http 통신으로 json 데이터 요청하기
    call.enqueue(new Callback<List<Grade>>() {
      @Override
      public void onResponse(Call<List<Grade>> call, Response<List<Grade>> response) {
        List<Grade> list = response.body();

        for (Grade d : list) {
          System.out.printf("학번 : %d,", d.getId());
          System.out.printf("이름 : %s,", d.getName());
          System.out.printf("학년 : %d,", d.getLevel());
          System.out.printf("성별 : %s,", d.getSex());
          System.out.printf("국어 : %d,", d.getKor());
          System.out.printf("영어 : %d,", d.getEng());
          System.out.printf("수학 : %d,", d.getMath());
          System.out.printf("과학 : %d\n,", d.getSin());
        }
      }

      @Override
      public void onFailure(Call<List<Grade>> call, Throwable t) {
        System.out.println("[통신 에러 발생~!!]");
        System.out.println(call.toString());
        t.printStackTrace();
      }
    });
    // 통신을 종료한다
    RetrofitHelper.getInstance().shutdown();
  }
}
