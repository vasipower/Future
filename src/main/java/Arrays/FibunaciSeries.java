package Arrays;

public class FibunaciSeries {
public static void main(String[] args) {
	
	     int n1=0,n2=1,n3,i,count=10;    
	     
		 for(i=2;i<10;++i)    
		 {    
		  n3=n1+n2;
		  n1=n2;    
		  n2=n3; 
		  System.out.print(" "+n3); 
		  
		 }
		}}
