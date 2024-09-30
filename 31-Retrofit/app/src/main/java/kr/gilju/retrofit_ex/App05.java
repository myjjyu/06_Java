package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.News;
import kr.gilju.service.MySchoolService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
    public static void main(String[] args) {
        // 접속 초기화
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        // 2) 비즈니스 로직 처리
        MySchoolService service = retrofit.create(MySchoolService.class);

        // 메서드 호출해서 call 객체를 리턴받는다
        Call<List<News>> call = service.getNewss();

        // 비동기 통신 처리
        call.enqueue(new Callback<List<News>>() {
            
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                List<News> list = response.body();
                
                if (list != null) {
                    for (News d : list) {
                        System.out.println("Author: " + d.getAuthor());
                        System.out.println("Title: " + d.getTitle());
                        System.out.println("Description: " + d.getDescription());
                        System.out.println("URL: " + d.getUrl());
                        System.out.println("Image: " + d.getImage());
                        System.out.println("Datetime: " + d.getDatetime());
                        System.out.println("--------------------");
                    }
                } else {
                    System.out.println("Response body is null");
                }

                // 통신 종료
                RetrofitHelper.getInstance().shutdown();
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();

                // 통신 종료
                RetrofitHelper.getInstance().shutdown();
            }
        });
    }
}
