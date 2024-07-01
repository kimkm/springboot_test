package kim.km.test01.board.web;

import kim.km.test01.board.model.BoardModel;
import kim.km.test01.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;
    @RequestMapping("/write.do")
    public String write() {
        return "board/write";
    }

    @RequestMapping("/insert.do")
    public String insert(BoardModel boardModel, Model model) throws Exception{
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ /insert.do @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        try {
            boardService.insertBoard(boardModel);
        }catch (Exception e) {
            logger.info("error1111111111111111111");
        }

        return "redirect:write.do";
    }
}
