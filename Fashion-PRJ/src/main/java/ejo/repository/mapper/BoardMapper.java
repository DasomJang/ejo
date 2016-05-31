package ejo.repository.mapper;

import java.util.List;

import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardScoreVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ItemFileVO;
import ejo.repository.vo.ThemeVO;
import ejo.repository.vo.BoardCommentVO;

public interface BoardMapper {
	
	////////////////////////// 리스트   //////////////////////////	
	//	테마 리스트 
	public List<ThemeVO> selectTheme(String genderNo) throws Exception;
	
	//	테마별 리스트 
	public List<BoardVO> selectThemeBoard(String themeNo, String id) throws Exception;
	
	//	테마별 리스트 파일 
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception;
	
	//	테마별 리스트 추천 입력
	public void registBoardRecom (BoardRecomVO boardRecom) throws Exception;
	
	//	테마별 리스트 아이디별 추천 확인용
	public int selectRecomCount(BoardRecomVO boardRecom) throws Exception;
	
	
	
	////////////////////////// 상세   //////////////////////////
	/////////////상세 메인 사진   /////////////
	BoardFileVO selectBoardFile(int boardNo) throws Exception;
	
	/////////////상세 글내용   /////////////	
	public BoardVO selectOneBoard(int boardNo) throws Exception;
	
	/////////////상세 댓글   /////////////		
	public List<BoardCommentVO> selectBoardComment(int boardNo) throws Exception;
	public void insertBoardComment(BoardCommentVO comment) throws Exception;
	public BoardCommentVO selectRegComment(int commentNo) throws Exception;
	public void updateBoardComment(BoardCommentVO comment) throws Exception;
	public void deleteBoardComment(int commentNo) throws Exception;	

	///////////// 상세 평점   /////////////
	public int selectBoardScoreCnt(int boardNo) throws Exception;
	public int selectBoardScoreGradeCnt(BoardScoreVO score) throws Exception;
	public int selectOneBoardScore(BoardScoreVO score) throws Exception;
	public void insertBoardScore(BoardScoreVO score) throws Exception;

	///////////// 상세 아이템 사진   /////////////
	public List<ItemFileVO> selectBoardItem(int boardNo) throws Exception;

}
