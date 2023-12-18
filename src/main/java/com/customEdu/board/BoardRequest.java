package com.customEdu.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardRequest {

    private Long boardSeq; // 게시물 시퀀스
    private String boardTitle; // 게시물 제목
    private String boardText; // 게시물 내용
    private String boardWriter; // 게시물 글쓴이

}
