package net.ukr.kondrashev;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {

	private HashMap<String, String> hm = new HashMap<>();
	private String wordEnglish;
	private String wordUkrainian;

	public Dictionary(String wordEnglish, String wordUkrainian) {
		super();
		this.wordEnglish = wordEnglish;
		this.wordUkrainian = wordUkrainian;
	}

	public Dictionary() {
		super();
	}

	public void wordsEnglish() {
		hm.put("He", "³�");
		hm.put("She", "����");
		hm.put("Man", "������");
		hm.put("Woman", "Ƴ���");
		hm.put("Boy", "�������");
		hm.put("Girl", "ĳ������");
		hm.put("go", "������");
		hm.put("to", "��");
		hm.put("at", "��");
		hm.put("work", "������");
		hm.put("school", "�����");
		hm.put("every", "�������");
		hm.put("day", "���");
		hm.forEach((key, value) -> System.out.println(key + " = " + value));
	}

	public String translate(String[] keysNew) {
		String result = "";
		for (int i = 0; i < keysNew.length; i++) {
			result += hm.getOrDefault(keysNew[i], "") + " ";
		}
		return result;
	}

	public void addNewWord() {
		File fileOne = new File("Dictionary.txt");
		try {
			fileOne.createNewFile();
		} catch (IOException e) {
		}
		wordsEnglish();
		hm.put(wordEnglish, wordUkrainian);
		try (PrintWriter pw = new PrintWriter("Dictionary.txt")) {
			hm.forEach((key, value) -> pw.println(key + " = " + value));
			hm.forEach((key, value) -> System.out.println(key + " = " + value));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
