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
public class VerseDataAccess {
	
	public static VerseData setVerseData(int Index, Connection conn, Statement st){
		ArrayList<String> verseList = new ArrayList() ;
		VerseData  versedata = new VerseData();
		String verses;
		try {
			
			ArrayList<Integer> verseIndexS = new ArrayList<Integer>();
			ArrayList<Integer> verseIndexE = new ArrayList<Integer>();
			ArrayList<Integer> chapterIndex = new ArrayList<Integer>();
			
			// Read verse Index from the database 
			// which is in the form (chapterIndex, From VerseNo, To verseseNo) e.g (74, 5,5) 
			ResultSet s = st.executeQuery("SELECT `verseNo` FROM `hadith2` where `index`="+Index);
				while(s.next()){
					
				 verses = s.getString(1);
				 // if hadith contains some verse
				 if(verses!=null){
					 // extract chapter no. and verse number by using regex
					Matcher m = Pattern.compile("\\((.*?)\\)").matcher(verses);
					while ( m.find() ){
					        if (m.group().length() != 0){
					         // add the chapter-verse group to an arrayList (there can be more than one verse in a Hadith)
					        verseList.add(m.group(1));
					        }
					}
				 }
				}
				
				// Split Chapter-verse group to chapter Index and Verse Index 
				for (int i =0; i<verseList.size(); i++){ 
				List<String> list = Arrays.asList(verseList.get(i).trim().split(","));
				chapterIndex.add(Integer.parseInt(list.get(0)));
				verseIndexS.add(Integer.parseInt(list.get(1)));
				verseIndexE.add(Integer.parseInt(list.get(2)));
				int tempchap = chapterIndex.get(i)+1;
				chapterIndex.set(i, tempchap);
				}
				versedata.setChapterIndex(chapterIndex);
				versedata.setVerseIndexS(verseIndexS);
				versedata.setVerseIndexE(verseIndexE);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return versedata;
	}
}
