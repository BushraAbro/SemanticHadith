/**
 * 
 */
package dataAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bushra
 *
 */
public class CityDataAccess {
	
	
	public static CityData setCityAtt(int Index,Connection conn, Statement st){
		String hadithTextA = null;
		String hadithTextE = null;
		
		CityData citydata = new CityData();
		try {
			ResultSet s = st.executeQuery("SELECT `textEng`, `plainText` FROM `hadith2` where `Index`="+Index);
				if(s.next()){
					hadithTextE = s.getString(1);
					hadithTextA = s.getString(2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		ArrayList<String> cities =new ArrayList();
		ArrayList<String> cityNames = new ArrayList();
		cities = readCityList();
		for (int i =0; i<cities.size(); i++){
			if(cities.get(i).contains(",")){
				List<String> list = Arrays.asList(cities.get(i).trim().split(","));
				for(int j= 0; j<list.size(); j++){
				if(hadithTextE.contains(list.get(j).trim())){
					cityNames.add(list.get(j).trim());
					}
				}
				}
			else{
					if(hadithTextE.contains(cities.get(i))){
						cityNames.add(cities.get(i).trim());
						}
					}	
			}
		citydata.setCityName(cityNames);
		return citydata;
	}
	public static ArrayList<String> readCityList(){
		ArrayList<String> cityList = new ArrayList();
		String line=null;
		try
		(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Bushra\\Desktop\\cityList.txt"))) {
		    while ((line=br.readLine())!=null) {
		        cityList.add(line);
		      //  System.out.println(br.readLine());
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityList;
	}

}
