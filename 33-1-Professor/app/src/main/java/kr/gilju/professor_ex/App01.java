package kr.gilju.professor_ex;

import java.util.Scanner;

import kr.gilju.helpers.RetrofitHelper;
import kr.gilju.model.Professor;
import kr.gilju.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        // 정보 입력 받기
        Scanner scanner = new Scanner(System.in);

        System.out.print("id: ");
        int id = scanner.nextInt();

        scanner.nextLine();
        
        System.out.print("이름: ");
        String name = scanner.nextLine();


        System.out.print("교수아이디: ");
        String userid = scanner.nextLine();

        System.out.print("위치: ");
        String position = scanner.nextLine();

        System.out.print("급여: ");
        int sal = scanner.nextInt();

        scanner.nextLine();

        System.out.print("입사날짜: ");
        String hiredate = scanner.nextLine();

        System.out.print("성과금: ");
        Integer comm = scanner.nextInt();

        System.out.print("부서번호: ");
        int deptno = scanner.nextInt();

        scanner.close();

        // Retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        // 전송 위한 서비스 객체 호출
        ProfessorService professorService = retrofit.create(ProfessorService.class);
        Call<Professor> call = professorService.addProfessor(id, name, userid, position, sal, hiredate, comm, deptno);

        // 요청
        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if (response.isSuccessful()) {
                    Professor professor = response.body();
                    System.out.println("저장된 정보 : " + professor);
                } else {
                    System.out.println("저장 실패");
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
        });

        // 접속 해제
        RetrofitHelper.getInstance().shutdown();
    }
}
