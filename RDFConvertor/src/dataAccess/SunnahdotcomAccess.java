package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SunnahdotcomAccess {

	public static Sunnahdotcom setAtt(int volId, int bookId, int number, Connection conn, Statement st){ 
		Sunnahdotcom sdc = new Sunnahdotcom();
		try {
			//System.out.println("volId : "+volId+"bookId: "+bookId+" number: "+number);
			String query = "SELECT `narratorEng` ,`shareLink`"
					+ " FROM `hadith`"
					+ " WHERE `voLId`="+volId+" AND `bookId`="+bookId+" AND `hadithId`="+number ;
			ResultSet s = st.executeQuery(query);
		//	System.out.println(query);
		
		
			while(s.next()){
				sdc.setNarratorEnglish(s.getString(1));
			//	System.out.println(s.getString(1));
				sdc.setLink(s.getString(2));
				System.out.println(s.getString(2));
			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			return sdc;
	}
}
