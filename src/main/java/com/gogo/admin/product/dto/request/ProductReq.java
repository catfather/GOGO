package com.gogo.admin.product.dto.request;


import com.gogo.admin.member.entity.Member;
import com.gogo.admin.product.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductReq {

    @NotNull(message = "제목은 필수 입니다")
    private String title;
    @NotNull(message = "설명은 필수 입니다")
    @Column(columnDefinition = "LONGTEXT") // html 코드가 string으로 들어갈 수도 있어서
    private String description;
    @NotNull(message = "가격은 필수 입니다")
    private Integer price;
    @NotNull(message = "작성자는 필수 입니다")
    @JoinColumn(name = "memberId")
    private Integer memberId;
    @NotNull(message = "노출 여부는 필수 입니다")
    private Integer isDisplay; // 0: 미노출, 1: 노출
    @NotNull(message = "이벤트 여부는 필수 입니다")
    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트

    public ProductEntity toEntity(ProductReq productReq) {
        return ProductEntity.builder()
                .title(productReq.getTitle())
                .description(productReq.getDescription())
                .price(productReq.getPrice())
                .memberId(productReq.getMemberId())
                .isDisplay(productReq.getIsDisplay())
                .isEvent(productReq.getIsEvent())
                .build();

    }
}
