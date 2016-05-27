package ejo.repository.mapper;

import ejo.repository.vo.BoardFileVO;

public interface BoardMapper {
	public BoardFileVO selectBoardFile(int no) throws Exception;
}
