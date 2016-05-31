package ejo.boardMember.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.BoardMemberMapper;
import ejo.repository.vo.BoardMemberFileVO;
import ejo.repository.vo.BoardMemberRecomVO;
import ejo.repository.vo.BoardMemberVO;

@Service
public class BoardMemberServiceImpl implements BoardMemberService {

	@Autowired
	private BoardMemberMapper dao;
	
	@Override
	public void insertBoard(BoardMemberVO boardMemberVO, BoardMemberFileVO boardMemberFileVO) throws Exception{
		int memberBoardNo = dao.insertBoard(boardMemberVO);
		if(boardMemberFileVO !=null){
			boardMemberFileVO.setMemberBoardNo(memberBoardNo);
			dao.insertBoardFile(boardMemberFileVO);
		
			
		}
	}

	@Override
	public Map<String, Object> listBoard(String id) throws Exception {
		List<BoardMemberVO> list = dao.selectBoard(id);
		
		// 전체 게시글 카운트
		int totalCount = dao.selectBoardCount();
	//	int recomCount = dao.selectRecomCount(boardMemberVO);
		for (int i = 0; i < list.size(); i++) {
			BoardMemberVO memberVO = list.get(i);
			BoardMemberFileVO file = dao.selectBoardFileDown(memberVO.getMemberBoardNo());
			memberVO.setBoardMemberFileVO(file);
		}	
	
	
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("totalCount", totalCount);

		return result;
	}

	@Override
	public void deleteBoard(int memberBoardNo) throws Exception {
		dao.deleteBoard(memberBoardNo);
		//파일삭제
		dao.deleteFileByBoardNo(memberBoardNo);
		
		
	}

	@Override
	public void registBoardRecom(BoardMemberRecomVO boardMemberRecomVO) throws Exception {
		dao.registBoardRecom(boardMemberRecomVO);
		
	}

	@Override
	public int selectRecomCount(BoardMemberRecomVO boardMemberRecomVO) throws Exception {
		return dao.selectRecomCount(boardMemberRecomVO);
	}

	@Override
	public void deleteBoardRecom(BoardMemberRecomVO boardMemberRecomVO) throws Exception {
		dao.deleteBoardRecom(boardMemberRecomVO);
		
	}

}
