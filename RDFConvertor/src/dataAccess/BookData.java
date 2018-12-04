/**
 * 
 */
package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bushra
 *
 */
public class BookData {

	 private Integer hadithBookNo;
	 private Integer sequenceNo;
	 private String hadithBookIntroA;
	 private String hadithBookIntroE;
	 private String hadithBookIntroU;
	 
	 private String bookTitleA;
	 private String bookTitleE;
	 private String bookTitleU;
	 
	 private Integer collectionID;
	 private Integer bookTableKey;
	 
	public Integer getHadithBookNo() {
		return hadithBookNo;
	}
	public void setHadithBookNo(Integer hadithBookNo) {
		this.hadithBookNo = hadithBookNo;
	}
	public Integer getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public String getHadithBookIntroA() {
		return hadithBookIntroA;
	}
	public void setHadithBookIntroA(String hadithBookIntroA) {
		this.hadithBookIntroA = hadithBookIntroA;
	}
	public String getHadithBookIntroE() {
		return hadithBookIntroE;
	}
	public void setHadithBookIntroE(String hadithBookIntroE) {
		this.hadithBookIntroE = hadithBookIntroE;
	}
	public String getHadithBookIntroU() {
		return hadithBookIntroU;
	}
	public void setHadithBookIntroU(String hadithBookIntroU) {
		this.hadithBookIntroU = hadithBookIntroU;
	}
	
	
	public String getBookTitleE() {
		return bookTitleE;
	}
	public void setBookTitleE(String bookTitleE) {
		this.bookTitleE = bookTitleE;
	}
	public String getBookTitleA() {
		return bookTitleA;
	}
	public void setBookTitleA(String bookTitleA) {
		this.bookTitleA = bookTitleA;
	}
	public String getBookTitleU() {
		return bookTitleU;
	}
	public void setBookTitleU(String bookTitleU) {
		this.bookTitleU = bookTitleU;
	}
	public Integer getCollectionID() {
		return collectionID;
	}
	public void setCollectionID(Integer collectionID) {
		this.collectionID = collectionID;
		
	}
	
	public Integer getBookKey() {
		return bookTableKey;
	}
	public void setBookKey(Integer bookTableKey) {
		this.bookTableKey = bookTableKey;
	}
}
