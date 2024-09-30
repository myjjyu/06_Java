package kr.gilju.model;

import lombok.Data;

@Data
public class Titanic {
  private int id;
  private String name;
  private String sex;
  private int age;
  private int sibsp;
  private String parch;
  private String ticket;
  private Double fare;
  private String cabin;
  private String embarked;
}
