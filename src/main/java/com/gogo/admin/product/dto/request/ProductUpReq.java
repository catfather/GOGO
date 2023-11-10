package com.gogo.admin.product.dto.request;

import com.gogo.admin.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductUpReq {

    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer isDisplay; // 0: 미노출, 1: 노출
    @NotNull
    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트
    @NotNull
    private Integer isDeleted;
}
