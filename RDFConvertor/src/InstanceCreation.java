import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;




import java.util.List;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntology;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.SimpleIRIMapper;

import dataAccess.*;
//import HadithRDFconvertor.*;
import HadithOnto.*;

/**
 * 
 */

/**
 * @author Bushra
 *
 */
public class InstanceCreation  {

	/**
	 * @param args
	 */
	
	public static String SOURCE_FILE;
	public static String OutputFile;
	public static OWLOntology factoryOnt;
	private static OWLOntology owlOntology;
	private static HadithOntoFactory hadithFactory;
	private static OWLOntologyManager manager;
	public static Connection conn = null ;
	public static Statement st = null;
	public InstanceCreation(String SOURCE_FILE, String OutputFile){
		this.SOURCE_FILE=SOURCE_FILE;
		this.OutputFile = OutputFile;
		
	}
	

	public static void InitializeHadithEngine() {

		try {
			// mapping of imported Ontologies 
		//	File file = new File("C:\\Users\\Bushra\\Desktop\\ExampleProject\\quranOntology.owl");
		//	File file2 = new File("C:\\Users\\Bushra\\Desktop\\ExampleProject\\qvoc.owl.ttl");
			manager = OWLManager.createOWLOntologyManager();
		//	IRI iri=IRI.create("http://quranontology.com/Resource/");
		//	IRI iri2 = IRI.create("http://www.nlp2rdf.org/quranvocab#");
		//	manager.addIRIMapper(new SimpleIRIMapper(iri, IRI.create(file)));
		//	manager.addIRIMapper(new SimpleIRIMapper(iri2, IRI.create(file2)));

			// Load Ontology From File
			owlOntology = manager.loadOntologyFromOntologyDocument(new 
					FileInputStream(SOURCE_FILE));
			hadithFactory = new HadithOntoFactory(owlOntology);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void createConnection(){

		try {
			conn = connectionFactory.createConnection();
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnection(){
		try {
			if (conn != null) {
				conn.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException sqlee) {
			sqlee.printStackTrace();
		}
	}
	// ******************* Display the Ontology *****************
	public static void displayIndv(){
		Collection Instances=hadithFactory.getAllHadithInstances();
		Iterator itr=Instances.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	// ******************* Save the Ontology *****************
	public static void saveOnt(){
		factoryOnt=hadithFactory.getOwlOntology();
		File fileformated = new File(OutputFile);
		//Get the Ontology format
		OWLOntologyFormat format = manager.getOntologyFormat(factoryOnt);
		OWLXMLOntologyFormat owlxmlFormat = new OWLXMLOntologyFormat();
		if (format.isPrefixOWLOntologyFormat()) { 
			owlxmlFormat.copyPrefixesFrom(format.asPrefixOWLOntologyFormat()); 
		}
		try {
			manager.saveOntology(factoryOnt, owlxmlFormat, IRI.create(fileformated.toURI()));
		} catch (OWLOntologyStorageException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	// ******************* Helping function: to get number of rows in a sql table *****************
	public static int rowCount(String tableName){
		int count =0;
		try {

			ResultSet r = st.executeQuery("SELECT COUNT(*) AS rowcount FROM "+tableName);
			r.next();
			count = r.getInt("rowcount");
			r.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
public static HadithCollection collectionInstance;
	// ******************* Create Collection Instances *****************
	public static void CollectionInstance(){

		int row = rowCount("02_booksnames");
		for(int i = 1; i<=row; i++){
			CollectionDataAccess cda = new CollectionDataAccess();
			CollectionData cd = cda.setCollectionAtt(i, conn, st);
			String namePrefix = CollectionName(i);
			String instanceName = namePrefix+i;
			// Create Collection Instance and add its data properties
			collectionInstance = hadithFactory.createHadithCollection(instanceName);
			//	collectionInstance.addHadithVolumeNo(cd.getVolNo());
			
			collectionInstance.addLabel(cd.getCollectionArabName()+"@ar");
			collectionInstance.addLabel(cd.getCollectionUrduName()+"@ur");
			collectionInstance.addLabel(cd.getCollectionEngName()+"@en");

		}
	}
	public static String CollectionName(int i) {
		String prefix = "";
		switch (i)
		{
		case 1:  prefix = "CSB"; // Sahih Bukhari 
		break;
		case 2:  prefix = "CSM"; // Sahih Muslim
		break;
		case 3:  prefix = "SAD"; // Sunan Abi Dauood
		break;
		case 4:  prefix = "SIM"; // Sunan Ibn Maja 
		break;
		case 5:  prefix = "SNA"; // Sunan Nasai
		break;
		case 6:  prefix = "JTI"; // Jam'i Tirmidhi
		break;
		}
		return prefix;
	}
	// ******************* Create Book Instances *****************
	
	private static HadithBook bookInstance;
	public static void BookInstance(){
		int row = rowCount("csb_bookschapters");
		for(int i = 1; i<=row; i++){
			BookDataAccess bda = new BookDataAccess();
			BookData bd = bda.setBookAtt(i, conn, st);
			String instanceName = "book"+bd.getSequenceNo();
			// Create Book Instance and add its data properties
			bookInstance = hadithFactory.createHadithBook(instanceName);
			
			bookInstance.addHadithBookNo(bd.getHadithBookNo());
			bookInstance.addSequenceNo(bd.getSequenceNo());
			bookInstance.addLabel(bd.getBookTitleA()+"@ar");
			bookInstance.addLabel(bd.getBookTitleA()+"@ur");
			bookInstance.addLabel(bd.getBookTitleA()+"@en");
			bookInstance.addHadithBookIntro(bd.getHadithBookIntroA()+"@ar");
			bookInstance.addHadithBookIntro(bd.getHadithBookIntroU()+"@ur");
			bookInstance.addHadithBookIntro(bd.getHadithBookIntroE()+"@en");
			
			// Object Type Properties
			String collectionName = "collection"+bd.getCollectionID();
			collectionInstance = hadithFactory.getHadithCollection(collectionName);
			bookInstance.addIsPartOf(collectionInstance);
				
		}
	}

	// ******************* Create Chapter Instances *****************
	private static HadithChapter chapterInstance;
	public static void ChapterInstance()
	{
		
		int row = rowCount("csb_bookssubchapters");
		for(int i=1; i<=row; i++){
			ChapterDataAccess cda = new ChapterDataAccess();
			ChapterData cd = cda.setChapterAtt(i, conn, st);
			String InstanceName = "chapter"+cd.getBookId()+cd.getChapIndex();
			
			// Create Chapter Instance and add its data properties
			chapterInstance = hadithFactory.createHadithChapter(InstanceName);
			chapterInstance.addHadithChapterNo(cd.getChapterNo());
			chapterInstance.addSequenceNo(cd.getSequenceNo());
			chapterInstance.addLabel(cd.getChapLabelArab()+"@ar");
			chapterInstance.addLabel(cd.getChapLabelUrdu()+"@ur");
			chapterInstance.addLabel(cd.getChapLabelEng()+"@en");
			
			// Object Type Properties
			String bookName = "book"+cd.getBookId();
			bookInstance = hadithFactory.getHadithBook(bookName);
			chapterInstance.addIsPartOf(bookInstance);

		}
		ChapterTarjama();
		
		
	}
	// ************* Chapter Tarjama ************
	public static void ChapterTarjama()
	{
		ChapterTarjamaAccess cta = new ChapterTarjamaAccess();
		ChapterTarjama ct = cta.setTarjamah(conn, st);
		for (int j=0; j<ct.gethChapterNo().size(); j++) {
			String chapName = "chapter"+ct.gethBookNo().get(j)+ct.gethChapterNo().get(j);
			chapterInstance = hadithFactory.getHadithChapter(chapName);
			ArrayList<String> tarjamaA = ct.gettarjamaArab();
			ArrayList<String> tarjamaU = ct.gettarjamaEng();
			ArrayList<String> tarjamaE = ct.gettarjamaUrdu();
			chapterInstance.addChapterTarjama(tarjamaA.get(j)+"@ar");
			chapterInstance.addChapterTarjama(tarjamaU.get(j)+"@ur");
		chapterInstance.addChapterTarjama(tarjamaE.get(j)+"@en");
		}
		
	}

	// ******************* Create Hadith Instances *****************
	private static Hadith hadithInstance;
	public static void HadithInstance(){
		int row = rowCount("csb_hadith");
		for(int i=1; i<=row; i++){
			HadithDataAccess hda = new HadithDataAccess();
			HadithData hd = hda.setHadithAtt(i, conn, st);
			if(hd.getBookId()!=null){
				String instanceName = "hadith"+hd.getBookId()+hd.getChapterId()+hd.getHadithRefNo();
				// Create Hadith Instance and add its data properties
				hadithInstance =	hadithFactory.createHadith(instanceName);
				hadithInstance.addHadithReferenceNo(hd.getHadithRefNo());
				hadithInstance.addSequenceNo(hd.getSequenceNo());
				//clean Arabic text from html tags
				String fullHadith = hd.getFullHadithA().replaceAll("<[^>]*>", " ");
				hadithInstance.addFullHadith(fullHadith+"@ar");

				hadithInstance.addFullHadith(hd.getFullHadithU()+"@ur");
				hadithInstance.addFullHadith(hd.getFullHadithE()+"@en");
				hadithInstance.addHadithType(hd.getHadithType()+"@ar");

				// Object Type Properties
				String ChapterName = "chapter"+hd.getBookId()+hd.getChapterId();
				chapterInstance = hadithFactory.getHadithChapter(ChapterName);
				hadithInstance.addIsPartOf(chapterInstance);
			}
		}
	}
	// ******************* Create Narrator Instances *****************
	public static void HadithNarrator(){
		int row = rowCount("csb_hadith");
		for(int i=1; i<=row; i++){
			NarratorDataAccess nda = new NarratorDataAccess();
			Raavi n = nda.setNarratorAtt(i, conn, st);
			if(n.gethadithID()!=null){
				String instanceName = "narrator"+n.gethadithID();

				// Create Hadith Instance and add its data properties
				RootNarrrator narratorInstance =	hadithFactory.createRootNarrrator(instanceName);
				narratorInstance.addName(n.getRaavi()+"@ar");
				System.out.println(n.getRaavi());

				// Object Type Properties
				String hadithName = "hadith"+n.getBookId()+n.getChapterId()+n.gethadithID();
				hadithInstance = hadithFactory.getHadith(hadithName);
				narratorInstance.addNarrated(hadithInstance);
			}
		}
	}
	 
	// ******************* Create Matan Instances *****************
	public static void MatanInstance(){
		int row = rowCount("hadith2");
		for(int i = 1; i<=row; i++){
			MatanDataAccess mda = new MatanDataAccess();
			MatanData md = mda.setMatanAtt(i, conn, st);;
			String instanceName = "matan"+i;
			HadithMatan matanInstance = hadithFactory.createHadithMatan(instanceName);
			matanInstance.addHadithText("See Hadith URL");

			/* not adding actual text due to copyright issue 
			 * matanInstance.addHadithText(md.getHadithTextArab()+"@ar");
			matanInstance.addHadithText(md.getHadithTextEng()+"@en");
			 */
			hadithFactory.getHadith("hadith"+i).addHasPart(matanInstance);
			matanInstance.addIsPartOf(hadithFactory.getHadith("hadith"+i));
		}
	}

	// ******************* Create Sanad Instances *****************
	public static void sanadInstance(){
		int row = rowCount("hadith2");
		for(int i =1; i<=row; i++){
			SanadData sd = SanadDataAccess.setSanadAtt(i, conn, st);;
			String instanceName = "sanad"+i;
			// Create Sanad Instance and add its data properties
			HadithSanad sanadInstance = hadithFactory.createHadithSanad(instanceName);
			sanadInstance.addNarratorChain("See Hadith URL");
			/* not adding actual text due to copyright issue 
			 * sanadInstance.addNarratorChain(sd.getSanadTextArab()+"@ar");
			sanadInstance.addNarratorChain(sd.getSanadTextEng()+"@en");
			 */
			hadithFactory.getHadith("hadith"+i).addHasPart(sanadInstance);
			sanadInstance.addIsPartOf(hadithFactory.getHadith("hadith"+i));
		}
	}

	// ******************* Create Verse Instances *****************
	public static void verseInstance(){
		int row = rowCount("hadith2");
		for(int i=1; i<=row; i++){
			VerseData vd = VerseDataAccess.setVerseData(i, conn, st);
			Hadith hadithInstance = hadithFactory.getHadith("hadith"+i);
			ArrayList<Integer> verseIndexE = vd.getVerseIndexE();
			ArrayList<Integer> verseIndexS = vd.getVerseIndexS();
			ArrayList<Integer> chapterIndex = vd.getChapterIndex();
			int numOfVerses = verseIndexE.size();
			if(numOfVerses!=0){
				if(numOfVerses>1){ 	
					for(int j = 0; j<numOfVerses; j++){
						Verse verseInstance = hadithFactory.createVerse("Verse"+chapterIndex.get(j)+verseIndexS.get(j));	
						verseInstance.addVerseIndex(verseIndexS.get(j));
						verseInstance.addChapterIndex(chapterIndex.get(j));

						hadithInstance.addContainsMentionOf(verseInstance);
						verseInstance.addMentionedIn(hadithInstance);
					}
				}
				else{
					Verse verseInstance = hadithFactory.createVerse("Verse"+chapterIndex.get(0)+verseIndexS.get(0));	
					verseInstance.addVerseIndex(verseIndexS.get(0));
					verseInstance.addChapterIndex(chapterIndex.get(0));
					hadithInstance.addContainsMentionOf(verseInstance);
					verseInstance.addMentionedIn(hadithInstance);
				}
			}
		}
	}

	//  ****************Helping function for CityInstance ****************
	// Read City List from a text file and make a comparison with the Hadith text
	public static ArrayList<String> readCityList(){
		ArrayList<String> cityList = new ArrayList();
		String line=null;
		try
		(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Bushra\\Desktop\\cityList.txt"))) {
			while ((line=br.readLine())!=null) {
				cityList.add(line.trim());
				//  System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cityList;
	}
	// ******************* Create City Instances *****************
	public static void cityInstance(){
		ArrayList<String> cities =readCityList();
		for(int c=0; c<cities.size(); c++){
			if(cities.get(c).contains(",")){
				List<String> list = Arrays.asList(cities.get(c).trim().split(","));
				for(int j= 0; j<list.size(); j++){
					City cityInstance = hadithFactory.createCity(list.get(j).trim());
					cityInstance.addLabel(list.get(j).trim());
				}
			}else {
				City cityInstance = hadithFactory.createCity(cities.get(c).trim());
				cityInstance.addLabel(cities.get(c).trim());
			}
		}

		int row = rowCount("hadith2");
		for(int i=1; i<=row; i++){
			CityData cd = CityDataAccess.setCityAtt(i, conn, st);
			Hadith hadithInstance = hadithFactory.getHadith("hadith"+i);

			ArrayList<String> cityTemp = cd.getCityName();
			if(!(cityTemp.isEmpty())){
				for(int j=0; j<cityTemp.size(); j++){
					City cityInstance = hadithFactory.getCity(cityTemp.get(j));
					hadithInstance.addContainsMentionOf(cityInstance);
					cityInstance.addMentionedIn(hadithInstance);
				}

			}
		}
	}

	public static void AssignObjectProperties(){
		// Get Size of Instances of each Class
		int h_size=hadithFactory.getAllHadithInstances().size();
		int ch_size = hadithFactory.getAllHadithChapterInstances().size();
		int b_size = hadithFactory.getAllHadithBookInstances().size();
		int c_size = hadithFactory.getAllHadithCollectionInstances().size();

		//*************** Check for connections to add Object properties ***********
		//--------------- 1- HadithCollection hasPart HadithBook ---------------\\
		//--------------- 2- HadithBook isPartOf HadithCollection ---------------\\

		for (int i=1; i<=c_size; i++)
		{
			HadithCollection c = hadithFactory.getHadithCollection("collection"+i);
			String col =c.getLabel().iterator().next().toString();
			for(int j=1; j<=b_size; j++)
			{
				HadithBook b =  hadithFactory.getHadithBook("book"+j);
				if(col.equals(b.getCollectionName().iterator().next()+"@en")){
					b.addIsPartOf(c);
					c.addHasPart(b);
				}
			}
		}
		//--------------- 3- HadithBook hasPart HadithChapter ---------------\\
		//--------------- 4- HadithChapter isPartOf HadithBook ---------------\\

		for(int i=1; i<=b_size; i++){
			HadithBook b = hadithFactory.getHadithBook("book"+i);
			for(int j=1; j<=ch_size; j++){
				HadithChapter ch = hadithFactory.getHadithChapter("chapter"+j);
				//System.out.println(b.getHadithBookNo());
				if(ch.getCollectionName().equals(b.getCollectionName())&&
						ch.getHadithBookNo().equals(b.getHadithBookNo()))
				{
					ch.addIsPartOf(b);
					b.addHasPart(ch);
				}
			}
		}

		//--------------- 5- HadithChapter hasPart Hadith ---------------\\
		//--------------- 6- Hadith isPartOf HadithChapter ---------------\\

		for(int i=1; i<=ch_size; i++){
			HadithChapter ch = hadithFactory.getHadithChapter("chapter"+i);
			for(int j=1; j<=h_size; j++){
				Hadith h = hadithFactory.getHadith("hadith"+j);
				if(ch.getCollectionName().equals(h.getCollectionName()) &&
						ch.getHadithBookNo().equals(h.getHadithBookNo())
						&& ch.getHadithChapterNo().equals(h.getHadithChapterNo()))
				{
					ch.addHasPart(h);
					h.addIsPartOf(ch);
				}
			}
		}

	}
}