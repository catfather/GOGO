package com.gogo.admin.product.dto.response;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRes {

    private Long id;

    private String title;

    private String description;

    private Integer price;

    private Integer memberId;

    private Integer isDisplay; // 0: 미노출, 1: 노출

    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDeleted;


}
