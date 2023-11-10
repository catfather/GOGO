package com.gogo.admin.product.option.entity;


import com.gogo.admin.comment.entity.QCommentEntity;
import com.gogo.admin.product.entity.ProductEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "option_tb")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    private Long parentId; // null일 경우 단일 옵션, 값이 있을 경우 복합 옵션

    private String optionName;

    private Integer optionPrice;

}
