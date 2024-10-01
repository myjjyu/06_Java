package kr.gilju.crud_ex;

import java.util.Scanner;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Department;
import kr.gilju.service.DepartmentService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
  public static void main(String[] args) {
    /** 1) Scanner 를 통한 학과 이름, 위치 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("조회할 학과 번호: ");
    int id = scanner.nextInt();

    scanner.close();

    /** 2) Retrofit 객체생성 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(DepartmentService.BASE_URL);
   
    /** 3) post 전송을 위한 서비스 객체 호출 --> 데이터 저장  */
    DepartmentService departmentService = retrofit.create(DepartmentService.class);
    Call<Department> call = departmentService.getDepartment(id);

    /** 4) 요청 */
    call.enqueue(new Callback<Department>() {

      @Override
      public void onResponse(Call<Department> call, Response<Department> response) {
        if(response.isSuccessful()) {
          Department department = response.body();
          System.out.println("조회된 학과 정보: " + department);
        }else{
          System.out.println("저장 실패");
        }
      }

      @Override
      public void onFailure(Call<Department> call, Throwable t) {
        System.out.println("서버 연결 실패: " + t.getMessage());
      }
    });

    /** 5) 접속해제 */
    RetrofitHelper.getInstance().shutdown();
  }
}
