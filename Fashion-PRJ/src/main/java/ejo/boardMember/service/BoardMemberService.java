package ejo.boardMember.service;

import java.util.Map;

import ejo.repository.vo.BoardMemberFileVO;
import ejo.repository.vo.BoardMemberRecomVO;
import ejo.repository.vo.BoardMemberVO;






public interface BoardMemberService {
	
	public void insertBoard(BoardMemberVO boardMember,BoardMemberFileVO boardMemberFile) throws Exception;
	public Map<String,Object>listBoard(String id) throws Exception;
	public void deleteBoard(int memberBoardNo) throws Exception;
	public void registBoardRecom(BoardMemberRecomVO boardMemberRecomVO) throws Exception;
	public int selectRecomCount(BoardMemberRecomVO boardMemberRecomVO) throws Exception;
	public void deleteBoardRecom(BoardMemberRecomVO boardMemberRecomVO) throws Exception;
	
	
}
