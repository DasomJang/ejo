package ejo.repository.mapper;

import java.util.List;

import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardVO;

public interface BoardMapper {
	public BoardFileVO selectBoardFile(int boardNo) throws Exception;
	public BoardVO selectOneBoard(int boardNo) throws Exception;
	public List<BoardCommentVO> selectBoardComment(int boardNo) throws Exception;
	public void insertBoardComment(BoardCommentVO comment) throws Exception;
	public BoardCommentVO selectRegComment(int commentNo) throws Exception;
	public void updateBoardComment(BoardCommentVO comment) throws Exception;
	public void deleteBoardComment(int commentNo) throws Exception;
}
