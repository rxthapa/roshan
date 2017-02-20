package Collection_Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Collection {

	public static void main(String[] args) {
		HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
		try {
			BufferedReader read = new BufferedReader(new FileReader("C:/Users/Home/Desktop/Roshan_Java_Training/sample.txt"));
			
			Scanner input = new Scanner(new File("C:/Users/Home/Desktop/Roshan_Java_Training/sample.txt"));
			String word;
			int count= 1 ;
			
			while (input.hasNext()){
				word = input.next();
				System.out.printf("%s ", word);
				word = word.toLowerCase();
				
				if (wordcount.containsKey(word)){
					count = wordcount.get(word) + 1;
					wordcount.put(word, count);
				}else
					wordcount.put(word, 1);
			}
			input.close();
		System.out.println("\n");
		} catch (FileNotFoundException e) {
			System.out.println("Unable to Open File.");
		} catch (IOException e) {
			System.out.println(e);
		}
		
		for (Entry<String, Integer> HM: wordcount.entrySet()){
			System.out.printf("%s -->%d", HM.getKey(), HM.getValue());
			System.out.println();
			
		}
		

	}

}
