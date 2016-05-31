package ejo.board.service;

import java.util.List;
import java.util.Map;

import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardScoreVO;
import ejo.repository.vo.ThemeVO;

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
	
	//	테마별 리스트 조회 (파일 포함)
	public Map<String,Object> selectThemeBoard(String themeNo, String id) throws Exception;

	//	테마별 리스트 추천 입력
	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception;
	
	//	테마별 리스트 아이디별 추천 확인
	public int selectRecomCount(BoardRecomVO boardRecom) throws Exception;

	//	테마별 리스트 추천 삭제
	public void deleteBoardRecom(BoardRecomVO boardRecom);
	

}
