package com.gogo.admin.board.service;

import com.gogo.admin.board.dto.request.SearchcriteriaBoard;
import com.gogo.admin.board.dto.request.UpdateBoard;
import com.gogo.admin.board.dto.response.BoardRes;
import com.gogo.admin.board.repository.BoardCustomRepository;
import com.gogo.admin.board.repository.BoardRepository;
import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardCustomRepository boardCustomRepository;


    //게시글 생성
    public Long createBoard(CreateBoard boardDto) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.BoardCreate(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter(), boardDto.getType());

        return boardRepository.save(boardEntity).getId();
    }

    //게시글 리스트
    public List<BoardRes> getBoardList(SearchcriteriaBoard criteria) {
        return boardCustomRepository.findBoardList(criteria).stream()
                .map(this::of)
                .collect(Collectors.toList());
    }

    //게시글 업데이트

    /*
        jpa 더티 체킹으로 업데이트 하기로 생각
        queryDSL 벌크 연산을 해도 다 채우지 않은 값들은 null로 치환 되어버리기 때문에
        jpa 스럽게 구현
     */

    public Long updateBoard(UpdateBoard updateBoardReq) {
        BoardEntity boardEntity = boardRepository.findById(updateBoardReq.getId()).orElse();


    }

    private BoardRes of(BoardEntity boardEntity) {
        return BoardRes.builder()
                .createTime(boardEntity.getCreateTime())
                .writer(boardEntity.getWriter())
                .boardType(boardEntity.getBoardType())
                .content(boardEntity.getContent())
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .build();

    }


}
