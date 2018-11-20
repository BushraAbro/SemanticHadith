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
	 private Integer hadithBookIntroA;
	 private Integer hadithBookIntroE;
	 private Integer hadithBookIntroU;
	 private String bookTitleA;
	 private String bookTitleE;
	 private String bookTitleU;
	 
	 
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
	public Integer getHadithBookIntroA() {
		return hadithBookIntroA;
	}
	public void setHadithBookIntroA(Integer hadithBookIntroA) {
		this.hadithBookIntroA = hadithBookIntroA;
	}
	public Integer getHadithBookIntroE() {
		return hadithBookIntroE;
	}
	public void setHadithBookIntroE(Integer hadithBookIntroE) {
		this.hadithBookIntroE = hadithBookIntroE;
	}
	public Integer getHadithBookIntroU() {
		return hadithBookIntroU;
	}
	public void setHadithBookIntroU(Integer hadithBookIntroU) {
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
}
