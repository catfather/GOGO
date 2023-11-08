package com.gogo.admin.board.service;

import com.gogo.admin.ProductImg.service.S3ImgService;
import com.gogo.admin.board.dto.request.SearchCriteriaBoard;
import com.gogo.admin.board.dto.request.UpdateBoard;
import com.gogo.admin.board.dto.response.BoardRes;
import com.gogo.admin.board.repository.BoardCustomRepository;
import com.gogo.admin.board.repository.BoardRepository;
import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardCustomRepository boardCustomRepository;
    private final S3ImgService s3ImgService;


    //게시글 생성
    public Long createBoard(CreateBoard create) {
        return boardRepository.save(new BoardEntity(create)).getId();
    }

    //게시글 리스트, 페이징
    public List<BoardRes> getBoardList(SearchCriteriaBoard criteria, Pageable pageable) {
        return boardCustomRepository.findBoardList(criteria, pageable).stream()
                .map(this::of)
                .collect(Collectors.toList());
    }

    //게시글 업데이트
    public Long updateBoard(UpdateBoard update) {
        BoardEntity originBoard = boardRepository.findById(update.getId()).orElseThrow(IllegalAccessError::new);
        originBoard.Update(update);
        return boardRepository.save(originBoard).getId();
    }

    private BoardRes of(BoardEntity boardEntity) {
        return BoardRes.builder()
                .createTime(boardEntity.getCreateTime())
                .writer(boardEntity.getWriter())
                .boardType(boardEntity.getBoardType())
                .content(boardEntity.getContent())
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .isDisPlay(boardEntity.getIsDisplay())
                .isDeleted(boardEntity.getIsDeleted())
                .build();
    }
}
