package com.gogo.admin.board.dto.response;

import com.gogo.admin.board.entity.utill.BOARDTYPE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BoardRes {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private BOARDTYPE boardType;
    private Integer isDisPlay;
    private Integer isDeleted;
    private LocalDateTime createTime;




}
