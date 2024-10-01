package kr.gilju.openapi_ex;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.gilju.helpers.FileHelper;
import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.KakaoImage;
import kr.gilju.model.KakaoImage.Document;
import kr.gilju.service.KakaoSearchService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.Scanner;

public class App02 {
   public static void main(String[] args) {
      // 사용자로부터 검색어를 입력받는다
      Scanner scanner = new Scanner(System.in);
      System.out.print("검색어를 입력하세요: ");
      String keyword = scanner.nextLine();
      scanner.close();

      // Retrofit 객체 생성
      Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://dapi.kakao.com");

      KakaoSearchService service = retrofit.create(KakaoSearchService.class);

      Call<KakaoImage> call = service.searchImage(keyword);

      call.enqueue(new Callback<KakaoImage>() {

         @Override
         public void onResponse(Call<KakaoImage> call, Response<KakaoImage> response) {
            KakaoImage kakaoImage = response.body();
            List<Document> list = kakaoImage.getDocuments();

            // 결과 출력
            for (Document item : list) {
               System.out.printf("이미지 url: %s\n", item.getDocUrl());
               System.out.printf("썸네일 url: %s\n", item.getThumbnailUrl());
               System.out.printf("문서 url: %s\n", item.getDocUrl());
               System.out.printf("출처: %s\n", item.getDisplaySitename());
               System.out.printf("가로: %d, 세로: %d\n", item.getWidth(), item.getHeight());
               System.out.println();
            }
         }

         @Override
         public void onFailure(Call<KakaoImage> call, Throwable t) {
            System.out.println("[통신에럴발생~!!]");
            System.out.println(call.toString());
            t.printStackTrace();
         }
      });
      RetrofitHelper.getInstance().shutdown();
   }
}
