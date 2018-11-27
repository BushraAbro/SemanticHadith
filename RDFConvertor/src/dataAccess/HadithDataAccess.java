/**
 * 
 */
package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Bushra
 *
 */
public class HadithDataAccess {

	public static HadithData setHadithAtt(int Index,Connection conn, Statement st){
		HadithData hadith = new HadithData();
		
		try {
			ResultSet s = st.executeQuery("SELECT `bookschapters_id`,`bookssubchapters_id`,`sequence`,`hadith_number`,`hadith_type2`, `arabic_t`, "
					+ "`urdu`,`english`,`mukarraat`,`Travi` FROM csb_hadith  WHERE `hadith_number` NOT LIKE 'Q%'"+Index);
			while(s.next()){
				
				hadith.setBookId(Integer.parseInt(s.getString(1)));
				hadith.setChapterId(Integer.parseInt(s.getString(2)));
				hadith.setSequenceNo(Integer.parseInt(s.getString(3)));
				hadith.setHadithRefNo(s.getString(4));
				hadith.setHadithType(s.getString(5));
				hadith.setFullHadithA(s.getString(6));
				hadith.setFullHadithU(s.getString(7));
				hadith.setFullHadithE(s.getString(8));
				hadith.setMukarrarat(s.getString(9));
				hadith.setRaavi(s.getString(10));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hadith;
	}
}
