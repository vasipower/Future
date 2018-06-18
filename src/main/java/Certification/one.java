package Certification;

public class one {

	   int num = 100; 
		   
		   public void calc(int num)   {  
		      this.num = num * 10;
		      
		   }  
		   
		   public void printNum()   {  
		System.out.println(num);
		   } 
		   public static void main(String   []   args)   {  
			   one obj = new one ();
		      obj.calc(2); 
		      obj.printNum();
		      
		   }
		}