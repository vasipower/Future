package Files;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/**
 * @author vastvn
 *
 */
public class ReadingFile_Using_Fillo {

public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("C:\\Users\\vastvn\\Desktop\\SSS.xlsx");
		  String strQuery="Select * from vasista where per='13' and name='pspk'";
		//String strQuery="Select * from vasista where name='pk'";
		//String strQuery="Select * from Sheet+" + 1 +" where testcase is not null";
		
		  Recordset recordset=connection.executeQuery(strQuery);
		 
            while(recordset.next()){
	 
            	System.out.println(recordset.getField("Details"));
            	
                }
		
connection.close();
		recordset.close();
	
}}


// Workig as expected for reading data


//String strQuery="Select * from vasista where name='pk'";
//String strQuery="Select * from vasista where per='11' and name='vas'";


