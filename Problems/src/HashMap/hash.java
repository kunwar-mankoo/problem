package HashMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;


public class hash extends Thread {
	int sumI =0;
	int sumT =0;
	int sumA =0;
	HashMap<String, Integer> map1 = new HashMap<String, Integer>();
	
	public void run() {
		try {
		File file = new File("/Users/DELL/Downloads/Story.txt");
		
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String line = "";
		
		while( (line = buffer.readLine()) != null){
			String line1 = line.toLowerCase();
			String[] strArr = line.split(" ");
			for(String str : strArr){
				if (str.equals("is")) {
				sumI=sumI+1;				
				}
				if (str.equals("the")) {
				sumT=sumT+1;				
				}
				if (str.equals("are")) {
				sumA=sumA+1;				
				}
			}
			
			}			
		
		
		
		buffer.close();
		reader.close(); 
		map1.put("Is", sumI);
		map1.put("The", sumT);
		map1.put("Are", sumA);
		System.out.println(map1);
		
		
	} catch (Exception e) {
		System.out.println("Some Error: "+e);
	}
	}

	public static void main(String[] args) {
		
		hash R =new hash();
		R.start();
		
	}

}
