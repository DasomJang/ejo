package ejo.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.ThemeVO;

@Repository
public class BoardMapperImpl implements BoardMapper {

	@Autowired
	private SqlSessionTemplate session;
	private static final String BOARD_MAPPER_NAMESPACE = "ejo.repository.mapper.BoardMapper";
	public BoardFileVO selectBoardFile(int no) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardFile", no);
	}
	
	//	테마리스트 
	@Override
	public List<ThemeVO> selectTheme(String genderNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectTheme", genderNo);
	}

	//	테마별 리스트
	@Override
	public List<BoardVO> selectThemeBoard(String themeNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectThemeBoard", themeNo);
	}
	//	테마별 리스트 별 파일 목록 리스트
	@Override
	public List<BoardFileVO> selectThemeBoardFile(String themeNo) throws Exception {
		return session.selectList(BOARD_MAPPER_NAMESPACE + ".selectThemeBoardFile", themeNo);
	}

	//	테마별 리스트 추천 입력
/*	@Override
	public void registBoardRecom(BoardRecomVO boardRecom) throws Exception {
		session.insert(BOARD_MAPPER_NAMESPACE + ".insertBoardRecom",boardRecom);
	}*/
	
	

	

}
