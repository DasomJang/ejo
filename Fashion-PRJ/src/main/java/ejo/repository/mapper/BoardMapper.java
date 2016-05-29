package ejo.repository.mapper;

import java.util.List;

import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ThemeVO;
import ejo.repository.vo.BoardCommentVO;

public interface BoardMapper {
	
	//	테마 리스트 
	public List<ThemeVO> selectTheme(String genderNo) throws Exception;
	
	//	테마별 리스트 
	public List<BoardVO> selectThemeBoard(String themeNo) throws Exception;
	
	//	테마별 리스트 파일 
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception;
	
	//	테마별 리스트 추천 입력
//	public void registBoardRecom (BoardRecomVO boardRecom) throws Exception;
	
	public BoardVO selectOneBoard(int boardNo) throws Exception;
	public List<BoardCommentVO> selectBoardComment(int boardNo) throws Exception;
	public void insertBoardComment(BoardCommentVO comment) throws Exception;
	public BoardCommentVO selectRegComment(int commentNo) throws Exception;
	public void updateBoardComment(BoardCommentVO comment) throws Exception;
	public void deleteBoardComment(int commentNo) throws Exception;
	
}
