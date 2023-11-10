package com.gogo.admin.product.controller;

import com.gogo.admin.product.dto.request.ProductReq;
import com.gogo.admin.product.dto.request.ProductSearchCriteria;
import com.gogo.admin.product.dto.request.ProductUpReq;
import com.gogo.admin.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public Map<String, Object> GetProductList(@RequestBody ProductSearchCriteria criteria,
                                              @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return Collections.singletonMap("result", productService.GetProductList(criteria, pageable));
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> DetailProductList(@PathVariable(name = "id") Long id) {
        return Collections.singletonMap("result", productService.DetailProductList(id));
    }

    @PostMapping("/create")
    public Map<String, Object> CreateProduct(@RequestBody ProductReq productReq) {
        return Collections.singletonMap("id", productService.CreateProduct(productReq));
    }

    @PostMapping("/update")
    public Map<String, Object> UpdateProduct(@Validated  @RequestBody ProductUpReq productReq) {
        return Collections.singletonMap("id", productService.UpdateProduct(productReq));
    }
}
