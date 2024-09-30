package kr.gilju.retrofit_ex;

import java.util.List;

import kr.gilju.model.Student;
import kr.gilju.service.MySchoolService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App03 {

    public static void main(String[] args) {
        /** 1) 점속 초기화 */
        // 접속하고자 하는 기본 주소 정의
        String baseUrl = "http://localhost:3001";
        // 통신 객체를 생성하기 위한 builder 객체 정의
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        // builder 를 통해 총신객체 생성
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
        Call<List<Student>> call = service.getStudents();

        // http 통신으로 json 데이터 요청하기
        call.enqueue(new Callback<List<Student>>() {

            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> list = response.body();

                for (Student d : list) {
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        // 통신을 종료한다.
        httpClient.dispatcher().executorService().shutdown();
    }
}
