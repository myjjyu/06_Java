package kr.gilju.service;

import kr.gilju.model.Department;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DepartmentService {
  public static final String BASE_URL = "http://localhost:3001";


  /**
   * 학과 정보 저장
   * 
   * @param dname 학과이름
   * @param loc 위치
   * @return Department 객체
   */
  @FormUrlEncoded 
  @POST("/department")
  Call<Department> addDepartment(@Field("dname") String dname, @Field("loc") String loc);

  void updateDepartment();

  void deleteDepartment();

  void listDepartment();

  void getDepartment();
}
