package com.gogo.admin.board.controller;

import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.dto.request.SearchCriteriaBoard;
import com.gogo.admin.board.dto.request.UpdateBoard;
import com.gogo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/admin/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //어드민 게시글 생성
    @PostMapping("/create")
    public Map<String, Object> postBoard(@Validated @RequestBody CreateBoard boardDto) {
        return Collections.singletonMap("id", boardService.createBoard(boardDto));
    }

    //수정
    @PostMapping("/update")
    public Map<String, Object> updateBoard(@Validated @RequestBody UpdateBoard updateBoardReq) {
        return Collections.singletonMap("result", boardService.updateBoard(updateBoardReq));
    }

    //리스트 조회
    @GetMapping("/list")
    public Map<String, Object> getBoardList(@RequestBody SearchCriteriaBoard criter,
                                            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        return Collections.singletonMap("result", boardService.getBoardList(criter, pageable));

    }

}
