/**
 * 
 */
package dataAccess;

/**
 * @author Bushra
 *
 */
public class ChapterData {

	private String chapIntro;
	private Integer chapterNo;
	private String chapLabelArab;
	private String chapLabelEng;
	private Integer bookId;
	private String collectionName;

	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getChapIntro() {
		return chapIntro;
	}
	public void setChapIntro(String chapIntro) {
		this.chapIntro = chapIntro;
	}
	public Integer getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(Integer chapterNo) {
		this.chapterNo = chapterNo;
	}
	public String getChapLabelArab() {
		return chapLabelArab;
	}
	public void setChapLabelArab(String chapLabelArab) {
		this.chapLabelArab = chapLabelArab;
	}
	public String getChapLabelEng() {
		return chapLabelEng;
	}
	public void setChapLabelEng(String chapLabelEng) {
		this.chapLabelEng = chapLabelEng;
	}
	
}
