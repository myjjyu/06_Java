package kr.gilju.service;

import java.util.List;

import kr.gilju.model.Department;
import kr.gilju.model.Grade;
import kr.gilju.model.News;
import kr.gilju.model.Professor;
import kr.gilju.model.Student;
import kr.gilju.model.Titanic;
import kr.gilju.model.TrafficAcc;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MySchoolService {
    @GET("/department")
    Call<List<Department>> getDepartments(); // 부서 목록 가져오기

    @GET("/professor")
    Call<List<Professor>> getProfessors(); // 교수 목록 가져오기

    @GET("/student")
    Call<List<Student>> getStudents(); // 학생 목록 가져오기

    @GET("/grade")
    Call<List<Grade>> getGrades(); // 성적 목록 가져오기

    @GET("/news")
    Call<List<News>> getNewss(); // 뉴스 목록 가져오기

    @GET("/titanic")
    Call<List<Titanic>> getTitanics(); // 타이타닉 관련 데이터 가져오기

    @GET("/traffic_acc")
    Call<List<TrafficAcc>> getTrafficAccs(); // 교통사고 데이터 가져오기
}
