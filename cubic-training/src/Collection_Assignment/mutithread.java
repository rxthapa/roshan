package Collection_Assignment;

public class mutithread {

	public static void main(String[] args) {
		
		
		String Filename = "C:/Users/Home/Desktop/Roshan_Java_Training/sample.txt";
		
		Tokenizer T= new Tokenizer(Filename);
		Word_Collection WC = new Word_Collection(Filename);
		
		WC.start();
		try {
			WC.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		T.start();
		

	}

}
