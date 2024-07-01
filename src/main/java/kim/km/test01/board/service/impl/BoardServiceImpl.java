package kim.km.test01.board.service.impl;

import jakarta.annotation.Resource;
import kim.km.test01.board.model.BoardModel;
import kim.km.test01.board.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    private BoardMapper boardMapper;
    @Override
    public void insertBoard(BoardModel boardModel) throws Exception {
        boardMapper.insertTest(boardModel);
    }
}
