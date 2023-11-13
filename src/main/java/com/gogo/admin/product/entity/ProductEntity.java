package com.gogo.admin.product.entity;


import com.gogo.admin.member.entity.MemberEntity;
import com.gogo.admin.product.dto.request.ProductUpReq;
import com.gogo.admin.utill.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberId;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer isDisplay; // 0: 미노출, 1: 노출

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer isEvent; // 0: 이벤트 아님, 1: 이벤트

    public ProductEntity(Long productId) {
        this.id = productId;
    }


    public ProductEntity Update(ProductUpReq productUpReq) {
        this.id = productUpReq.getId();
        this.title = productUpReq.getTitle();
        this.description = productUpReq.getDescription();
        this.price = productUpReq.getPrice();
        this.isDisplay = productUpReq.getIsDisplay();
        this.isEvent = productUpReq.getIsEvent();
        super.setIsDeleted(productUpReq.getIsDeleted());
        return this;
    }
}
