package com.gogo.admin.product.option.service;

import com.gogo.admin.product.entity.ProductEntity;
import com.gogo.admin.product.option.dto.request.OptionCreate;
import com.gogo.admin.product.option.dto.response.Option;
import com.gogo.admin.product.option.entity.OptionEntity;
import com.gogo.admin.product.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;

    // 1개의 상품에 모든 옵션 조회
    public List<Option> GetOptionList(Long productId) {
        return optionRepository.findAllByProductId(
                new ProductEntity(productId))
                .stream()
                .map(this::of)
                .collect(java.util.stream.Collectors.toList()
                );
    }

    public Long PostOption(Long productId, OptionCreate optionCreate) {

        return optionRepository.save(OptionEntity.builder()
                .productId(new ProductEntity(productId))
                .parentId(optionCreate.getParentId())
                .optionName(optionCreate.getOptionName())
                .optionPrice(optionCreate.getOptionPrice())
                .build()
        ).getId();
    }

    private Option of(OptionEntity optionEntity) {
        return   Option.builder()
                .id(optionEntity.getId())
                .parentId(optionEntity.getParentId())
                .optionName(optionEntity.getOptionName())
                .optionPrice(optionEntity.getOptionPrice())
                .build();
    }

    //옵션 생성

}
