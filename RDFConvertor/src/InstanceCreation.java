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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.StringUtils;
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

	public static void createConnection(String dbName){

		try {
			conn = connectionFactory.createConnection(dbName);
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
	public static void CollectionInstance(String collectionTable){
		createConnection("hadithFH");
		int row = rowCount(collectionTable);
		for(int i = 1; i<=row; i++){
			CollectionDataAccess cda = new CollectionDataAccess();
			CollectionData cd = cda.setCollectionAtt(i, conn, st);
			Integer collectionKey = cd.getCollectionID();
			String namePrefix = CollectionName(collectionKey);
			String collectionKeyPadded = "";
			collectionKeyPadded = padding(collectionKey, 2);
			String instanceName = namePrefix+collectionKeyPadded;
			// Create Collection Instance and add its data properties
			collectionInstance = hadithFactory.createHadithCollection(instanceName);
			//	collectionInstance.addHadithVolumeNo(cd.getVolNo());
			collectionInstance.addLabel(cd.getCollectionArabName()+"@ar");
			collectionInstance.addLabel(cd.getCollectionUrduName()+"@ur");
			collectionInstance.addLabel(cd.getCollectionEngName()+"@en");

		}
		closeConnection();
	}
	public static String padding(Integer number, Integer requiredDigits) {
		String paddedString = "";
		int length = (int) (Math.log10(number) + 1);
		if(length<requiredDigits) {
			 paddedString = String.format("%0"+requiredDigits+"d" , number);
			 return paddedString;
		}
		else {
		return number+"";
		}
	}
	public static String CollectionName(Integer i) {
		String prefix = "";
		switch (i)
		{
		case 1:  prefix = "SB"; // Sahih Bukhari 
		break;
		case 2:  prefix = "SM"; // Sahih Muslim
		break;
		case 3:  prefix = "SD"; // Sunan Abi Dauood
		break;
		case 4:  prefix = "SM"; // Sunan Ibn Maja 
		break;
		case 5:  prefix = "SN"; // Sunan Nasai
		break;
		case 6:  prefix = "JT"; // Jam'i Tirmidhi
		break;
		default: prefix = "misc";
		}
		return prefix;
	}
	// ******************* Create Book Instances *****************
	
	private static HadithBook bookInstance;
	public static void BookInstance(String bookTable){
		createConnection("hadithFH");
		int row = rowCount(bookTable);
		for(int i = 1; i<=row; i++){
			BookDataAccess bda = new BookDataAccess();
			BookData bd = bda.setBookAtt(i, conn, st);
			
			//Instance Name functionality
			String collectionPrefix = CollectionName(bd.getCollectionID());
			int bookKey = bd.getBookKey();
			String bookKeyPadded = padding(bookKey, 2);
			String instanceName = collectionPrefix+"-"+"BK"+bookKeyPadded;
		
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
			
			String collectionName = collectionPrefix+padding(bd.getCollectionID(), 2);
			collectionInstance = hadithFactory.getHadithCollection(collectionName);
			bookInstance.addIsPartOf(collectionInstance);
				
		}
		closeConnection();
	}

	// ******************* Create Chapter Instances *****************
	private static HadithChapter chapterInstance;
	public static void ChapterInstance(String chapterTable)
	{
		createConnection("hadithFH");	
		int row = rowCount( chapterTable);
		String collectionPrefix = chapterTable.replaceAll("\\_.*","");
		collectionPrefix = CollectionPrefix(collectionPrefix);
		for(int i=1; i<=row; i++){
			ChapterDataAccess cda = new ChapterDataAccess();
			ChapterData cd = cda.setChapterAtt(i, conn, st);
			
			//Instance Name functionality
			
			int chapKey = cd.getChapKey();
			String chapKeyPadded = padding(chapKey, 4);
			String instanceName = collectionPrefix+"-"+"CH"+chapKeyPadded;
			// Create Chapter Instance and add its data properties
			chapterInstance = hadithFactory.createHadithChapter(instanceName);
			chapterInstance.addHadithChapterNo(cd.getChapterNo());
			chapterInstance.addSequenceNo(cd.getSequenceNo());
			chapterInstance.addLabel(cd.getChapLabelArab()+"@ar");
			chapterInstance.addLabel(cd.getChapLabelUrdu()+"@ur");
			chapterInstance.addLabel(cd.getChapLabelEng()+"@en");
			
			// Object Type Properties
			String bookName =collectionPrefix +"-BK"+padding(cd.getBookId(),2);
			bookInstance = hadithFactory.getHadithBook(bookName);
			chapterInstance.addIsPartOf(bookInstance);

		}
		ChapterTarjama(collectionPrefix);
		closeConnection();
		
	}
	public static String CollectionPrefix(String tableName) {
		String prefix = "";
		switch (tableName)
		{
		case "csb":  prefix = "SB"; // Sahih Bukhari 
		break;
		case "csm":  prefix = "SM"; // Sahih Muslim
		break;
		case "sab":  prefix = "SD"; // Sunan Abi Dauood
		break;
		case "maj":  prefix = "SM"; // Sunan Ibn Maja 
		break;
		case "nis":  prefix = "SN"; // Sunan Nasai
		break;
		case "tir":  prefix = "JT"; // Jam'i Tirmidhi
		break;
		default: prefix = "msc";
		}
		return prefix;
	}
	// ************* Chapter Tarjama ************
	public static void ChapterTarjama(String collectionPrefix)
	{
		ChapterTarjamaAccess cta = new ChapterTarjamaAccess();
		ChapterTarjama ct = cta.setTarjamah(conn, st);
		for (int j=0; j<ct.gethChapterNo().size(); j++) {
			String chapName = collectionPrefix+"-CH"+padding(ct.gethChapterNo().get(j),4);
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
	//private static Hadith hadithInstance;
	public static void HadithInstance(String hadithTable){
		createConnection("hadithFH");
		int row = rowCount(hadithTable);
		Hadith hadithInstance;
		String collectionPrefix = hadithTable.replaceAll("\\_.*","");
		collectionPrefix = CollectionPrefix(collectionPrefix);
		closeConnection();
		for(int i=1; i<=row; i++){
			createConnection("hadithFH");
			HadithDataAccess hda = new HadithDataAccess();
			HadithData hd = hda.setHadithAtt(i, conn, st);
			if(hd.getBookId()!=null){
				
				//Instance Name functionality
				int hadithKey = hd.getHadithKey();
				String hadithKeyPadded = padding(hadithKey, 4);
				String instanceName = collectionPrefix+"-"+"HD"+hadithKeyPadded;
				// Create Hadith Instance and add its data properties
				hadithInstance =	hadithFactory.createHadith(instanceName);
				ArrayList<String> raqmList =	ExtractRaqm(hd.getFullHadithA());
				NDetailDataAccess nda = new NDetailDataAccess();
				int raqmSize = raqmList.size();
				if(raqmSize!=0){
				for(int j=0; j<raqmSize;j++)
				{
					NarratorsDetail nd = nda.setNarratorAtt(Integer.parseInt(raqmList.get(j)), conn, st);
					HNarrator(Integer.parseInt(raqmList.get(j)),nd,hadithInstance);
				}
				}
				hadithInstance.addHadithReferenceNo(hd.getHadithRefNo());
				hadithInstance.addSequenceNo(hd.getSequenceNo());
				//clean Arabic text from html tags
				String fullHadith = hd.getFullHadithA().replaceAll("<[^>]*>", " ");
				hadithInstance.addFullHadith(fullHadith+"@ar");
				hadithInstance.addFullHadith(hd.getFullHadithU()+"@ur");
				hadithInstance.addFullHadith(hd.getFullHadithE()+"@en");
				hadithInstance.addHadithType(hd.getHadithType()+"@ar");

				// Object Type Properties
				String ChapterName = collectionPrefix+"-CH"+padding(hd.getChapterId(),4);
				chapterInstance = hadithFactory.getHadithChapter(ChapterName);
				hadithInstance.addIsPartOf(chapterInstance);
				closeConnection();
		System.out.println("refNo:"+hd.getHadithRefNo()+" vol: "+hd.getEngVol()+"book: "+hd.getEngBook()+"hadith: "+hd.getEngNumber());
		if(hd.getEngBook()!=null){
				String narratorEng = getSunnahLinks(hd.getEngVol(),hd.getEngBook(), hd.getEngNumber(), hadithInstance);
		
				
				hadithInstance.addNarratedBy(hadithFactory.createRootNarrrator("RN"+hadithKeyPadded));
				hadithFactory.getRootNarrrator("RN"+hadithKeyPadded).addName(narratorEng);
		}
				//System.out.println(instanceName);
			}
		}
		System.out.println("missing narrators Record = "+ numberOfMissingRaqm);
	}
	
	//********  Helping Function
	
	public static ArrayList<String> ExtractRaqm(String fullHadith) {
		
		ArrayList<String> narratorTag = new ArrayList();
		ArrayList<String> raqmList = new ArrayList();
		Matcher m = Pattern.compile("\\<a(.*?)\\/a>").matcher(fullHadith);
		while ( m.find() ){
		        if (m.group().length() != 0){
		         // add the chapter-verse group to an arrayList (there can be more than one verse in a Hadith)
		        narratorTag.add(m.group(1));
		        }
		}
	//	System.out.println("size = " +narratorTag.size());
		for(int i=0; i<narratorTag.size(); i++) {
		//	System.out.println(narratorTag.get(i));
			Matcher raqm = Pattern.compile("([0-9]+)").matcher(narratorTag.get(i));
			while(raqm.find()) {
				if(raqm.group().length()!=0) {
					raqmList.add(raqm.group(1));
				}
			}	
		}
		return raqmList;
	}
	public static String getSunnahLinks(int volID, int bookId, int number, Hadith hadithInstance) {
		createConnection("sunnah");
		SunnahdotcomAccess sda = new SunnahdotcomAccess();
		Sunnahdotcom sd = sda.setAtt(volID, bookId, number, conn, st);
		if(sd.getLink()!=null){
		hadithInstance.addSameAs(sd.getLink());
		}else System.out.println("no data returned");
		closeConnection();
		
		return sd.getNarratorEnglish();
	}
	
	// ******************* Create Narrator Instances *****************
	public static void HadithRootNarrator(int raqm, NarratorsDetail nd, Hadith hadithInstance){
		String narratorKeyPadded = padding(raqm, 5);
				String instanceName = "RN"+narratorKeyPadded;

				// Create Hadith Instance and add its data properties
				RootNarrrator rN = hadithFactory.getRootNarrrator(instanceName);
				if(rN==null) {	// Check if Narrator already Exists in ontology

					RootNarrrator narratorInstance =	hadithFactory.createRootNarrrator(instanceName);
					if(nd!=null){
				narratorInstance.addName(nd.getNarratorName()+"@ar");
				narratorInstance.addFirstChar(nd.getnFirstChar());
				narratorInstance.addAkhtalatTadlees(nd.getAkhtalatTadlees());
				narratorInstance.addAlAqama(nd.getAqamah());
				narratorInstance.addAlMawali(nd.getAlMawali());
				narratorInstance.addAnNishat(nd.getAnNishat());
				narratorInstance.addBaladAlWafat(nd.getDeathCity());
				narratorInstance.addIsmAsSuhra(nd.getIsmShuhra());
				narratorInstance.addTaqba(nd.getTabqa());
				narratorInstance.addNasab(nd.getNasab());
				narratorInstance.addLaqab(nd.getLaqab());
				narratorInstance.addUmmarArRavi(nd.getAge());
				narratorInstance.addMazhab(nd.getMazhab());
				narratorInstance.addKunyat(nd.getKunyat());
				narratorInstance.addSunAlMilad(nd.getBirthYear());
				narratorInstance.addSunAlWafat(nd.getDeathYear());
				narratorInstance.addRaqamArRavi(nd.getNarratorId());
				// Object Type Property
				narratorInstance.addNarrated(hadithInstance);
			//	System.out.println("Root narrator created");
			//	System.out.println(narratorInstance);
					}
				}
				// Object Type Properties
				else{
					rN.addNarrated(hadithInstance);
				}

	}
	 // ******************* Create Narrator Instances *****************
	static int numberOfMissingRaqm =0;
	public static void HNarrator(int raqm, NarratorsDetail nd, Hadith hadithInstance){
		String narratorKeyPadded = padding(raqm, 5);
				String instanceName = "HN"+narratorKeyPadded;

				// Create Hadith Instance and add its data properties
				HadithNarrator rN = hadithFactory.getHadithNarrator(instanceName);
				if(rN==null) { // Check if Narrator already Exists in ontology
				HadithNarrator narratorInstance =	hadithFactory.createHadithNarrator(instanceName);

					HadithNarrator narratorInstance1 =	hadithFactory.createHadithNarrator(instanceName);
					if(nd!=null){
				
				narratorInstance1.addName(nd.getNarratorName()+"@ar");
				narratorInstance1.addFirstChar(nd.getnFirstChar());
				narratorInstance1.addAkhtalatTadlees(nd.getAkhtalatTadlees());
				narratorInstance1.addAlAqama(nd.getAqamah());
				narratorInstance1.addAlMawali(nd.getAlMawali());
				narratorInstance1.addAnNishat(nd.getAnNishat());
				narratorInstance1.addBaladAlWafat(nd.getDeathCity());
				narratorInstance1.addIsmAsSuhra(nd.getIsmShuhra());
				narratorInstance1.addTaqba(nd.getTabqa());
				narratorInstance1.addNasab(nd.getNasab());
				narratorInstance1.addLaqab(nd.getLaqab());
				narratorInstance1.addUmmarArRavi(nd.getAge());
				narratorInstance1.addMazhab(nd.getMazhab());
				narratorInstance1.addKunyat(nd.getKunyat());
				narratorInstance1.addSunAlMilad(nd.getBirthYear());
				narratorInstance1.addSunAlWafat(nd.getDeathYear());
				narratorInstance1.addRaqamArRavi(nd.getNarratorId());
					}
					else{
						narratorInstance1.addRaqamArRavi(raqm);
						numberOfMissingRaqm++;
					}
				// Object Type Property
				narratorInstance1.addNarrated(hadithInstance);
			//	System.out.println("narrator created");
			//	System.out.println(narratorInstance);
				}
				// Object Type Properties
				else{
					rN.addNarrated(hadithInstance);
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