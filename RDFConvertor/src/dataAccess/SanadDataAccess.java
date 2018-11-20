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
public class SanadDataAccess {

	public static SanadData setSanadAtt(int Index, Connection conn, Statement st){
		SanadData sanad = new SanadData();
		
		try {
			ResultSet s = st.executeQuery("SELECT `narratorEng`, `narratorArab` FROM `hadith2` where `Index`="+Index);
				if(s.next()){
				
					sanad.setSanadTextEng(s.getString(1));
					sanad.setSanadTextArab(s.getString(2));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return sanad;
	}
	
}
