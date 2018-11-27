package dataAccess;

import java.util.ArrayList;

public class ChapterTarjama {
	private ArrayList<Integer> hChapterNo;
	private ArrayList<Integer> hBookNo;
	private ArrayList<String> tarjamaArab;
	private ArrayList<String> tarjamaUrdu;
	private ArrayList<String> tarjamaEng;
	
	public ArrayList<Integer> gethChapterNo() {
		return hChapterNo;
	}
	public void sethChapterNo(ArrayList<Integer> hChapterNo) {
		this.hChapterNo = hChapterNo;
	}
	public ArrayList<Integer> gethBookNo() {
		return hBookNo;
	}
	public void sethBookNo(ArrayList<Integer> hBookNo) {
		this.hBookNo = hBookNo;
	}
	
	public ArrayList<String> gettarjamaArab() {
		return tarjamaArab;
	}
	public void settarjamaArab(ArrayList<String> tarjamaArab) {
		this.tarjamaArab = tarjamaArab;
	}
	
	public ArrayList<String> gettarjamaEng() {
		return tarjamaEng;
	}
	public void settarjamaEng(ArrayList<String> tarjamaEng) {
		this.tarjamaEng = tarjamaEng;
	}
	
	public ArrayList<String> gettarjamaUrdu() {
		return tarjamaUrdu;
	}
	public void settarjamaUrdu(ArrayList<String> tarjamaUrdu) {
		this.tarjamaUrdu = tarjamaUrdu;
	}
}
