package com.customEdu;

import com.customEdu.board.BoardMapper;
import com.customEdu.board.BoardRequest;
import com.customEdu.board.BoardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardMapperTest {
    @Autowired
    BoardMapper boardMapper;

    @Test
    void save(){
        BoardRequest params = new BoardRequest();
        params.setBoardTitle("게시글 제목");
        params.setBoardText("게시글 내용");
        params.setBoardWriter("게시글 글쓴이");
        boardMapper.save(params);
        List<BoardResponse> posts = boardMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개 입니다.");
    }

    @Test
    void findBySeq(){
        BoardResponse post = boardMapper.findBySeq(1L);
        try{
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update(){
        BoardRequest params = new BoardRequest();
        params.setBoardSeq(2L);
        params.setBoardTitle("제목만 변경");
        params.setBoardText("게시글 변경");
        params.setBoardWriter("글쓴이 변경");
        boardMapper.update(params);
        BoardResponse post = boardMapper.findBySeq(2L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete(){
        System.out.println("삭제 이전의 전체 게시글 수는 : " + boardMapper.findAll().size() + "개 입니다.");
        boardMapper.delete(3L);
        System.out.println("삭제 이후의 전체 게시글 수는 : " + boardMapper.findAll().size() + "개 입니다.");
    }
}
