package ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Read extends Thread {
	String I="int";
	String S="String";
	String F="float";
	String D="double";
	String C="char";
	ArrayList<String> list1 = new ArrayList<String>();


	public void run() {
		try {
		File file = new File("/Users/DELL/Downloads/VarArgs.java");
		
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String line = "";
		
		while( (line = buffer.readLine()) != null){
			if (line.contains(I)) {
				if(list1.contains("int")==false) {
					list1.add("int");	
				}
								
			}
			else if (line.contains(S)) {
				if(list1.contains("String")==false) {
				list1.add("String");
							}
			}
			else if (line.contains(F)) {
				if(list1.contains("float")==false) {
				list1.add("float");
				}
			}
			else if (line.contains(D)) {
				if(list1.contains("double")==false) {
				list1.add("double");
				}
			}
			else if (line.contains(C)) {
				if(list1.contains("char")==false) {
				list1.add("char");
				}
			}
		}
		
		buffer.close();
		reader.close();
		System.out.println(list1);
		
	} catch (Exception e) {
		System.out.println("Some Error: "+e);
	}
	}
	

	public static void main(String[] args) {
		Read R =new Read();
		R.start();

	}

}
