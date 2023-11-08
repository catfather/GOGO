package com.gogo.admin.product.repository;

import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.entity.ProductEntity;
import com.gogo.admin.product.entity.QProductEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    QProductEntity qProductEntity = QProductEntity.productEntity;


    @Override
    public List<ProductEntity> findProductList(ProductSearchCriteria criteria, Pageable pageable) {
        return jpaQueryFactory
                .select(qProductEntity)
                .from(qProductEntity)
                .where(
                        IdEq(criteria.getId()),
                        TitleCt(criteria.getTitle()),
                        DescriptionCt(criteria.getDescription()),
                        MemberIdEq(criteria.getMemberId()),
                        PriceBetween(criteria.getPriceStart(), criteria.getPriceEnd()),
                        IsDeleteEq(criteria.getIsDeleted()),
                        IsDisplayEq(criteria.getIsDisplay())
                )
                .offset(pageable.getOffset())   // 페이지 번호
                .limit(pageable.getPageSize())  // 한번에 보여줄 게시글 수
                .fetch();
    }

    private Predicate IsDisplayEq(Integer isDisplay) {
        return null;
    }

    private Predicate PriceBetween(Integer priceStart, Integer priceEnd) {
        return null;
    }

    private Predicate DescriptionCt(String description) {
        return null;
    }

    private Predicate TitleCt(String title) {
        return null;
    }

    private BooleanExpression MemberIdEq(Integer member) {
        return null;
    }

    private BooleanExpression IsDeleteEq(Integer isDeleted){
        return null ;

    }

    private BooleanExpression IdEq(Long id) {
        return null;
    }
}
