package kr.gilju.service;

import kr.gilju.model.BoxOffice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  BoxOfficeService {

  /**
   * 영화진흥위원회 일별 박스 오피스 api호출
   * 
   * @param targetDt 조회하고자 하는 날짜
   * @return BoxOffice 객체
   */
  @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=3882b7cb2470562d643bcf016d0a35fe")
  Call<BoxOffice> getBoxOffice(@Query("targetDt") String targetDt);
}
