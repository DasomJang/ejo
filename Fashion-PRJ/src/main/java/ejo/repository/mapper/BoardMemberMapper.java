package ejo.repository.mapper;


import java.util.List;


import ejo.repository.vo.BoardMemberFileVO;
import ejo.repository.vo.BoardMemberRecomVO;
import ejo.repository.vo.BoardMemberVO;







public interface BoardMemberMapper {
	
	public int insertBoard(BoardMemberVO board) throws Exception;
	public void insertBoardFile(BoardMemberFileVO boardMemberFileVO) throws Exception;
	public int selectBoardCount() throws Exception;
	public List<BoardMemberVO> selectBoard(String id) throws Exception;
	public void deleteBoard(int memberBoardNo) throws Exception;
	public void deleteFileByBoardNo(int memberBoardNo) throws Exception;
	
	public void registBoardRecom (BoardMemberRecomVO boardMemberRecomVO) throws Exception;
	public int selectRecomCount(BoardMemberRecomVO boardMemberRecomVO) throws Exception;
	
	//	public BoardMemberFileVO selectBoardFile(int memberBoardNo) throws Exception;
//	public List<BoardMemberFileVO> selectBoardFileDown() throws Exception;
	public BoardMemberFileVO selectBoardFileDown(int memberBoardNo) throws Exception;
	public void deleteBoardRecom(BoardMemberRecomVO boardMemberRecomVO);

}
