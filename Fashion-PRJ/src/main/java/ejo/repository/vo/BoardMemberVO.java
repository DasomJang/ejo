package ejo.repository.vo;

import java.util.Date;

public class BoardMemberVO {
	
	private int memberBoardNo;
	private String id;
	private String title;
	private int recomCnt;
	private Date regDate;
	private BoardMemberFileVO boardMemberFileVO;
	private int idRecomCheck;

	public int getIdRecomCheck() {
		return idRecomCheck;
	}
	public void setIdRecomCheck(int idRecomCheck) {
		this.idRecomCheck = idRecomCheck;
	}
	public BoardMemberFileVO getBoardMemberFileVO() {
		return boardMemberFileVO;
	}
	public void setBoardMemberFileVO(BoardMemberFileVO boardMemberFileVO) {
		this.boardMemberFileVO = boardMemberFileVO;
	}
	public Date getRegDate() {
		
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public int getMemberBoardNo() {
		return memberBoardNo;
	}
	public void setMemberBoardNo(int memberBoardNo) {
		this.memberBoardNo = memberBoardNo;
	}
	public int getRecomCnt() {
		return recomCnt;
	}
	public void setRecomCnt(int recomCnt) {
		this.recomCnt = recomCnt;
	}
	
	

}
