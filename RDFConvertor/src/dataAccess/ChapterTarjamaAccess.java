package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChapterTarjamaAccess {

	public static ChapterTarjama setTarjamah( Connection conn, Statement st){ 
		ChapterTarjama chapTarjama = new ChapterTarjama();
		ArrayList<Integer> hBookNo = new ArrayList<Integer>();
		ArrayList<Integer> hChapterNo = new ArrayList<Integer>();
		ArrayList<String> tarjamaArab = new ArrayList<String>();
		ArrayList<String> tarjamaUrdu = new ArrayList<String>();
		ArrayList<String> tarjamaEng = new ArrayList<String>();
		
		try {
			ResultSet s = st.executeQuery("SELECT csb_bookssubchapters.bookssubchapters_id, csb_hadith.bookschapters_id, csb_hadith.arabic_t, csb_hadith.urdu, csb_hadith.english\n" + 
					"FROM csb_bookssubchapters \n" + 
					"INNER JOIN csb_hadith ON csb_hadith.bookssubchapters_id = csb_bookssubchapters.bookssubchapters_id \n" + 
					"where csb_bookssubchapters.bookssubchapters_id = csb_hadith.bookssubchapters_id AND csb_hadith.hadith_number LIKE 'Q%'");
			while(s.next()) {
				hChapterNo.add(Integer.parseInt(s.getString(1)));
				hBookNo.add(Integer.parseInt(s.getString(2)));
				tarjamaArab.add(s.getString(3));
				tarjamaUrdu.add(s.getString(4));
				tarjamaEng.add(s.getString(5));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		chapTarjama.sethChapterNo(hChapterNo);
		chapTarjama.sethBookNo(hBookNo);
		chapTarjama.settarjamaArab(tarjamaArab);
		chapTarjama.settarjamaUrdu(tarjamaUrdu);
		chapTarjama.settarjamaEng(tarjamaEng);
		return chapTarjama;
	}
}
