package com.gogo.admin.comment.controller;

import com.gogo.admin.comment.dto.request.CommentCreate;
import com.gogo.admin.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{productId}")
    public Map<String, Object> GetCommentList(
            @PathVariable(name = "productId") Long productId,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return Collections.singletonMap("result", commentService.GetCommentList(productId, pageable));
    }

    @PostMapping("/{productId}")
    public Map<String, Object> PostComment(
            @PathVariable(name = "productId") Long productId,
            @Validated @RequestBody CommentCreate comment) {
        return Collections.singletonMap("result", commentService.PostComment(productId, comment));
    }
}
