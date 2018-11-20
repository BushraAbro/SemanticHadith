/**
 * 
 */
package dataAccess;

import java.util.ArrayList;

/**
 * @author Bushra
 *
 */
public class VerseData {
	private ArrayList<Integer> verseIndexS;
	private ArrayList<Integer> verseIndexE;
	private ArrayList<Integer> chapterIndex;
	public VerseData(){
		verseIndexS = new ArrayList<Integer>();
		verseIndexE = new ArrayList<Integer>();
		chapterIndex = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getVerseIndexS() {
		return verseIndexS;
	}
	public void setVerseIndexS(ArrayList<Integer> verseIndexS) {
		this.verseIndexS = verseIndexS;
	}
	public ArrayList<Integer> getVerseIndexE() {
		return verseIndexE;
	}
	public void setVerseIndexE(ArrayList<Integer> verseIndexE) {
		this.verseIndexE = verseIndexE;
	}
	public ArrayList<Integer> getChapterIndex() {
		return chapterIndex;
	}
	public void setChapterIndex(ArrayList<Integer> chapterIndex) {
		this.chapterIndex = chapterIndex;
	}

}
