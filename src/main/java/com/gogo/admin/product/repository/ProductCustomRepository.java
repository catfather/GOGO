package com.gogo.admin.product.repository;


import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomRepository {

    List<ProductEntity> findProductList(ProductSearchCriteria criteria, Pageable pageable);
}
