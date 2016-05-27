package ejo.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.BoardFileVO;

@Repository
public class BoardMapperImpl implements BoardMapper {

	@Autowired
	private SqlSessionTemplate session;
	private static final String BOARD_MAPPER_NAMESPACE = "ejo.repository.mapper.BoardMapper";
	public BoardFileVO selectBoardFile(int no) throws Exception {
		return session.selectOne(BOARD_MAPPER_NAMESPACE + ".selectBoardFile", no);
	}

}
