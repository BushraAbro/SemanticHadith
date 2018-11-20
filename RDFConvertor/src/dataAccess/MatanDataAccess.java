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
public class MatanDataAccess {
	
	public static MatanData setMatanAtt(int Index, Connection conn, Statement st){
		
		MatanData matandata = new MatanData();
		try {
			ResultSet s = st.executeQuery("SELECT `textEng`, `textArab` FROM `hadith2` where `Index`="+Index);
				if(s.next()){
					
					matandata.setHadithTextEng(s.getString(1));
					matandata.setHadithTextArab(s.getString(2));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	
		return matandata;
	}
}
