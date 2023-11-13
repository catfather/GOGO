package com.gogo.admin.comment.dto.request;


import com.gogo.admin.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class CommentCreate {

    @NotNull
    private String content;

    @NotNull
    private String writer;

    private Long parentId;
}
