package ejo.repository.vo;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int boardNo;
	private String themeCode;
	private String gender;
	private String contentTheme;
	private String contentNote;
	private String contentTip;
	private int recomCnt;
	private int commentCnt;
	private Date regDate;

	private DailyCoordiVO dailyCoordi;
	private ThemeVO theme;

	private List<ItemFileVO> itemList;
	private int idRecomCheck;	

	
	public DailyCoordiVO getDailyCoordi() {
		return dailyCoordi;
	}
	public void setDailCoordiVO(DailyCoordiVO dailyCoordi) {
		this.dailyCoordi = dailyCoordi;
	}
	public ThemeVO getTheme() {
		return theme;
	}
	public void setThemeVO(ThemeVO theme) {
		this.theme = theme;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getThemeCode() {
		return themeCode;
	}
	public void setThemeCode(String themeCode) {
		this.themeCode = themeCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContentTheme() {
		return contentTheme;
	}
	public void setContentTheme(String contentTheme) {
		this.contentTheme = contentTheme;
	}
	public String getContentNote() {
		return contentNote;
	}
	public void setContentNote(String contentNote) {
		this.contentNote = contentNote;
	}
	public String getContentTip() {
		return contentTip;
	}
	public void setContentTip(String contentTip) {
		this.contentTip = contentTip;
	}
	public int getRecomCnt() {
		return recomCnt;
	}
	public void setRecomCnt(int recomCnt) {
		this.recomCnt = recomCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<ItemFileVO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemFileVO> itemList) {
		this.itemList = itemList;
	}
	public int getIdRecomCheck() {
		return idRecomCheck;
	}
	public void setIdRecomCheck(int idRecomCheck) {
		this.idRecomCheck = idRecomCheck;
	}
}
