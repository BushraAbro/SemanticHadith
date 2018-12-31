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

public class SunnahdotcomAccess {

	public static Sunnahdotcom setAtt(int volId, int bookId, int number, Connection conn, Statement st){ 
		Sunnahdotcom sdc = new Sunnahdotcom();
		ArrayList<Integer> startVerse = new ArrayList<Integer>();
		ArrayList<Integer> EndVerse = new ArrayList<Integer>();
		ArrayList<Integer> chapterIndex = new ArrayList<Integer>();
		String verses;
		ArrayList<String> verseList = new ArrayList() ;
		try {
			
			
			
			String query = "SELECT `narratorEng` ,`shareLink`, `verseNo`"
					+ " FROM `hadith2`"
					+ " WHERE `voLId`="+volId+" AND `bookId`="+bookId+" AND `hadithId`="+number ;
			ResultSet s = st.executeQuery(query);
		//	System.out.println(query);
		
		
			while(s.next()){
				sdc.setNarratorEnglish(s.getString(1));
			//	System.out.println(s.getString(1));
				sdc.setLink(s.getString(2));
				System.out.println(s.getString(2));
				verses = s.getString(3);
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
			startVerse.add(Integer.parseInt(list.get(1)));
			EndVerse.add(Integer.parseInt(list.get(2)));
			int tempchap = chapterIndex.get(i)+1;
			chapterIndex.set(i, tempchap);
			}
			sdc.setChapterIndex(chapterIndex);
			sdc.setstartVerse(startVerse);
			sdc.setEndVerse(EndVerse);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			return sdc;
	}
}
