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
public class HadithDataAccess {

	public static HadithData setHadithAtt(int Index,Connection conn, Statement st){
		HadithData hadith = new HadithData();
		try {
			ResultSet s = st.executeQuery("SELECT `collectionName`,`reference`,`inBookID`,`inBookHadith`,`hadithId`,`eChapId`,`shareLink` FROM `hadith2` where `Index`="+Index);
			while(s.next()){
				
				
				hadith.setHadithRefNo(s.getInt(2));
				hadith.setBookId(s.getInt(3));
				hadith.setInbookHadithNo(s.getInt(4));
			
				hadith.setChapterId(s.getInt(6));
				hadith.setHadithUrl(s.getString(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hadith;
	}
}
