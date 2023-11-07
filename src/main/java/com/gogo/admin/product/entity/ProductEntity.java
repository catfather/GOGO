package com.gogo.admin.product.entity;


import com.gogo.admin.utill.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product_tb")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Integer price;

    private Integer memberId;

    private Integer isDisplay; // 0: 미노출, 1: 노출

    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트




}
