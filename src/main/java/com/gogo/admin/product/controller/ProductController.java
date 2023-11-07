package com.gogo.admin.product.controller;

import com.gogo.admin.product.dto.request.ProductReq;
import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public Map<String, Object> getProductList(@RequestBody ProductSearchCriteria criteria,
                                              @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return Collections.singletonMap("result", productService.getProductList(criteria, pageable));
    }

    @PostMapping("/create")
    public Map<String, Object> createProduct(@RequestBody ProductReq productReq) {
        return Collections.singletonMap("id", productService.createProduct(productReq));
    }
}
