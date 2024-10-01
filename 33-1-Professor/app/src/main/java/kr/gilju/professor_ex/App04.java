package kr.gilju.professor_ex;

import java.util.Scanner;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Professor;
import kr.gilju.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App04 {
  
  public static void main(String[] args) {
    /** 1) Scanner 를 통한 학과 이름, 위치 입력받기 */
    Scanner scanner = new Scanner(System.in);

    // 문자열 --> 숫자 순으로 입력받아야한다
    System.out.print("수정할 교수 아이디: ");
    int id = scanner.nextInt();
    scanner.nextLine(); 

    System.out.print("교수이름: ");
    String name = scanner.nextLine();

    System.out.print("위치: ");
    String position = scanner.nextLine();

    System.out.print("사용자 ID: ");
    String userid = scanner.nextLine();
    System.out.print("급여: ");
    int sal = scanner.nextInt();

    scanner.nextLine();

    System.out.print("입사날짜(YYYYMMDD): ");
    String hiredate = scanner.next();

    System.out.print("성과금: ");
    Integer comm = scanner.hasNextInt() ? scanner.nextInt() : null;

    System.out.print("부서 번호: ");
    int deptno = scanner.nextInt();

    scanner.close();

    /** 2) Retrofit 객체생성 */
    Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

    /** 3) post 전송을 위한 서비스 객체 호출 --> 데이터 저장 */
    ProfessorService professorService = retrofit.create(ProfessorService.class);
    Call<Professor> call = professorService.updateProfessor(id, name, userid, position, sal, hiredate, comm, deptno);

    /** 4) 요청 */
    call.enqueue(new Callback<Professor>() {
      @Override
      public void onResponse(Call<Professor> call, Response<Professor> response) {
        if (response.isSuccessful()) {
          Professor professor = response.body();

          System.out.println("수정된 교수 정보: " + professor);
        } else {
          System.out.println("저장 실패");
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