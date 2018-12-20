package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SunnahdotcomAccess {

	public static Sunnahdotcom setAtt(int volId, int bookId, int number, Connection conn, Statement st){ 
		Sunnahdotcom sdc = new Sunnahdotcom();
		try {
			
			ResultSet s = st.executeQuery("SELECT `narratorEng` ,`shareLink`"
					+ " FROM `hadith2`"
					+ " WHERE `voLId`="+volId+" AND `bookId`="+bookId+" AND `hadithId`="+number );
			while(s.next()){
				sdc.setNarratorEnglish(s.getString(1));
				System.out.println(s.getString(1));
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
