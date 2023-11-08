package com.gogo.admin.ProductImg.repository;

import com.gogo.admin.ProductImg.entity.ProductImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImgEntity, Long>{

}
