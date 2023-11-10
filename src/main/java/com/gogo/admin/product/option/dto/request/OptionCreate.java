package com.gogo.admin.product.option.dto.request;

import com.gogo.admin.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class OptionCreate {

    private Long parentId;

    @NotNull
    private String optionName;

    @NotNull
    private Integer optionPrice;
}
