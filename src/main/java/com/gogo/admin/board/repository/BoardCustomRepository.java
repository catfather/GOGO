package com.gogo.admin.board.repository;

import com.gogo.admin.board.dto.request.SearchCriteriaBoard;

import com.gogo.admin.board.entity.BoardEntity;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface BoardCustomRepository {
//    List<BoardEntity> findBoardList(SearchCriteriaBoard criteria);

    List<BoardEntity> findBoardList(SearchCriteriaBoard criteria, Pageable pageable);
}
