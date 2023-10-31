package com.gogo.admin.board.controller;

import com.gogo.admin.board.dto.BoardDto;
import com.gogo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/board")
@RequiredArgsConstructor
public class boardController {

    private final BoardService boardService;

    //어드민 게시글 생성
    @PostMapping("/create")
    public String postBoard(BoardDto boardDto){
        boardService.getBoardsBySearch(boardDto);
        return "test";
    }

}
