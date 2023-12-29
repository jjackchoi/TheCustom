package com.customEdu;

import com.customEdu.board.BoardRequest;
import com.customEdu.board.BoardResponse;
import com.customEdu.board.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    void save(){
        BoardRequest params = new BoardRequest();
        params.setBoardText("테스트 게시물 내용");
        params.setBoardTitle("테스트 게시물 제목");
        params.setBoardWriter("최승민");
        Long seq = boardService.saveBoard(params);
        System.out.println("생성된 게시글 시퀀스 = "+seq);
    }

    @Test
    void findById(){
        BoardResponse board = boardService.findBoardById(5L);
        try{
            String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
            System.out.println(boardJson);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateBoard(){
        BoardRequest params = new BoardRequest();
        params.setBoardWriter("수정된 글쓴이2");
        params.setBoardTitle("수정된 제목2");
        params.setBoardText("수정된 내용2");
        params.setBoardSeq(5L);
        Long seq = boardService.updateBoard(params);
        BoardResponse board = boardService.findBoardById(seq);
        try {
            String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
            System.out.println(boardJson);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete(){
        System.out.println("지우기 전 갯수 = " + boardService.findAllBoard().size());
        boardService.deleteBoard(6L);
        System.out.println("지운 후 갯수 = " + boardService.findAllBoard().size());
    }

    @Test
    void mulDel(){
        System.out.println("지우기 전 갯수 = " + boardService.findAllBoard().size());
        Long[] seqs = {1L, 2L};
        boardService.mulDelBoard(seqs);
        System.out.println("지운 후 갯수 = " + boardService.findAllBoard().size());
    }
}
