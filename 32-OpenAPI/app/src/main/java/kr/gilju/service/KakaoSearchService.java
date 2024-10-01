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
  @Headers({"Authorization: KakaoAK f5af340f85889a417c937a415881a2fc"})
  @GET("/v2/search/image")
  Call<KakaoImage> searchImage(@Query("query") String query);
}
