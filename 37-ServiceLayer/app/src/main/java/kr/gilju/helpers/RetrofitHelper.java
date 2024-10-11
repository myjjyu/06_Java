package kr.gilju.helpers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Retrofit 객체를 생성하고 기본 설정들을 적용한 후 리턴한다.
 * 싱클톤객체 생성
 */

public class RetrofitHelper {
    private static  RetrofitHelper current;

    private OkHttpClient httpClient;

    public static  RetrofitHelper getInstance() {
        if (current == null) {
            current = new  RetrofitHelper();
        }

        return current;
    }

    public static void freeInstance() {
      current = null;
    }

    private  RetrofitHelper() {
        super();
    }

/**
 * retrofit 객체를 생성하고 기본 설정들을 적용한 후 리턴한다
 * 
 * @param baseUrl - 접근하고자 하는 api의 기본 주소
 * @return retrofit 객체
 */ 
    public Retrofit getRetrofit(String baseUrl) {
      // 통신 객체를 생성하기 위한 Builder 객체 정의
      OkHttpClient.Builder httpClienBuilder = new OkHttpClient.Builder();

      //Builder를 통해 통신객체 생성
      //--> 이 변수는 멤버 변수로 정의한다
      httpClient = httpClienBuilder.build();

      //Retrofit 을 생성하는 기능을 수행하는 객제 정의
      Retrofit.Builder builder = new Retrofit.Builder();

      // 기본 주소를 지정한다
      builder.baseUrl(baseUrl);

      // 통신 결과를 gson 객체를 통해 처리하도록 Gson 을 연결한다
      builder.addConverterFactory(GsonConverterFactory.create());

      // 통신객체를 연결한다.
      builder.client(httpClient);

      // 모든 설정이 반영된 Retrofit 객체 생성
      Retrofit retrofit = builder.build();
      return retrofit;
    }  
    /**
     * 통신 객체를 종료한다 
     */
    public void shutdown(){
      if(httpClient != null) {
        httpClient.dispatcher().executorService().shutdown();
      }
    }
}

