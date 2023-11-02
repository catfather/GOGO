package com.gogo.admin.board.controller;

import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/board")
@RequiredArgsConstructor
public class boardController {

    private final BoardService boardService;

    //어드민 게시글 생성
    @PostMapping("/create")
    public Map<String, Object> postBoard(CreateBoard boardDto){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",boardService.createBoard(boardDto));
        return map;
    }

}
