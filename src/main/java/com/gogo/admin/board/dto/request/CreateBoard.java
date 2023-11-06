package com.gogo.admin.board.dto.request;

import com.gogo.admin.board.entity.utill.BOARDTYPE;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateBoard {

    @NotNull(message = "제목은 필수 입니다")
    private String title;   //제목
    @NotNull(message = "내용은 필수 입니다")
    private String content; //내용
    @NotNull(message = "작성자는 필수 입니다")
    private String writer; //작성자
    @NotNull(message = "타입은 필수 입니다")
    private BOARDTYPE type; //공지사항, 글 유형 기타 등등
    @NotNull(message = "활성화 여부는 필수 입니다")
    private Integer isDisplay;


}
