package com.gogo.admin.board.dto.request;


import com.gogo.admin.board.entity.utill.BoardType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateBoard {
    @NotNull
    private Long id;
    private String title;
    private String content;
    private BoardType boardType;

    public UpdateBoard(Long id, String title, String content, BoardType boardType) {
        this.id = id;
        this.title = title;
        this.content = content;

        if (boardType == null)
        this.boardType = BoardType.BOARD;
    }
}
