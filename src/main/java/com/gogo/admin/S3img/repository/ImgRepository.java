package com.gogo.admin.S3img.repository;

import com.gogo.admin.S3img.entity.ImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRepository extends JpaRepository<ImgEntity, Long>

}
