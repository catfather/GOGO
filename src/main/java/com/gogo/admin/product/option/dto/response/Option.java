package com.gogo.admin.product.option.dto.response;

import com.gogo.admin.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Builder
public class Option {

    private Long id;

    private ProductEntity productId;

    private Long parentId; // null일 경우 단일 옵션, 값이 있을 경우 복합 옵션

    private String optionName;

    private Integer optionPrice;


}
