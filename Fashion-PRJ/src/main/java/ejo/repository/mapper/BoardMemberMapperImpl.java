package ejo.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.BoardMemberFileVO;
import ejo.repository.vo.BoardMemberRecomVO;
import ejo.repository.vo.BoardMemberVO;

@Repository
public class BoardMemberMapperImpl implements BoardMemberMapper {

	@Autowired
	private SqlSessionTemplate session;
	
	private static final String BOARD_MAPPER_NAMESPACE = "ejo.repository.mapper.BoardMemberMapper";
	

	public int insertBoard(BoardMemberVO boardMemberVO) throws Exception {
	session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoard2",boardMemberVO);
		return boardMemberVO.getMemberBoardNo();
	}

	public void insertBoardFile(BoardMemberFileVO boardMemberFile) throws Exception {
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardFile",boardMemberFile);
	}

	public int selectBoardCount() throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardCount");
	}


	public List<BoardMemberVO> selectBoard(String id) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectBoard",id);
	}

	
	public void deleteBoard(int memberBoardNo) throws Exception {
		session.delete(BOARD_MAPPER_NAMESPACE + ".deleteBoard", memberBoardNo);
	}

	
	public void deleteFileByBoardNo(int memberBoardNo) throws Exception {
		session.delete(BOARD_MAPPER_NAMESPACE + ".deleteFileByBoardNo", memberBoardNo);
	}

	
	
//	@Override
//	public BoardMemberFileVO selectBoardFile(int memberBoardNo) throws Exception {
//		return session.selectOne(BOARD_DAO_NAMESPACE + ".selectBoardFile", memberBoardNo);
//	}

	@Override
	public BoardMemberFileVO selectBoardFileDown(int memberBoardNo) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardFile",memberBoardNo);
		
	}



public void registBoardRecom(BoardMemberRecomVO boardMemberRecomVO) throws Exception {
	session.insert(BOARD_MAPPER_NAMESPACE  + ".insertBoardRecom",boardMemberRecomVO);
	
}


public int selectRecomCount(BoardMemberRecomVO boardMemberRecomVO) throws Exception {
	return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectRecomCount",boardMemberRecomVO);
}

public void deleteBoardRecom(BoardMemberRecomVO boardMemberRecomVO) {
	session.delete(BOARD_MAPPER_NAMESPACE+ ".deleteBoardRecom", boardMemberRecomVO);		
	
}

	
}
