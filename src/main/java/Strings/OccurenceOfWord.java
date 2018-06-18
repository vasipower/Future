package Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OccurenceOfWord {


	 public static void main(String[] args) throws IOException
	   {

		 BufferedReader br = null;
			FileReader fr = null;

	        FileReader f1=new FileReader("C:\\Users\\vastvn\\Desktop\\Maven\\one.txt");
	        
	        	 // BufferedReader br = new BufferedReader(new FileReader(f1));
	   String FILENAME = "C:\\Users\\vastvn\\Desktop\\Maven\\one.txt";

	        	  
	        	  fr = new FileReader(FILENAME);
	  			br = new BufferedReader(fr);
	  		  String st;
	  			while (( st = br.readLine()) != null){
	  				String arr1=st.toLowerCase();
	  				String[] arr = arr1.split(",");
	  			
	  				
	  			    System.out.println(st);
	  				        int count=0;
	        Map <String,Integer> occurence =new HashMap<String,Integer>();
	        for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i]==arr[j]) {
						count++;
						
					}
					else{
						occurence.put(arr[i], 1);
					}
					
				}
				occurence.put(arr[i],count);
			}
	        System.out.println(occurence);
	    }
	}
}
	/* {
	 File file = new File("C:\\Users\\vastvn\\Desktop\\Maven\\one.txt");
	 
	  BufferedReader br = new BufferedReader(new FileReader(file));
	 
	  String st;
	  try {
		while ((st = br.readLine()) != null)
		    System.out.println(st);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }
	}*/