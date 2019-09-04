import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class RunMe {

	public static void readFromFile() {
		File file = new File("data/input.txt");
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null){
				line = DataCleaner.cleanData(line);
				System.out.println(Classifier.classify(line)+"->"+line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		DataCleaner.init();
		Classifier.init();
		readFromFile();
		//String line = "Get Flat 20% OFF* + Up to Rs 200 AmazonPay Cashback on all medicine orders";		
		
	}
}