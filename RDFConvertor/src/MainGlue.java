/**
 * 
 */


/**
 * @author Bushra
 *
 */
public class MainGlue {
	public static void main(String[] args){
		String SOURCE_FILE = "//Users/bushra/Dropbox/BukhariOntoEvents/HadithVoc.owl";
	//	String SOURCE_FILE = "D:\\Dropbox\\BukhariOntoEvents\\HadithVoc.owl";
		// final String SOURCE_URL = "http://www.lodislamica.me/ontology/hadith";
	//	String OutputFile = "//Users/bushra/Desktop/HadithVocRDF.owl";
		String workingDir = System.getProperty("user.dir");
		String OutputFile = workingDir+"/HadithVocRDFTemp.owl";
		System.out.println(OutputFile);
	InstanceCreation ic = new InstanceCreation(SOURCE_FILE, OutputFile);
	
	ic.InitializeHadithEngine();
	//ic.createConnection("hadithFH");
	ic.CollectionInstance("02_booksnames");
	ic.BookInstance("csb_bookschapters");
	ic.ChapterInstance("csb_bookssubchapters");
	ic.HadithInstance("csb_hadith");
//	ic.HadithNarrator("csb_hadith");
	/*ic.sanadInstance();
	ic.MatanInstance();
	ic.verseInstance();
	ic.cityInstance();
	ic.AssignObjectProperties();
	ic.displayIndv();*/
	ic.saveOnt();
	//ic.closeConnection();
	
	}
}
