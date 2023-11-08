package com.gogo.admin.ProductImg.entity;

import com.gogo.admin.product.entity.ProductEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_img_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_img_id")
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_name")
    private String imgName;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    public ProductImgEntity Create(String imgUrl, String imgName, ProductEntity productId) {
        this.imgUrl = imgUrl;
        this.imgName = imgName;
        this.productId = productId;
        return this;
    }

}
