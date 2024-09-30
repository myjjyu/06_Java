package kr.gilju.model;

import lombok.Data;

@Data
public class TrafficAcc {
    private int id;        // 사고 ID
    private int year;      // 사고 발생 연도
    private int month;     // 사고 발생 월
    private int accident;  // 사고 건수
    private int death;     // 사망자 수
    private int injury;    // 부상자 수
}
