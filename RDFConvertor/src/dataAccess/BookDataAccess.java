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
public class BookDataAccess {

	public static BookData setBookAtt(int Index,Connection conn, Statement st){
		BookData book = new BookData();
		String hadithRange="";
		try {
			ResultSet s = st.executeQuery("SELECT `c_sequence`,`c_number`, `c_arabic_t`,`c_urdu`,`c_english`,`c_arabic_detail_t`,`c_urdu_detail`,`c_english_detail` FROM csb_bookschapters where `bookschapters_id`="+Index);
				while(s.next()){
					book.setSequenceNo(Integer.parseInt(s.getString(1)));
					book.setHadithBookNo(Integer.parseInt(s.getString(2)));
					book.setBookTitleE(s.getString(3));
					book.setBookTitleA(s.getString(4));
					hadithRange = s.getString(5);
					
					if(!hadithRange.trim().isEmpty())
					{
						List<String> range = Arrays.asList(hadithRange.trim().split("to"));
						book.setStartHadithNo(Integer.parseInt(range.get(0).trim()));
						book.setEndHadithNo(Integer.parseInt(range.get(1).trim()));
					}
					else
						{
						book.setStartHadithNo(null);
						book.setEndHadithNo(null);
						}
					
				}
				//return book;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return book;
		
	}
	
}
