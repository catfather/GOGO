package com.gogo.admin.board.repository.Impl;

import com.gogo.admin.board.dto.request.SearchcriteriaBoard;
import com.gogo.admin.board.entity.BoardEntity;
import com.gogo.admin.board.entity.QBoardEntity;
import com.gogo.admin.board.repository.BoardCustomRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    QBoardEntity qBoardEntity = QBoardEntity.boardEntity;



    @Override
    public List<BoardEntity> findBoardList(SearchcriteriaBoard criteria) {
        return jpaQueryFactory
                .select(qBoardEntity)
                .from(qBoardEntity)
                .where(
                        IdEq(criteria.getId()),
                        TitleCt(criteria.getTitle()),
                        WriterCt(criteria.getWriter()),
                        DateBecriteria.getStart()
                )
                .fetch();
    }

    private BooleanExpression WriterCt(String writer) {
        return writer != null ? qBoardEntity.writer.contains(writer) : null;
    }

    private BooleanExpression TitleCt(String title) {
        return title !=null ? qBoardEntity.title.contains(title) : null;
    }

    private BooleanExpression IdEq(Long id) {
        return id != null ? qBoardEntity.id.eq(id) : null;
    }


}
