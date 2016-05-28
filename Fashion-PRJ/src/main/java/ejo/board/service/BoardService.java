package ejo.board.service;

import java.util.List;
import java.util.Map;

import ejo.repository.vo.BoardCommentVO;

public interface BoardService {
	public Map<String, Object> detailBoard(int boardNo) throws Exception;

	public List<BoardCommentVO> selectComment(int boardNo) throws Exception;

	public BoardCommentVO registComment(BoardCommentVO comment) throws Exception;

	public void updateComment(BoardCommentVO comment) throws Exception;

	public List<BoardCommentVO> deleteComment(BoardCommentVO comment) throws Exception;

}
