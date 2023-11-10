package com.gogo.admin.comment.repository;

import com.gogo.admin.comment.entity.CommentEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentCustomRepository {
    List<CommentEntity> finAllByProductId(Long productId, Pageable pageable);
}
