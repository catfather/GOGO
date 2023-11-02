package com.gogo.admin.board.service;

import com.gogo.admin.board.dto.request.SearchcriteriaBoard;
import com.gogo.admin.board.dto.response.BoardListRes;
import com.gogo.admin.board.repository.BoardCustomRepository;
import com.gogo.admin.board.repository.BoardRepository;
import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardCustomRepository boardCustomRepository;


    //게시글 생성
    public Long createBoard(CreateBoard boardDto) {

        BoardEntity boardEntity = new BoardEntity();
        //게시글 생성
        boardEntity.BoardCreate(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter(), boardDto.getType());
        Long id = boardRepository.save(boardEntity).getId();


        return id;
    }

    //게시믈 검색
    public BoardListRes getBoardList(SearchcriteriaBoard criteria){
        boardCustomRepository.findBoardList(criteria);
        return null;
    }
}
