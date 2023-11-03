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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
                        ContentCt(criteria.getContent()),
                        WriterCt(criteria.getWriter()),
                        DateBetween(criteria.getStart(),criteria.getEnd())
                )
                .orderBy(qBoardEntity.createTime.desc())
                .fetch();
    }

    private BooleanExpression ContentCt(String content) {
        return content != null ? qBoardEntity.content.contains(content) : null;
    }

    private BooleanExpression DateBetween(LocalDate start, LocalDate end) {
        if (start != null && end != null){
            return qBoardEntity.createTime.between(start.atStartOfDay(), end.atTime(LocalTime.MAX));
        }
        return null;
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
