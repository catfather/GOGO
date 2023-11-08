package com.gogo.admin.product.dto.request;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchCriteria {

    private Long Id;

    private String title;

    private String country;

    private String description;

    private Integer memberId;

    private Integer priceStart;

    private Integer priceEnd;

    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트

    private Integer isDisplay; // 0: 미노출, 1: 노출

    private Integer isDeleted; // 0: 삭제 안됨, 1: 삭제 됨

    //나중에 예약 가능한 날짜만 추려서 보여주면 좋을꺼같음


}
