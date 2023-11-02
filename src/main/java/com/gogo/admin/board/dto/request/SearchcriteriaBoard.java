package com.gogo.admin.board.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class SearchcriteriaBoard {
    private Long id;
    private String title;
    private String writer;
    private LocalDate start; //시작일
    private LocalDate end; //끝일


}
