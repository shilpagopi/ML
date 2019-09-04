import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordHandler {

	static HashMap<String,Integer> vocabfreq = new HashMap<>();
	static int count = 0;
	public static void updateVocab(String line) {
		String arr[] = line.toLowerCase().split(" ");
		for(int i=0;i<arr.length;i++){
			if(vocabfreq.containsKey(arr[i])){
				count = vocabfreq.get(arr[i]);
				vocabfreq.remove(arr[i]);
				vocabfreq.put(arr[i], count+1);
			}
			else
				vocabfreq.put(arr[i], 1);
		}			
	}
	
	public static void buildVocab() {
		File file = new File("data/input.txt");
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null){
				line = DataCleaner.cleanData(line);
				updateVocab(line);
				//System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void printVocab(){
		for(String key: vocabfreq.keySet()){
			System.out.println(key+":"+vocabfreq.get(key));
		}
	}
	
	public static void main(String[] args) {
		DataCleaner.init();
		System.out.println("Hello");
		buildVocab();
		printVocab();
	}
}