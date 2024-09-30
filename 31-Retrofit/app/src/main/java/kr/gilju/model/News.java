package kr.gilju.model;

import lombok.Data;

@Data
public class News {
    private String author;      // 작성자
    private String title;       // 제목
    private String description; // 내용
    private String url;         // URL
    private String image;       // 이미지 URL
    private String datetime;    // 날짜 및 시간
}
