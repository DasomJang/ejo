package ejo.repository.vo;

public class BoardMemberFileVO {

    private int fileNo;
    private int memberBoardNo;
    public int getMemberBoardNo() {
		return memberBoardNo;
	}
	public void setMemberBoardNo(int memberBoardNo) {
		this.memberBoardNo = memberBoardNo;
	}
	private String filePath;
    private String oriFileName;
    private String realFileName;
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOriFileName() {
		return oriFileName;
	}
	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
  

   
}