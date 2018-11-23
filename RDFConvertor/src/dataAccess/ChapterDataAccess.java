/**
 * 
 */
package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Bushra
 *
 */
public class ChapterDataAccess {

	public static ChapterData setChapterAtt(int Index, Connection conn, Statement st){ 
		ChapterData chapter = new ChapterData();
		try {
			
			ResultSet s = st.executeQuery("SELECT `bookschapters_id`,`s_sequence`,`s_number`,`s_arabic_t`,`s_urdu`,`s_english`"
					+ " FROM csb_bookssubchapters where `bookssubchapters_id`="+Index );
			while(s.next()){
				chapter.setBookId(Integer.parseInt(s.getString(1)));
				chapter.setSequenceNo(Integer.parseInt(s.getString(2)));
				chapter.setChapterNo(s.getString(3));
				chapter.setChapLabelArab(s.getString(4));
				chapter.setChapLabelUrdu(s.getString(5));
				chapter.setChapLabelEng(s.getString(6));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return chapter;
	}
	
}
