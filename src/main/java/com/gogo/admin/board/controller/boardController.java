package com.gogo.admin.board.controller;

import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.dto.request.SearchcriteriaBoard;
import com.gogo.admin.board.dto.request.UpdateBoard;
import com.gogo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class boardController {

    private final BoardService boardService;

    //어드민 게시글 생성
    @PostMapping("/create")
    public Map<String, Object> postBoard(@RequestBody CreateBoard boardDto) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",boardService.createBoard(boardDto));
        for (int i = 0 ; i <200; i++){
            boardService.createBoard(boardDto);
        }
        return Collections.singletonMap("id", boardService.createBoard(boardDto));
    }

    @PostMapping("/update")
    public Map<String, Object> updateBoard(@RequestBody UpdateBoard updateBoardReq){
        return Collections.singletonMap("result",boardService.updateBoard(updateBoardReq));
    }

    @GetMapping("/list")
    public Map<String, Object> getBoardList(SearchcriteriaBoard criter) {

        return Collections.singletonMap("result", boardService.getBoardList(criter));
    }
}
