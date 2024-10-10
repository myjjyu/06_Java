package kr.gilju.models;

import lombok.Data;

@Data
public class Professor {
  private int profNo; //교수 번호
  private String name; // 교수이름
  private String userid; // 교수아이디
  private String position; // 위치/직책
  private int sal; // 교수 급여
  private String hiredate; //입사날짜
  private Integer comm; // 성과금 / 숫자, null 둘다 가능 
  private int deptNo; // 학과번호
}