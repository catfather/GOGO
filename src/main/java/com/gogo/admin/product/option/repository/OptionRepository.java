package com.gogo.admin.product.option.repository;


import com.gogo.admin.product.entity.ProductEntity;
import com.gogo.admin.product.option.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<OptionEntity, Long> {
    List<OptionEntity> findAllByProductId(ProductEntity productEntity);
}
