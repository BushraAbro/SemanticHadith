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
//		String hadithRange="";
		try {
			ResultSet s = st.executeQuery("SELECT `booksnames_id`, `c_sequence`,`c_number`, `c_arabic_t`,`c_urdu`,`c_english`,`c_arabic_detail_t`,`c_urdu_detail`,`c_english_detail`,`bookschapters_id` "
					+ "FROM csb_bookschapters where `bookschapters_id`="+Index);
				while(s.next()){
					book.setCollectionID(Integer.parseInt(s.getString(1)));
					book.setSequenceNo(Integer.parseInt(s.getString(2)));
					book.setHadithBookNo(Integer.parseInt(s.getString(3)));
					book.setHadithBookIntroA(s.getString(4));
					book.setHadithBookIntroU(s.getString(5));
					book.setHadithBookIntroE(s.getString(6));
					book.setBookTitleA(s.getString(7));
					book.setBookTitleU(s.getString(8));
					book.setBookTitleE(s.getString(9));	
					book.setBookKey(Integer.parseInt(s.getString(10)));
					
				}
				//return book;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return book;
		
	}
	
}
