package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NDetailDataAccess {
	public static NarratorsDetail setNarratorAtt(int raqm,Connection conn, Statement st){
		NarratorsDetail narratorDetail;
		try {
			ResultSet s = st.executeQuery("SELECT `RaqamArRavi`,`IsmArRavi`,`Kunyat`,`IsmAsSuhra`,`Nasab`,`Laqab`, `AnNishat`,`Mazhab`,"
					+ "`Rutba`,`Tabqa`,`SunAlWafat`,`SunAlMilad`,`UmmarArRavi`,`AlAqama`,`BaladAlWafat`,`AkhtalatTadlees`,`AlMawali`,`FirstChar`"
					+ "FROM `narratorsdetail` "
					+ "WHERE `RaqamArRavi` ="+raqm);
				while(s.next()){
					narratorDetail = new NarratorsDetail();
					narratorDetail.setNarratorId(Integer.parseInt(s.getString(1)));
					narratorDetail.setNarratorName(s.getString(2));
					narratorDetail.setKunyat(s.getString(3));
					narratorDetail.setIsmShuhra(s.getString(4));
					narratorDetail.setNasab(s.getString(5));
					narratorDetail.setLaqab(s.getString(6));
					narratorDetail.setAnNishat(s.getString(7));
					narratorDetail.setMazhab(s.getString(8));
					narratorDetail.setRutba(s.getString(9));
					narratorDetail.setTabqa(s.getString(10));
					narratorDetail.setDeathYear(s.getString(11));
					narratorDetail.setBirthYear(s.getString(12));
					narratorDetail.setAge(Integer.parseInt(s.getString(13)));
					narratorDetail.setAqamah(s.getString(14));
					narratorDetail.setDeathCity(s.getString(15));
					narratorDetail.setAkhtalatTadlees(s.getString(16));
					narratorDetail.setAlMawali(s.getString(17));
					narratorDetail.setnFirstChar(s.getString(18));
					return narratorDetail;
				}
				//return book;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		
	}
}
