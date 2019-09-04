import java.util.HashMap;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
  
public class DataCleaner {
    static HashMap<String,String> regextokens = new HashMap<>();
	
    public static void init() {
    	regextokens.put("(Rs|rs|INR|Inr|inr)(\\-|\\,|\\.)?( )?\\w+(\\.\\w+)?","currency");
    	regextokens.put("[0-9]?[0-9]( )?-( )?[0-9]?[0-9]?[0-9]( )?%","percentage");
    	regextokens.put("[0-9]?[0-9]?[0-9]( )?%","percentage");
    	regextokens.put("\\S+(\\.)(com|in|org)","url");
    	regextokens.put("(https|http|bit|www)\\S+\\/\\S+(\\/\\S+)?(\\/\\S+)?", "url");
    	
    }
    
    public static String tokenize(String input){
    	Pattern pattern;
		Matcher m;
		String toBeReplaced = "";
		for (String regex : regextokens.keySet()) {
			pattern = Pattern.compile(regex);
			m = pattern.matcher(input);
			while (m.find()) {
				toBeReplaced = m.group(0);
				input = input.replace(toBeReplaced, regextokens.get(regex));
			}
		}
		return input;    	
    }
    
    public static String trimSpace(String input){
    	String out = "";
    	String arr[] = input.split(" ");
    	for(int i=0;i<arr.length;i++){
    		arr[i] = arr[i].trim();
    		if(arr[i].length()>0)
    			out+=arr[i]+" ";
    	}
    	return out;
    }    
    
    public static String removeSymbols(String input){
    	input = input.replaceAll("\\+", " plus ");
    	input = input.replaceAll("[\"\':,?*()$!&-]", " ");
    	return input;
    }    
    
    public static String cleanData(String input){
    	input = tokenize(input);
		input = removeSymbols(input);
		input = trimSpace(input);
    	return input;
    }    
        
    
	public static void main(String[] args) {
		init();
		String input = "I have Rs. 100 with me. Do you need 50% of it ? There is 5-10% off!!!"; 
		input = "http://happyeasygo.co/kjvry http://bit.ly/2Zt6FpS";
		System.out.println(cleanData(input));
	}
}