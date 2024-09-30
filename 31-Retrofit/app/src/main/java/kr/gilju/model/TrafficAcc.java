package kr.gilju.model;

import lombok.Data;

@Data
public class TrafficAcc {
  private int id;
  private int year;
  private int month;
  private int accident;
  private int death;
  private int injury;
}
