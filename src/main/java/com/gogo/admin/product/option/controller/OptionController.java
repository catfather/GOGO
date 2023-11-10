package com.gogo.admin.product.option.controller;


import com.gogo.admin.product.option.dto.request.OptionCreate;
import com.gogo.admin.product.option.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/option")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    //상품에 대한 옵션 조회
    @GetMapping("/{productId}")
    public Map<String, Object> GetOptionList(
            @PathVariable(name = "productId") Long productId) {
        return Collections.singletonMap("result", optionService.GetOptionList(productId));
    }
    //옵션 생성
    @PostMapping("/{productId}")
    public Map<String, Object> PostOption(
            @Validated @RequestBody OptionCreate optionCreate,
            @PathVariable(name = "productId") Long productId) {
        return Collections.singletonMap("optionId", optionService.PostOption(productId, optionCreate));
    }


}
