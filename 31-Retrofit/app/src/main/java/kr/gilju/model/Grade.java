package kr.gilju.model;

import lombok.Data;

@Data
public class Grade {
    private int id;       // 학생 ID
    private String name;  // 학생 이름
    private int level;    // 학년
    private String sex;    // 성별
    private int kor;      // 국어 점수
    private int eng;      // 영어 점수
    private int math;     // 수학 점수
    private int sin;      // 과학 점수
}
