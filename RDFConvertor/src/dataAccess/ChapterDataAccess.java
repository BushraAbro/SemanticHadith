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
			
			ResultSet s = st.executeQuery("SELECT `collectionName`, `bookID`, `ChapterID`, `chapterIntro`, `chapterEng`, "
					+ "`chapterArab` FROM chapter where `Index`="+Index );
			while(s.next()){
				 
				chapter.setCollectionName(s.getString(1));
				chapter.setBookId(Integer.parseInt(s.getString(2)));
				chapter.setChapterNo(Integer.parseInt(s.getString(3)));
				chapter.setChapIntro(s.getString(4));
				chapter.setChapLabelEng(s.getString(5));
				chapter.setChapLabelArab(s.getString(6));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return chapter;
	}
	
}
