package ejo.board.service;

import java.util.List;
import java.util.Map;

import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ThemeVO;

public interface BoardService {
	public Map<String, Object> detailBoard(int no) throws Exception;
	
	//	테마리스트 조회
	public List<ThemeVO> selectTheme(String genderNo) throws Exception;
	
	//	테마별 리스트 조회
	public List<BoardVO> selectThemeBoard(String themeNo) throws Exception;
	
	//	테마별 리스트 파일 조회
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception;

	//	테마별 리스트 추천 입력
//	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception;
	
}
