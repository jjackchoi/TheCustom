package com.customEdu.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    final BoardService boardService;

    // 게시글 작성 페이지
    @GetMapping("/board/write.do")
    public String openBoardWrite(Model model){
        String  title = "제목",
                content = "내용",
                writer = "홍길동";
        model.addAttribute("t", title);
        model.addAttribute("c", content);
        model.addAttribute("w", writer);
        return "board/write";
    }
}
