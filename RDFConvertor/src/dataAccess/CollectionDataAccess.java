package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Bushra
 *
 */
public class CollectionDataAccess {

	public static CollectionData setCollectionAtt(int Index,Connection conn, Statement st){
		CollectionData collection = new CollectionData();
		try {
			ResultSet s = st.executeQuery("SELECT `collectionEngName`, `collectionArabName` FROM collection where `Index`="+Index);
			while(s.next()){
				
			collection.setCollectionEngName(s.getString(1));
			collection.setCollectionArabName(s.getString(2));
		//	collection.setVolNo(Integer.parseInt(s.getString(2)));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collection;
	}
	
}
