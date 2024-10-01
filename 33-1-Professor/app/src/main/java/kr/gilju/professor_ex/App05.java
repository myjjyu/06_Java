package kr.gilju.professor_ex;

import java.util.Scanner;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Professor;
import kr.gilju.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
  public static void main(String[] args) {
    /** 1) Scanner 를 통한 학과 이름, 위치 입력받기 */
    Scanner scanner = new Scanner(System.in);

    System.out.print("삭제할 교수 번호: ");
    int id = scanner.nextInt();

    scanner.close();

    /** 2) Retrofit 객체생성 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);
   
    /** 3) post 전송을 위한 서비스 객체 호출 --> 데이터 저장  */
    ProfessorService professorService = retrofit.create(ProfessorService.class);
    Call<Professor> call = professorService.getProfessor(id);

    /** 4) 요청 */
    call.enqueue(new Callback<Professor>() {

      @Override
      public void onResponse(Call<Professor> call, Response<Professor> response) {
        if(response.isSuccessful()) {
          System.out.println("삭제 성공");
        }else{
          System.out.println("삭제 실패");
        }
      }

      @Override
      public void onFailure(Call<Professor> call, Throwable t) {
        System.out.println("서버 연결 실패: " + t.getMessage());
      }
    });

    /** 5) 접속해제 */
    RetrofitHelper.getInstance().shutdown();
  }
}

