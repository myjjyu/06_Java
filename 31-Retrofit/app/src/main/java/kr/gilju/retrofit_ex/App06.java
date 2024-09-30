package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Titanic;
import kr.gilju.service.MySchoolService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import okhttp3.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class App06 {
    public static void main(String[] args) {
    // 접속 초기화
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

    // 2) 비즈니스 로직 처리
    MySchoolService service = retrofit.create(MySchoolService.class);

    // 메서드 호출해서 call 객체를 리턴받는다
    Call<List<Titanic>> call = service.getTitanics();

    //메서드를 호출해서 call 객체를 리턴한다
    call.enqueue(new Callback<List<Titanic>>(){
      
      @Override
      public void onResponse(Call<List<Titanic>> call, Response<List<Titanic>> response) {
       List<Titanic> list = response.body();

        for (Titanic d : list) {
          System.out.println("getAuthor()");
          System.out.println("getTitle()");
          System.out.println("getDescription()");
          System.out.println("getUrl()");
          System.out.println("getImage()");
          System.out.println("getDatetime()");
        }
      }
      
      @Override
      public void onFailure(Call<List<Titanic>> call, Throwable t) {
        System.out.println("[통신 에러 발생~!!]");
        System.out.println(call.toString());
        t.printStackTrace();
      }
    });
    // 통신을 종료한다.
    RetrofitHelper.getInstance().shutdown();
  }
}
