package com.customEdu.board;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private Long boardSeq; // 게시물 시퀀스
    private String boardTitle; // 게시물 제목
    private String text; // 게시물 내용
    private String writer; // 게시물 글쓴이
    private LocalDateTime boardRegDate; // 게시물 등록 시간
    private LocalDateTime boardModDate; // 게시물 수정 시간
    private String boardImgPath; // 게시물 이미지 경로
    private boolean boardDelYn; // 게시물 삭제 여부

}
