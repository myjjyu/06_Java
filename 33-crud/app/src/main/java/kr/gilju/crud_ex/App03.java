package kr.gilju.crud_ex;

import java.util.List;
import java.util.Scanner;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Department;
import kr.gilju.service.DepartmentService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
  public static void main(String[] args) {
    /** 1) Scanner 를 통한 학과 이름, 위치 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("검색할 학과이름: ");
    String keyword = scanner.nextLine();

    scanner.close();

    /** 2) Retrofit 객체생성 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(DepartmentService.BASE_URL);
   
    /** 3) post 전송을 위한 서비스 객체 호출 --> 데이터 저장  */
    DepartmentService departmentService = retrofit.create(DepartmentService.class);
    Call<List<Department>> call = departmentService.listDepartment(keyword);

    /** 4) 요청 */
    call.enqueue(new Callback<List<Department>>() {

      @Override
      public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
        if(response.isSuccessful()) {
          List<Department> department = response.body();

          for(Department d : department){
            System.out.println(d);
          }
        }else {
          System.out.println("조회 실패");
        }
      }

      @Override
      public void onFailure(Call<List<Department>> call, Throwable t) {
        System.out.println("서버 연결 실패: " + t.getMessage());
      }
      
    });
    
    /** 5) 접속해제 */
    RetrofitHelper.getInstance().shutdown();
  }
}
