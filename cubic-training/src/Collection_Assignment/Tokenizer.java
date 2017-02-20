package Collection_Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Tokenizer extends Thread {
	String Filename;
	
	Tokenizer(String Filename){
		this.Filename = Filename;
	}

	public void run(){
		try {
			this.count_words();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void count_words() throws IOException {
		BufferedReader read = null;
		String Sentence = null;
		int total_words = 0;
		
		
		try {
			read = new BufferedReader(new FileReader(this.Filename));
			System.out.println("File Opened...");
			
			Sentence = read.readLine(); //read the first line
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find File on the folder...Please check the file agian.....");
		}
		
		while(Sentence != null){
			StringTokenizer st = new StringTokenizer(Sentence);
				while (st.hasMoreTokens()) {
					st.nextToken();
					total_words++;
				}
					Sentence = read.readLine();
		}
		read.close();
		System.out.println("Total Words in the files are: "+ total_words);
		System.out.println("File Closed Successfully...........");
		
		


	}
}
