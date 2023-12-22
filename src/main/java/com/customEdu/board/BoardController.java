package com.customEdu.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    final BoardService boardService;

    // 게시글 리스트 페이지
    @GetMapping("/")
    public String openBoardList(Model model){
        List<BoardResponse> boards = boardService.findAllBoard();
        model.addAttribute("boards", boards);
        System.out.println(boards.size());
        return "board/list";
    }
    // 게시글 작성 페이지
    @GetMapping("/board/write.do")
    public String openBoardWrite(@RequestParam(value = "boardSeq", required = false) final Long seq, Model model){
        if (seq != null){
            BoardResponse board = boardService.findBoardById(seq);
            model.addAttribute("board", board);
        }
        return "board/write";
    }

    @PostMapping("/board/save.do")
    public String saveBoard(final BoardRequest params){
        boardService.saveBoard(params);
        return "redirect:/";
    }
}
