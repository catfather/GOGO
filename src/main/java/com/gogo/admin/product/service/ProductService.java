package com.gogo.admin.product.service;

import com.gogo.admin.product.dto.request.ProductReq;
import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.dto.response.ProductRes;
import com.gogo.admin.product.repository.ProductCustomRepository;
import com.gogo.admin.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCustomRepository productCustomRepository;

    //상품 리스트
    public List<ProductRes> getProductList(ProductSearchCriteria criteria, Pageable pageable) {
        return productCustomRepository.findProductList(criteria, pageable);
    }

    //상품 생성
    public Long createProduct(ProductReq productReq) {
        return productRepository.save(productReq.toEntity(productReq)).getId();
    }


}
