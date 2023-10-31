package com.gogo.admin.board.service;

import com.gogo.admin.board.repository.BoardRepository;
import com.gogo.admin.board.dto.BoardDto;
import com.gogo.admin.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public String getBoardsBySearch(BoardDto boardDto) {

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.Board(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter());
        boardEntity = boardRepository.save(boardEntity);


    }
}
