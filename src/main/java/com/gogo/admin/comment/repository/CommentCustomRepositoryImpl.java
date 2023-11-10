package com.gogo.admin.comment.repository;

import com.gogo.admin.comment.entity.CommentEntity;
import com.gogo.admin.comment.entity.QCommentEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentCustomRepositoryImpl implements CommentCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    QCommentEntity qCommnetEntity = QCommentEntity.commentEntity;

    @Override
    public List<CommentEntity> finAllByProductId(Long productId, Pageable pageable) {
        return jpaQueryFactory
                .select(qCommnetEntity)
                .from(qCommnetEntity)
                .where(
                        productIdEq(productId)
                )
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

    }
    private BooleanExpression productIdEq(Long productId) {
        return productId != null ? qCommnetEntity.productId.id.eq(productId) : null;
    }
}
