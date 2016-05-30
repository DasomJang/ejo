package ejo.board.service;

import java.util.List;
import java.util.Map;

import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardScoreVO;

public interface BoardService {
	public Map<String, Object> detailBoard(int boardNo) throws Exception;

	public List<BoardCommentVO> selectComment(int boardNo) throws Exception;

	public BoardCommentVO registComment(BoardCommentVO comment) throws Exception;

	public void updateComment(BoardCommentVO comment) throws Exception;

	public List<BoardCommentVO> deleteComment(BoardCommentVO comment) throws Exception;

	//////////////////////////평점   //////////////////////////	
	public Map<String, Integer> selectScoreCnt(int boardNo) throws Exception;
	public int registScore(BoardScoreVO score) throws Exception;


}
