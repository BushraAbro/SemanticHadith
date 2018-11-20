/**
 * 
 */
package dataAccess;

/**
 * @author Bushra
 *
 */
public class HadithData {
	private Integer deprecatedHadithNo; 
	private Integer hadithRefNo;
	private Integer InbookHadithNo;
	private String hadithUrl;
	private String fullHadith;
	private Integer bookId;
	private Integer chapterId;
	private String collectionName; 
	
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
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public Integer getDeprecatedHadithNo() {
		return deprecatedHadithNo;
	}
	public void setDeprecatedHadithNo(Integer deprecatedHadithNo) {
		this.deprecatedHadithNo = deprecatedHadithNo;
	}
	public Integer getHadithRefNo() {
		return hadithRefNo;
	}
	public void setHadithRefNo(Integer hadithRefNo) {
		this.hadithRefNo = hadithRefNo;
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
	public String getFullHadith() {
		return fullHadith;
	}
	public void setFullHadith(String fullHadith) {
		this.fullHadith = fullHadith;
	}

}
