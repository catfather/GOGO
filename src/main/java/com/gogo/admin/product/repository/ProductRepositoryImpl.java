package com.gogo.admin.product.repository;

import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.dto.response.ProductRes;
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
    public List<ProductRes> findProductList(ProductSearchCriteria criteria, Pageable pageable) {
        return jpaQueryFactory
                .select(qProductEntity)
                .from(qProductEntity)
                .where(
                        IdEq(criteria.getId()),
                        TitleCt(criteria.getTitle()),
                        DescriptionCt(criteria.getDescription()),
                        MemberEq(criteria.getMember()),
                        PriceBetween(criteria.getPriceStart(), criteria.getPriceEnd()),
                        Date
                        IsDeleteEq(criteria.getIsDeleted()),
                        IsDisplayEq(criteria.getIsDisplay()),




                )
    }
}
