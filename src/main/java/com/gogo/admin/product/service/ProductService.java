package com.gogo.admin.product.service;

import com.gogo.admin.product.dto.request.ProductReq;
import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.dto.request.ProductUpReq;
import com.gogo.admin.product.dto.response.ProductDetailRes;
import com.gogo.admin.product.dto.response.ProductRes;
import com.gogo.admin.product.entity.ProductEntity;
import com.gogo.admin.product.repository.ProductCustomRepository;
import com.gogo.admin.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCustomRepository productCustomRepository;

    //상품 리스트
    public List<ProductRes> GetProductList(ProductSearchCriteria criteria, Pageable pageable) {
        return productCustomRepository.findProductList(criteria, pageable).stream()
                .map(this::of)
                .collect(Collectors.toList());
    }

    //상품 생성
    public Long CreateProduct(ProductReq productReq) {
        return productRepository.save(productReq.toEntity(productReq)).getId();
    }

    public Long UpdateProduct(ProductUpReq productUpReq) {
        ProductEntity productEntity = productRepository.findById(productUpReq.getId()).orElseThrow(IllegalAccessError::new);
        return productRepository.save(productEntity.Update(productUpReq)).getId();
    }


    private ProductRes of(ProductEntity productEntity) {
        return ProductRes.builder()
                .id(productEntity.getId())
                .title(productEntity.getTitle())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .memberId(productEntity.getMemberId().getId().intValue())
                .isDisplay(productEntity.getIsDisplay())
                .isDeleted(productEntity.getIsDeleted())
                .isEvent(productEntity.getIsEvent())
                .createTime(productEntity.getCreateTime())
                .updateTime(productEntity.getUpdateTime())
                .build();

    }

    public ProductDetailRes DetailProductList(Long id) {
        ProductEntity entity = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return ProductDetailRes.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .memberId(entity.getMemberId().getId())
                .isDisplay(entity.getIsDisplay())
                .isDeleted(entity.getIsDeleted())
                .isEvent(entity.getIsEvent())
                .build();
    }
}
