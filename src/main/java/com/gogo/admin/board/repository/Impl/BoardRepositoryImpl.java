package com.gogo.admin.board.repository.Impl;

import com.gogo.admin.board.dto.request.SearchCriteriaBoard;
import com.gogo.admin.board.entity.BoardEntity;
import com.gogo.admin.board.entity.QBoardEntity;
import com.gogo.admin.board.entity.utill.ORDER;
import com.gogo.admin.board.repository.BoardCustomRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    public List<BoardEntity> findBoardList(SearchCriteriaBoard criteria, Pageable pageable) {
        return jpaQueryFactory
                .select(qBoardEntity)
                .from(qBoardEntity)
                .where(
                        IdEq(criteria.getId()),
                        TitleCt(criteria.getTitle()),
                        ContentCt(criteria.getContent()),
                        WriterCt(criteria.getWriter()),
                        DateBetween(criteria.getStart(), criteria.getEnd()),
                        IsDeleteEq(criteria.getIsDeleted()),
                        IsDisPlayEq(criteria.getIsDisplay())
                )
                .offset(pageable.getOffset())   // 페이지 번호
                .limit(pageable.getPageSize())  // 한번에 보여줄 게시글 수
                .orderBy(Order(criteria.getOrder()))
                .fetch();
    }

    private BooleanExpression IsDisPlayEq(Integer isDisPlay) {
        return isDisPlay !=null ? qBoardEntity.isDisplay.eq(isDisPlay) : null;
    }

    private BooleanExpression IsDeleteEq(Integer isDelete) {
        return isDelete !=null ? qBoardEntity.isDeleted.eq(isDelete) : null;
    }


    private OrderSpecifier<LocalDateTime> Order(ORDER order) {
        if (order.equals(ORDER.DESC)) {
            return qBoardEntity.createTime.desc();
        }
        if (order.equals(ORDER.ASC)) {
            return qBoardEntity.createTime.asc();
        }
        //기본 값
        return qBoardEntity.createTime.desc();
    }

    private BooleanExpression ContentCt(String content) {
        return content != null ? qBoardEntity.content.contains(content) : null;
    }

    private BooleanExpression DateBetween(LocalDate start, LocalDate end) {
        if (start != null && end != null) {
            return qBoardEntity.createTime.between(start.atStartOfDay(), end.atTime(LocalTime.MAX));
        }
        return null;
    }

    private BooleanExpression WriterCt(String writer) {
        return writer != null ? qBoardEntity.writer.contains(writer) : null;
    }

    private BooleanExpression TitleCt(String title) {
        return title != null ? qBoardEntity.title.contains(title) : null;
    }

    private BooleanExpression IdEq(Long id) {
        return id != null ? qBoardEntity.id.eq(id) : null;

    }


}
