package com.gogo.admin.product.dto.response;

import com.gogo.admin.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@Builder
public class ProductDetailRes {

    private Long id;

    private String title;

    private String description;

    private Integer price;

    private Long memberId;

    private Integer isDisplay; // 0: 미노출, 1: 노출

    private Integer isDeleted; // 0: 미노출, 1: 노출

    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트

}
