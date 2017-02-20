package Collection_Assignment;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Word_Collection extends Thread{
	String Filename;
	
	Word_Collection(String filename){
		this.Filename = filename;
	}

	public void run() {
		this.count_words();
	}
		
	synchronized void count_words(){
		HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
		BufferedReader read;
		try {
			read = new BufferedReader(new FileReader(this.Filename));
			System.out.println("File Opened...");
			String Sentence  = null;
			Sentence = read.readLine();
			System.out.println("Here are the content of File.");
			while (Sentence != null){
				int word_count=1;
				String[] Words = Sentence.split(" ");
			    for (int x=0; x<Words.length; x++){
			        System.out.printf("%s ", Words[x]);
			        String word = Words[x].toLowerCase();
				
			        if (wordcount.containsKey(word)){
			        	word_count = wordcount.get(word) + 1;
			        	wordcount.put(word, word_count);
			        }else
			        	wordcount.put(word, 1);
			    }
				System.out.println();
				Sentence = read.readLine();
			}
			read.close();
			System.out.println("\n");
		} catch (FileNotFoundException e) {
			System.out.println("Unable to Open File.");
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println(String.format("%-7s%s", "Word", "Count"));
		System.out.println("-------------");
		for (Entry<String, Integer> HM: wordcount.entrySet()){
			System.out.println(String.format("%-7s-->%d", HM.getKey(), HM.getValue()));
			System.out.println();
			
		}
		
		System.out.println("File Closed Successfully...........\n");
		

	}

}
