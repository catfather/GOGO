package com.gogo.admin.board.dto.request;

import com.gogo.admin.board.entity.utill.ORDER;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class SearchCriteriaBoard {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDate start; //시작일
    private LocalDate end; //끝일
    private ORDER order;
    private Integer isDeleted; //삭제 처리
    private Integer isDisplay; // 비활성화 처리


    public SearchCriteriaBoard(){
        if(this.order == null){
            this.order = ORDER.DESC;
        }
        // 1일경우 보임
        if(this.isDisplay == null){
            this.isDisplay = 1;
        }
        // 1일 경우 삭제 처리
        if(this.isDeleted == null){
            this.isDeleted = 0;
        }
    }


}
