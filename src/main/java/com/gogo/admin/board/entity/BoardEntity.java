package com.gogo.admin.board.entity;

import com.gogo.admin.board.entity.utill.BoardType;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "board_tb")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;

    private BoardType boardType;

    //게시판 글 생성
    public void Board(String title,String content,String writer, BoardType boardType){
        this.title = title;
        this.content = content;
        this.writer = writer;


    }

}
