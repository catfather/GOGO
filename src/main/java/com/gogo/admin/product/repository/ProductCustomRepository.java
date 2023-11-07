package com.gogo.admin.product.repository;


import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.dto.response.ProductRes;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomRepository {



    public List<ProductRes> findProductList(ProductSearchCriteria criteria, Pageable pageable);
}
