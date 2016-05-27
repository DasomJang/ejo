package ejo.board.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.BoardMapperImpl;
import ejo.repository.vo.BoardFileVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapperImpl dao;

	@Override
	public Map<String, Object> detailBoard(int no) throws Exception {
		BoardFileVO file = dao.selectBoardFile(no);
		Map<String, Object> result = new HashMap<>();
		result.put("file", file);
		return result;
	}

}
