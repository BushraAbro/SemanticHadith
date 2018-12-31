package dataAccess;

import java.util.ArrayList;

public class Sunnahdotcom {
	private Integer volId;
	private Integer bookId;
	private Integer number;
	private String link;
	private String NarratorEnglish;
	
	private ArrayList<Integer> startVerse;
	private ArrayList<Integer> EndVerse;
	private ArrayList<Integer> chapterIndex;
	public Sunnahdotcom(){
		startVerse = new ArrayList<Integer>();
		EndVerse = new ArrayList<Integer>();
		chapterIndex = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getstartVerse() {
		return startVerse;
	}
	public void setstartVerse(ArrayList<Integer> startVerse) {
		this.startVerse = startVerse;
	}
	public ArrayList<Integer> getEndVerse() {
		return EndVerse;
	}
	public void setEndVerse(ArrayList<Integer> EndVerse) {
		this.EndVerse = EndVerse;
	}
	public ArrayList<Integer> getChapterIndex() {
		return chapterIndex;
	}
	public void setChapterIndex(ArrayList<Integer> chapterIndex) {
		this.chapterIndex = chapterIndex;
	}
	public Integer getVolId() {
		return volId;
	}
	public void setVolId(Integer volId) {
		this.volId = volId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNarratorEnglish() {
		return NarratorEnglish;
	}
	public void setNarratorEnglish(String narratorEnglish) {
		NarratorEnglish = narratorEnglish;
	}

}
