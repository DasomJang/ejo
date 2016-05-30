package ejo.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
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
	

	public BoardFileVO selectBoardFile(int boardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardFile", boardNo);
	}
	
	public BoardVO selectOneBoard(int boardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectOneBoard", boardNo);
	}

	public List<BoardCommentVO> selectBoardComment(int boardNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectCommentList", boardNo);
	}

	public void insertBoardComment(BoardCommentVO comment) throws Exception {		
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardComment", comment);
	}

	public BoardCommentVO selectRegComment(int commentNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectRegComment", commentNo);
	}

	public void updateBoardComment(BoardCommentVO comment) throws Exception {
		session.update(BOARD_MAPPER_NAMESPACE + ".updateBoardComment", comment);		
	}

	public void deleteBoardComment(int commentNo) throws Exception {
		session.delete(BOARD_MAPPER_NAMESPACE + ".deleteBoardComment", commentNo);		
	}

	public void deleteBoardRecom(BoardRecomVO boardRecom) {
		session.delete(BOARD_MAPPER_NAMESPACE + ".deleteBoardRecom", boardRecom);		
		
	}
	
	
	
	

}
