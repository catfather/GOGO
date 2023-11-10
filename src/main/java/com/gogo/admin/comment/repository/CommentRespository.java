package com.gogo.admin.comment.repository;

import com.gogo.admin.comment.entity.CommentEntity;
import com.gogo.admin.product.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommentRespository extends JpaRepository<CommentEntity,Long> {

}
