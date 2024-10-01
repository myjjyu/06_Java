package kr.gilju.service;

import kr.gilju.model.KakaoImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface  KakaoSearchService {
/**
 * 
 * @param query
 * @return
 */
  @Headers({"Authorization: KakaoAK e626a56840ed86a4931852cf4a59e0e8"})
  @GET("/v2/search/image")
  Call<KakaoImage> searchImage(@Query("query") String query);
}
