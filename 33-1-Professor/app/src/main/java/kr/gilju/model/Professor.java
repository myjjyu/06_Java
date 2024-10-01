package kr.gilju.model;

import lombok.Data;

@Data
public class Professor {
  private int id; //교수 ID
  private String name; // 교수이름
  private String userid; // 교수아이디
  private String position; // 위치/직책
  private int sal; // 교수 급여
  private String hiredate; //입사날짜
  private Integer comm; // 성과금 / 숫자, null 둘다 가능 
  private int deptno; // 부서번호
}