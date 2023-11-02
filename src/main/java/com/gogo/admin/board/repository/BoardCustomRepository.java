package com.gogo.admin.board.repository;

import com.gogo.admin.board.dto.request.SearchcriteriaBoard;
import com.gogo.admin.board.entity.BoardEntity;

import java.util.List;

public interface BoardCustomRepository {
    List<BoardEntity> findBoardList(SearchcriteriaBoard criteria);
}
