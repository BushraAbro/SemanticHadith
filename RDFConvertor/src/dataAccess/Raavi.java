package dataAccess;

public class Raavi {

	private String raavi;
	private String hadithRefNo;
	private Integer bookId;
	private Integer chapterId;
	
	
	public String getRaavi() {
		return raavi;
	}
	public void setRaavi(String raavi) {
		this.raavi = raavi;
	}
	public void sethadithID(String hadithRefNo) {
		this.hadithRefNo = hadithRefNo;
	}
	
	public String gethadithID() {
		return hadithRefNo;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
}
