package kr.gilju.models;

import lombok.Data;

/**
 * Department 테이블의 구조를 정의하는 클래스
 */
@Data
public class Department {
  private int deptNo; 
  private String dname;
  private String loc;
}
