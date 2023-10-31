package com.gogo.admin.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BoardDto {

    private String title;   //제목
    private String content; //내용
    private String writer; //작성자
    private String type; //공지사항, 글 유형 기타 등등
}
