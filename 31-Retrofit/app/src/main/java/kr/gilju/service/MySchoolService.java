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
  Call<List<Department>> getDepartments();

  @GET("/professor")
  Call<List<Professor>> getProfessors();

  @GET("/student")
  Call<List<Student>> getStudents();

  @GET("/grade")
  Call<List<Grade>> getGrades();

  @GET("/news")
  Call<List<News>> getNewss();

  @GET("/titanic")
  Call<List<Titanic>> getTitanics();

  @GET("/traffic_acc")
  Call<List<TrafficAcc>> getTrafficAccs();
}
