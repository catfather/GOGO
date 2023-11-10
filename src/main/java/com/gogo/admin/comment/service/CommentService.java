package com.gogo.admin.comment.service;

import com.gogo.admin.comment.dto.request.CommentCreate;
import com.gogo.admin.comment.dto.response.Comment;
import com.gogo.admin.comment.entity.CommentEntity;
import com.gogo.admin.comment.repository.CommentCustomRepository;
import com.gogo.admin.comment.repository.CommentRespository;
import com.gogo.admin.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRespository commentRespository;
    private final CommentCustomRepository commentCustomRepository;


    //조회
    public List<Comment> GetCommentList(Long productId, Pageable pageable) {

        return commentCustomRepository.finAllByProductId(productId, pageable)
                .stream()
                .map(this::of)
                .collect(Collectors.toList());
    }

    private Comment of(CommentEntity comment) {
        return Comment.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .writer(comment.getWriter())
                .productId(comment.getProductId().getId())
                .parentId(comment.getParentId())
                .createTime(comment.getCreateTime())
                .updateTime(comment.getUpdateTime())
                .isDeleted(comment.getIsDeleted())
                .build();
    }

    public Long PostComment(Long productId, CommentCreate comment) {

        return commentRespository.save(CommentEntity.builder()
                .productId(new ProductEntity(productId))
                .content(comment.getContent())
                .writer(comment.getWriter())
                .parentId(comment.getParentId())
                .build()
        ).getId();
    }
}
