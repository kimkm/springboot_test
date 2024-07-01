package kim.km.test01.board.service.impl;

import kim.km.test01.board.model.BoardModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insertTest(BoardModel boardModel) throws Exception;
}
