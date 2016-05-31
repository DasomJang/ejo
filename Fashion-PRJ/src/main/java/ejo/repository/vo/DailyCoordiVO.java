package ejo.repository.vo;

public class DailyCoordiVO {
	private int calYear;
	private int calMonth;
	private int calDate;
	private int boardNo;
	private int lastDate;
	
	public int getLastDate() {
		return lastDate;
	}
	public void setLastDate(int lastDate) {
		this.lastDate = lastDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCalYear() {
		return calYear;
	}
	public void setCalYear(int calYear) {
		this.calYear = calYear;
	}
	public int getCalMonth() {
		return calMonth;
	}
	public void setCalMonth(int calMonth) {
		this.calMonth = calMonth;
	}
	public int getCalDate() {
		return calDate;
	}
	public void setCalDate(int calDate) {
		this.calDate = calDate;
	}
}
