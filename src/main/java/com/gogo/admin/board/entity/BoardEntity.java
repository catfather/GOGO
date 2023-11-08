package com.gogo.admin.board.entity;

import com.gogo.admin.board.dto.request.CreateBoard;
import com.gogo.admin.board.dto.request.UpdateBoard;
import com.gogo.admin.board.entity.utill.BOARDTYPE;
import com.gogo.admin.member.entity.MemberEntity;
import com.gogo.admin.utill.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "board_tb")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    private String title; // 제목
    private String content; // 컨텐츠
    private String writer; //글쓴이
    @Enumerated(EnumType.STRING)
    private BOARDTYPE boardType; //게시글 타입

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberId;

    @ColumnDefault("0")
    private Integer isDisplay;

    //게시판 글 생성

    public BoardEntity Create(CreateBoard board) {
        return BoardEntity.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .boardType(board.getType())
                .build();
    }

    public void Update(UpdateBoard board) {
        this.title = board.getTitle();
        this.id = board.getId();
        this.content = board.getContent();
        this.boardType = board.getBoardType();
        this.isDisplay = board.getIsDisPlay();
        super.setIsDeleted(board.getIsDelete());
    }

    public BoardEntity(CreateBoard board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.boardType = board.getType();
        this.isDisplay = board.getIsDisplay();
        super.setIsDeleted(0);
    }
}
