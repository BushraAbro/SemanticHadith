/**
 * 
 */
package dataAccess;

import java.util.ArrayList;

/**
 * @author Bushra
 *
 */
public class ChapterData {


	private String chapterNo;
	private String chapLabelArab;
	private String chapLabelEng;
	private String chapLabelUrdu;
	private Integer bookId;
	private Integer sequenceNo;
	private Integer chapIndex;
	private Integer chapKey;

	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	public String getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}
	public Integer getChapIndex() {
		return chapIndex;
	}
	public void setChapIndex(Integer chapIndex) {
		this.chapIndex = chapIndex;
	}
	public Integer getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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
	public String getChapLabelUrdu() {
		return chapLabelUrdu;
	}
	public void setChapLabelUrdu(String chapLabelUrdu) {
		this.chapLabelUrdu = chapLabelUrdu;
	}
	public Integer getChapKey() {
		return chapKey;
	}
	public void setChapKey(Integer chapKey) {
		this.chapKey = chapKey;
	}
	
	
}
