package com.gogo.admin.board.dto.response;

import com.gogo.admin.board.entity.utill.BoardType;
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

    private BoardType boardType;

    private LocalDateTime createTime;


}
