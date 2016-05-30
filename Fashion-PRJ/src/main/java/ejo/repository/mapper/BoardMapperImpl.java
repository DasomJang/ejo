package ejo.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardScoreVO;
import ejo.repository.vo.BoardVO;

@Repository
public class BoardMapperImpl implements BoardMapper {

	@Autowired
	private SqlSessionTemplate session;
	private static final String BOARD_MAPPER_NAMESPACE = "ejo.repository.mapper.BoardMapper";
	
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

	
	public int selectBoardScoreCnt(int boardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardScoreCnt", boardNo);		
	}
	public int selectBoardScoreGradeCnt(BoardScoreVO score) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardScoreGradeCnt", score);
	}	

	public int selectOneBoardScore(BoardScoreVO score) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectOneBoardScore", score);		
	}
	public void insertBoardScore(BoardScoreVO score) throws Exception {
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardScore", score);		
	}

}
