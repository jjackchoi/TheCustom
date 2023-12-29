package com.customEdu.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    // 게시글 저장
    @Transactional
    public Long saveBoard(final BoardRequest params){
        boardMapper.save(params);
        return params.getBoardSeq();
    }

    // 게시글 상세정보 조회
    public BoardResponse findBoardById(final Long seq){
        return boardMapper.findBySeq(seq);
    }

    // 게시글 수정
    @Transactional
    public Long updateBoard(final BoardRequest params){
        boardMapper.update(params);
        return params.getBoardSeq();
    }

    // 게시글 삭제
    @Transactional
    public Long deleteBoard(final Long seq){
        boardMapper.delete(seq);
        return seq;
    }

    // 게시글 다중 삭제
    @Transactional
    public int mulDelBoard(final Long[] seqList){
        for (int i = 0; i < seqList.length; i++){
            boardMapper.delete(seqList[i]);
        }
        int seqListLength = boardMapper.findAll().size();
        return seqListLength;
    }

    // 게시글 리스트 조회
    public List<BoardResponse> findAllBoard(){
        return boardMapper.findAll();
    }
}
