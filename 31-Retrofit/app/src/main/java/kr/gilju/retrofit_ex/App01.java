package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.model.Department;
import kr.gilju.service.MySchoolService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App01 {
    public static void main(String[] args) {
        /** 1) 접속 초기화 */  
        // 접속하고자 하는 기본 주소 정의
        String baseUrl = "http://localhost:3001";
        // 통신 객체를 생성하기 위한 builder 객체 정의
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        // builder 를 통해 통신객체 생성
        OkHttpClient httpClient = httpClientBuilder.build();

        // Retrofit 을 생성하는 기능을 수행하는 객체 정의
        Retrofit.Builder builder = new Retrofit.Builder();

        // 기본 주소를 지정한다
        builder.baseUrl(baseUrl);

        // 통신결과를 gson 객체를 통해 처리하도록 gson을 연결한다
        builder.addConverterFactory(GsonConverterFactory.create());

        // 통시객체를 연결한다
        builder.client(httpClient);

        // 모든 설정이 반영된 Retrofit 객체 생성
        Retrofit retrofit = builder.build();

        /** 2) 비즈니스 로직 처리 */
        MySchoolService service = retrofit.create(MySchoolService.class);


        // 메서드를 호출해서 call 객체를 리턴받는다
        Call<List<Department>> call = service.getDepartments();

        // http 통신으로 json 데이터 요청하기
        call.enqueue(new Callback<List<Department>>() {

            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                List<Department> list = response.body();

                for (Department d : list) {
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        // 통신을 종료한다.
        httpClient.dispatcher().executorService().shutdown();
    }
}
