package ejo.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.BoardMapperImpl;
import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ThemeVO;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapperImpl dao;

	@Override
	public Map<String, Object> detailBoard(int boardNo) throws Exception {
		BoardFileVO file = dao.selectBoardFile(boardNo);
		BoardVO board = dao.selectOneBoard(boardNo);
		
		Map<String, Object> result = new HashMap<>();
		result.put("file", file);
		result.put("board", board);
		return result;
	}
	
	//	테마리스트
	@Override
	public List<ThemeVO> selectTheme(String genderNo) throws Exception {
		return dao.selectTheme(genderNo);
	}

	//	테마별 리스트 조회
	@Override
	public List<BoardVO> selectThemeBoard(String themeNo) throws Exception {
		return dao.selectThemeBoard(themeNo);
	}
	
	//	테마별 리스트 파일 조회
	@Override
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception {
		return dao.selectThemeBoardFile(themeNo);
	}
 
//	@Override
//	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception {
//		dao.registBoardRecom(boardRecom);
//	}
	
	
	@Override
	public List<BoardCommentVO> selectComment(int boardNo) throws Exception {
		return dao.selectBoardComment(boardNo);
	}

	@Override
	public BoardCommentVO registComment(BoardCommentVO comment) throws Exception {		
		dao.insertBoardComment(comment);
		System.out.println(comment.getCommentNo());
		return dao.selectRegComment(comment.getCommentNo());
	}

	@Override
	public void updateComment(BoardCommentVO comment) throws Exception {
		dao.updateBoardComment(comment);
		
	}

	@Override
	public List<BoardCommentVO> deleteComment(BoardCommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getCommentNo());
		return dao.selectBoardComment(comment.getBoardNo());
	}

}
