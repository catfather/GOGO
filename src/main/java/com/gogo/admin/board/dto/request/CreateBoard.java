package com.gogo.admin.board.dto.request;

import com.gogo.admin.board.entity.utill.BoardType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBoard {

    @NotNull
    private String title;   //제목
    @NotNull
    private String content; //내용
    @NotNull
    private String writer; //작성자
    @NotNull
    private BoardType type; //공지사항, 글 유형 기타 등등
}
