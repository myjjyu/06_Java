package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.model.Department;
import kr.gilju.service.MySchoolService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class test {
    public static void main(String[] args) {
        // 1) 접속 초기화
        // 접속하고자 하는 기본 주소 정의 
        String baseUrl = "http://localhost:3001";

        // 통신 객체를 생성하기 위한 Builder 객체 정의 => import okhttp3.OkHttpClient;
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        // Builder 객체를 통해 통신 객체 생성 => import okhttp3.OkHttpClient;
        OkHttpClient httpClient = httpClientBuilder.build();

        // Retrofit을 생성하는 기능을 수행하는 객체 정의
        Retrofit.Builder builder = new Retrofit.Builder();

        // 기본 주소를 지정한다
        builder.baseUrl(baseUrl);

        // 통신 결과를 Gson 객체를 통해 처리하도록 Gson을 연결한다 => JSON 파싱 자동화
        // => import retrofit2.converter.gson.GsonConverterFactory;
        builder.addConverterFactory(GsonConverterFactory.create());

        // 통신 객체를 연결한다
        builder.client(httpClient);

        // 모든 설정이 반영된 Retrofit 객체를 생성한다 => import retrofit2.Retrofit;
        Retrofit retrofit = builder.build();

        // 2) 비즈니스 로직 처리
        // Retrofit 객체를 통해 서비스 객체를 생성한다 => import kr.parkjaehan.service.MySchoolService;
        MySchoolService service = retrofit.create(MySchoolService.class);

        // 메서드를 호출해서 call 객체를 리턴받는다
        Call<List<Department>> call = service.getDepartments();

        // HTTP 통신으로 JSON 데이터 요청하기
        call.enqueue(new Callback<List<Department>>() {
            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                List<Department> list = response.body();
                
                for (Department d : list){
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                // 서버로부터 응답이 정상적으로 오지 않았을 때 처리하는 부분
                System.out.println("서버로부터 응답이 정상적으로 오지 않았습니다.");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        // 3) 통신을 종료한다

        httpClient.dispatcher().executorService().shutdown();
        
    }
}
