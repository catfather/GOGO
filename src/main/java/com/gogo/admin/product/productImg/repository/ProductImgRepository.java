package com.gogo.admin.product.productImg.repository;

import com.gogo.admin.product.productImg.entity.ProductImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImgEntity, Long>{

}
