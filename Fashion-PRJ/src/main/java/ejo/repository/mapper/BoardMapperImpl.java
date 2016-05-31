package ejo.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardScoreVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ItemFileVO;
import ejo.repository.vo.ThemeVO;

@Repository
public class BoardMapperImpl implements BoardMapper {

	@Autowired
	private SqlSessionTemplate session;
	private static final String BOARD_MAPPER_NAMESPACE = "ejo.repository.mapper.BoardMapper";
	
	
	//	테마리스트 
	@Override
	public List<ThemeVO> selectTheme(String genderNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectTheme", genderNo);
	}

	//	테마별 리스트
	@Override
	public List<BoardVO> selectThemeBoard(String themeNo, String id) throws Exception {
		
		Map<String, String> themeId = new HashMap<>();
		themeId.put("themeNo", themeNo);
		themeId.put("id", id);
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectThemeBoard", themeId);
	}
	//	테마별 리스트 별 파일 목록 리스트
	@Override
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectThemeBoardFile", themeNo);
	}

	//	테마별 리스트 추천 입력
	@Override
	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception {
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardRecom",boardRecom);
	}
	
	//	테마별 리스트 아이디별 추천 확인
	@Override
	public int selectRecomCount(BoardRecomVO boardRecom) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectRecomCount",boardRecom);
	}
	
	//	테마별 리스트 추천 삭제
	public void deleteBoardRecom(BoardRecomVO boardRecom) {
		session.delete(BOARD_MAPPER_NAMESPACE + ".deleteBoardRecom", boardRecom);		
		
	}

	//////////////////////////상세   //////////////////////////		
	/////////////상세 메인 사진   /////////////	
	@Override
	public BoardFileVO selectBoardFile(int boardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardFile", boardNo);
	}	
	/////////////상세 글내용   /////////////	
	@Override
	public BoardVO selectOneBoard(int boardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectOneBoard", boardNo);
	}

	/////////////상세 댓글   /////////////	
	@Override
	public List<BoardCommentVO> selectBoardComment(int boardNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectCommentList", boardNo);
	}
	@Override
	public void insertBoardComment(BoardCommentVO comment) throws Exception {		
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardComment", comment);
	}
	@Override
	public BoardCommentVO selectRegComment(int commentNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectRegComment", commentNo);
	}
	@Override
	public void updateBoardComment(BoardCommentVO comment) throws Exception {
		session.update(BOARD_MAPPER_NAMESPACE + ".updateBoardComment", comment);		
	}
	@Override
	public void deleteBoardComment(int commentNo) throws Exception {
		session.delete(BOARD_MAPPER_NAMESPACE + ".deleteBoardComment", commentNo);		
	}


	
	
	
	/////////////상세 평점   /////////////	
	@Override
	public int selectBoardScoreCnt(int boardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardScoreCnt", boardNo);		
	}
	@Override
	public int selectBoardScoreGradeCnt(BoardScoreVO score) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardScoreGradeCnt", score);
	}	
	@Override
	public int selectOneBoardScore(BoardScoreVO score) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectOneBoardScore", score);		
	}
	@Override
	public void insertBoardScore(BoardScoreVO score) throws Exception {
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardScore", score);		
	}

	/////////////상세 아이템   /////////////	
	@Override
	public List<ItemFileVO> selectBoardItem(int boardNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectBoardItem", boardNo);
	}

}
