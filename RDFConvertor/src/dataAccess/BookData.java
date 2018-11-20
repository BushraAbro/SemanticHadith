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

	 private Integer deprecatedBookNo;
	 private Integer startHadithNo;
	 private Integer endHadithNo;
	 private Integer bookNo;
	 private String bookTitleE;
	 private String bookTitleA;
	 private String collectionName;
	 
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public Integer getDeprecatedBookNo() {
		return deprecatedBookNo;
	}
	public void setDeprecatedBookNo(Integer deprecatedBookNo) {
		this.deprecatedBookNo = deprecatedBookNo;
	}
	public Integer getStartHadithNo() {
		return startHadithNo;
	}
	public void setStartHadithNo(Integer startHadithNo) {
		this.startHadithNo = startHadithNo;
	}
	public Integer getEndHadithNo() {
		return endHadithNo;
	}
	public void setEndHadithNo(Integer endHadithNo) {
		this.endHadithNo = endHadithNo;
	}
	public Integer getBookNo() {
		return bookNo;
	}
	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
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
}
