/**
 * 
 */
package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bushra
 *
 */
public class HadithDataAccess {

	public static HadithData setHadithAtt(int Index,Connection conn, Statement st){
		HadithData hadith = new HadithData();
		
		try {
			ResultSet s = st.executeQuery("SELECT `bookschapters_id`,`bookssubchapters_id`,`sequence`,`hadith_number`,`hadith_type2`, `arabic_t`, "
					+ "`urdu`,`english`,`mukarraat`,`hadith_id`, `english_reference`"
					+ "FROM csb_hadith  "
					+ "WHERE `hadith_number` NOT LIKE 'Q%' AND hadith_id="+Index);
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
				hadith.setHadithKey(Integer.parseInt(s.getString(10)));
		
				// English References are in one column
				// We need to split them to get volID, BookID and Number 
				
				List<String> list = Arrays.asList(s.getString(11).trim().split(","));
				if(list.size()==3) {
					Matcher ids;
					ids = Pattern.compile("([0-9]+)").matcher(list.get(0));
					while(ids.find()) {
						if(ids.group().length()!=0) {
							hadith.setEngVol(Integer.parseInt(ids.group(1)));
						}
					}
					
					 ids = Pattern.compile("([0-9]+)").matcher(list.get(1));
					while(ids.find()) {
						if(ids.group().length()!=0) {
							hadith.setEngBook(Integer.parseInt(ids.group(1)));
						}
					}
					
					 ids = Pattern.compile("([0-9]+)").matcher(list.get(2));
					while(ids.find()) {
						if(ids.group().length()!=0) {
							hadith.setEngNumber(Integer.parseInt(ids.group(1)));
						}
					}
				}

				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hadith;
	}
}
