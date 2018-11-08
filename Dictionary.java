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
		hm.put("He", "Він");
		hm.put("She", "Вона");
		hm.put("Man", "Чоловік");
		hm.put("Woman", "Жінка");
		hm.put("Boy", "Хлопчик");
		hm.put("Girl", "Дівчинка");
		hm.put("go", "ходить");
		hm.put("to", "на");
		hm.put("at", "до");
		hm.put("work", "роботу");
		hm.put("school", "школи");
		hm.put("every", "кожного");
		hm.put("day", "дня");
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
