package ejo.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.BoardMapperImpl;
import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardVO;

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
