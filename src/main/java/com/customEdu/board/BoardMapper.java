package com.customEdu.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 저장
    void save(BoardRequest params);

    // 게시글 조회
    BoardResponse findBySeq(Long seq);

    // 게시글 수정
    void update(BoardRequest params);

    // 게시글 삭제
    void delete(Long seq);

    // 게시물 리스트 조회
    List<BoardResponse> findAll();




}
