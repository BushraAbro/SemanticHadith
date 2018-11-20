/**
 * 
 */


/**
 * @author Bushra
 *
 */
public class MainGlue {
	public static void main(String[] args){
		String SOURCE_FILE = "//Users/bushra/Desktop/HadithVoc.owl";
		// final String SOURCE_URL = "http://www.lodislamica.me/ontology/hadith";
		String OutputFile = "//Users/bushra/Desktop/HadithVocRDF.owl";
	InstanceCreation ic = new InstanceCreation(SOURCE_FILE, OutputFile);
	
	
	ic.InitializeHadithEngine();
	ic.createConnection();
/*	ic.CollectionInstance();
	ic.BookInstance();
	ic.ChapterInstance();
	ic.HadithInstance();
	ic.sanadInstance();
	ic.MatanInstance();
	ic.verseInstance();
	ic.cityInstance();
	ic.AssignObjectProperties();
	ic.saveOnt();*/
	ic.closeConnection();
	
	}
}
