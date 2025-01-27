package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.News;
import kr.gilju.service.MySchoolService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
  
  public static void main(String[] args) {
    /** 1) 접속 초기화 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

    /** 2) 비즈니스 로직 처리 */
    MySchoolService service = retrofit.create(MySchoolService.class);

    // 메서드를 호출해서 call 객체를 리턴받는다
    Call<List<News>> call = service.getNewss();

    // Http 통신으로 json 데이터 요청하기
    call.enqueue(new Callback<List<News>>() {
      @Override
      public void onResponse(Call<List<News>> call, Response<List<News>> response) {
        List<News> list = response.body();

        for (News d : list) {
          System.out.printf("작성자 : %s,\n", d.getAuthor());
          System.out.printf("제목 : %s,\n", d.getTitle());
          System.out.printf("내용 : %s,\n", d.getDescription());
          System.out.printf("URL : %s,\n", d.getUrl());
          System.out.printf("이미지 : %s,\n", d.getImage());
          System.out.printf("날짜 및 시간 : %s,\n", d.getDatetime());
        }
      }

      @Override
      public void onFailure(Call<List<News>> call, Throwable t) {
        System.out.println("[통신 에러 발생~!!]");
        System.out.println(call.toString());
        t.printStackTrace();
      }
    });
    // 통신을 종료한다
    RetrofitHelper.getInstance().shutdown();
  }
}

