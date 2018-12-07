package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NarratorDataAccess {

	public static Raavi setNarratorAtt(int Index,Connection conn, Statement st){
		Raavi narrator = new Raavi();
		
		try {
			ResultSet s = st.executeQuery("SELECT `Travi`, `hadith_number`,`bookschapters_id`,`bookssubchapters_id` "
					+ "FROM csb_hadith  "
					+ "WHERE `hadith_number` NOT LIKE 'Q%' AND hadith_id="+Index);
			while(s.next()){
				
				narrator.setRaavi(s.getString(1));
				narrator.sethadithID(s.getString(2));
				narrator.setBookId(Integer.parseInt(s.getString(3)));
				narrator.setChapterId(Integer.parseInt(s.getString(4)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return narrator;
	}
}
