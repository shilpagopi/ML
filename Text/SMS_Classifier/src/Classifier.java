import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Classifier {

	static HashMap<String,Float> travel = new HashMap<>();
	static HashMap<String,Float> dues = new HashMap<>();
	static HashMap<String,Float> coupon = new HashMap<>();
	static HashMap<String,Float> finance = new HashMap<>();
	static HashMap<String,Float> shopping = new HashMap<>();	
	static HashMap<String,Float> spam = new HashMap<>();
	
	static HashMap<String,Float> classifierprob = new HashMap<>();	
		
	public static void init() {		
		readClassVocab("travel",travel);
		readClassVocab("dues",dues);
		readClassVocab("coupon",coupon);
		readClassVocab("finance",finance);
		readClassVocab("shopping",shopping);
		readClassVocab("spam",spam);
		
		computeProb(travel);
		computeProb(dues);
		computeProb(coupon);
		computeProb(finance);
		computeProb(shopping);
		computeProb(spam);
	}	
	
	public static void readClassVocab(String filename, HashMap<String,Float> map) {
		File file = new File("data/"+filename+".txt");
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null){
				map.put(line, (float) 1);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void computeProb(HashMap<String,Float> map) {
		float s = map.size();
		for(String key:map.keySet()){
			map.put(key, (float) (1/s));
		}
	}	
	
	public static Float getClassProb(HashMap<String,Float> map, String arr[]) {
		Float prob = (float) 0;
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				prob+= (float)(Math.log(map.get(arr[i])));
			}
		}
		return Math.abs(prob);
	}	
	
	public static String classify(String input) {
		String arr[] = input.toLowerCase().split(" ");
		classifierprob.put("travel",getClassProb(travel,arr));
		classifierprob.put("dues",getClassProb(dues,arr));
		classifierprob.put("coupon",getClassProb(coupon,arr));
		classifierprob.put("finance",getClassProb(finance,arr));
		classifierprob.put("shopping",getClassProb(shopping,arr));
		classifierprob.put("spam",getClassProb(spam,arr));
		
		float maxscore = 0;
		String label = "";
		for(String key:classifierprob.keySet()){
			if(classifierprob.get(key)>maxscore){
				maxscore = classifierprob.get(key);
				label = key;
			}
		}
		if(label.length()==0)
			return "personal";
		System.out.println("Classifier score:"+maxscore);
		return label;		
	}	
		
	public static void main(String[] args) {
		DataCleaner.init();
		Classifier.init();
		String line = "Get Flat 20% OFF* + Up to Rs 200 AmazonPay Cashback on all medicine orders";
		line = DataCleaner.cleanData(line);
		System.out.println(classify(line));
	}
}