package kr.gilju.model;

import lombok.Data;

@Data
public class Titanic {
    private int id;            // 승객 ID
    private boolean survived;  // 생존 여부
    private int pclass;       // 객실 등급
    private String name;      // 이름
    private String sex;       // 성별
    private Double age;          // 나이
    private int sibsp;        // 형제/자매 수
    private int parch;        // 부모/자녀 수
    private String ticket;     // 티켓 번호
    private Double fare;      // 요금
    private String cabin;     // 객실 번호 (null일 수 있음)
    private String embarked;   // 탑승 항구
}
