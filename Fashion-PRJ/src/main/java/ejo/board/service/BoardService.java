package ejo.board.service;

import java.util.List;
import java.util.Map;

import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ThemeVO;
import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardScoreVO;

public interface BoardService {
	////////////////////////// 상세 댓글   //////////////////////////	
	public Map<String, Object> detailBoard(int boardNo) throws Exception;	
	public List<BoardCommentVO> selectComment(int boardNo) throws Exception;
	public BoardCommentVO registComment(BoardCommentVO comment) throws Exception;
	public void updateComment(BoardCommentVO comment) throws Exception;
	public List<BoardCommentVO> deleteComment(BoardCommentVO comment) throws Exception;
	
	////////////////////////// 상세 평점   //////////////////////////	
	public Map<String, Integer> selectScoreCnt(int boardNo) throws Exception;
	public int registScore(BoardScoreVO score) throws Exception;

	
	////////////////////////// 리스트   //////////////////////////		
	//	테마리스트 조회
	public List<ThemeVO> selectTheme(String genderNo) throws Exception;	
	//	테마별 리스트 조회
	public List<BoardVO> selectThemeBoard(String themeNo) throws Exception;	
	//	테마별 리스트 파일 조회
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception;


	//	테마별 리스트 추천 입력
//	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception;

}
