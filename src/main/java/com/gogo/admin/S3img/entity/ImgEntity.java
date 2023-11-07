package com.gogo.admin.S3img.entity;

import com.gogo.admin.board.entity.BoardEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board_img_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_name")
    private String imgName;

    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;
}
