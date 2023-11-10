package com.gogo.admin.comment.entity;


import com.gogo.admin.product.entity.ProductEntity;
import com.gogo.admin.utill.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment_tb")
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    private String content;

    private String writer;

    private Long parentId;

}
