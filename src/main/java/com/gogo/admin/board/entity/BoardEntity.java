package com.gogo.admin.board.entity;

import com.gogo.admin.board.entity.utill.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_tb")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title; // 제목
    private String content; // 컨텐츠
    private String writer; //글쓴이

    private BoardType boardType; //게시글 타입

    //게시판 글 생성
    public void Board(String title,String content,String writer, BoardType boardType){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardType = boardType;
    }

    public void BoardCreate(String title, String content, String writer, BoardType type) {
    }
}
