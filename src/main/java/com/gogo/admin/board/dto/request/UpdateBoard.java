package com.gogo.admin.board.dto.request;


import com.gogo.admin.board.entity.utill.BOARDTYPE;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateBoard {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private BOARDTYPE boardType;

    private Integer isDelete;

    private Integer isDisPlay;

}
