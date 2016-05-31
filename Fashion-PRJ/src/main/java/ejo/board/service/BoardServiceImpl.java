package ejo.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.BoardMapperImpl;
import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardScoreVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ItemFileVO;
import ejo.repository.vo.ThemeVO;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapperImpl dao;
	
	////////////////////////// 리스트   //////////////////////////
	
	//	테마리스트
	@Override
	public List<ThemeVO> selectTheme(String genderNo) throws Exception {
		return dao.selectTheme(genderNo);
	}

	//	테마별 리스트 조회
	@Override
	public Map<String,Object> selectThemeBoard(String themeNo, String id) throws Exception {
		
		List<BoardVO> thListBoard = dao.selectThemeBoard(themeNo, id);
		List<BoardFileVO> thListBoardFile = dao.selectThemeBoardFile(themeNo);
		
		Map<String, Object> result = new HashMap<>();
		result.put("thListBoard", thListBoard);
		result.put("thListBoardFile", thListBoardFile);
		
		return result;
	}
	
	//	테마별 리스트 아이디별 추천 확인
	@Override
	public int selectRecomCount(BoardRecomVO boardRecom) throws Exception {
		return dao.selectRecomCount(boardRecom);
	}

	//	테마별 리스트 추천 입력

	@Override
	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception {
		dao.registBoardRecom(boardRecom);
	}
	
	//	테마별 리스트 추천 삭제
	@Override
	public void deleteBoardRecom(BoardRecomVO boardRecom) {
		dao.deleteBoardRecom(boardRecom);
		
	}

	
	////////////////////////// 상세   //////////////////////////

	@Override
	public Map<String, Object> detailBoard(int boardNo) throws Exception {
		BoardFileVO file = dao.selectBoardFile(boardNo);
		BoardVO board = dao.selectOneBoard(boardNo);
		List<ItemFileVO> itemList = dao.selectBoardItem(boardNo);
		board.setItemList(itemList);
		
		Map<String, Object> result = new HashMap<>();
		result.put("file", file);
		result.put("board", board);
		return result;
	}
	
	////////////////////////// 상세 댓글   //////////////////////////
	
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


	
	////////////////////////// 상세 평점   //////////////////////////
	
	@Override
	public Map<String, Integer> selectScoreCnt(int boardNo) throws Exception {
		int scoreCnt = dao.selectBoardScoreCnt(boardNo);

		BoardScoreVO score = new BoardScoreVO();
		score.setBoardNo(boardNo);
		score.setCodeValue("11");
		int scoreGoodCnt = dao.selectBoardScoreGradeCnt(score);
		score.setCodeValue("12");
		int scoreSosoCnt = dao.selectBoardScoreGradeCnt(score);
		score.setCodeValue("13");
		int scoreBadCnt = dao.selectBoardScoreGradeCnt(score);
		
		Map<String, Integer> result = new HashMap<>();
		result.put("scoreCnt", scoreCnt);
		result.put("scoreGoodCnt", scoreGoodCnt);
		result.put("scoreSosoCnt", scoreSosoCnt);
		result.put("scoreBadCnt", scoreBadCnt);
		return result;		
	}

	@Override
	public int registScore(BoardScoreVO score) throws Exception {
		int count = dao.selectOneBoardScore(score);
		if (count == 0) {
			// 점수 미등록 회원일시
			dao.insertBoardScore(score);			
			return 0;
		} else {
			// 점수 기등록 회원일시
			return -1;
		}		
	}
}
