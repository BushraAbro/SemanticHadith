/**
 * 
 */
package dataAccess;

import java.util.ArrayList;

/**
 * @author Bushra
 *
 */
public class HadithData {
	
	// From Sunnah.com
	private Integer InbookHadithNo;
	private String hadithUrl;
	// From Hadith.FH
	private Integer bookId;
	private Integer chapterId; 
	private Integer sequenceNo;
	private String hadithRefNo;
	private String hadithType;
	private String fullHadithA;
	private String fullHadithU;
	private String fullHadithE;
	
	private String mukarrarat;
	private Integer hadithKey;
	
	
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
	public Integer getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	
	public String getHadithRefNo() {
		return hadithRefNo;
	}
	public void setHadithRefNo(String hadithRefNo) {
		this.hadithRefNo = hadithRefNo;
	}
	public String getHadithType() {
		return hadithType;
	}
	public void setHadithType(String hadithType) {
		this.hadithType = hadithType;
	}
	public String getFullHadithA() {
		return fullHadithA;
	}
	public void setFullHadithA(String fullHadithA) {
		this.fullHadithA = fullHadithA;
	}
	public String getFullHadithU() {
		return fullHadithU;
	}
	public void setFullHadithU(String fullHadithU) {
		this.fullHadithU = fullHadithU;
	}
	public String getFullHadithE() {
		return fullHadithE;
	}
	public void setFullHadithE(String fullHadithE) {
		this.fullHadithE = fullHadithE;
	}
	
	
	
	public String getMukarrarat() {
		return mukarrarat;
	}
	public void setMukarrarat(String mukarrarat) {
		this.mukarrarat = mukarrarat;
	}
	
	
	public Integer getInbookHadithNo() {
		return InbookHadithNo;
	}
	public void setInbookHadithNo(Integer inbookHadithNo) {
		InbookHadithNo = inbookHadithNo;
	}
	public String getHadithUrl() {
		return hadithUrl;
	}
	public void setHadithUrl(String hadithUrl) {
		this.hadithUrl = hadithUrl;
	}
	
	
	public Integer getHadithKey() {
		return hadithKey;
	}
	public void setHadithKey(Integer hadithKey) {
		this.hadithKey = hadithKey;
	}

}
