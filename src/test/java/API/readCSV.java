package API;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;

public class readCSV {

	String CSV_PATH="src//test//resources//data_input//Student_input.csv";
	List<String> list=new ArrayList<String>();  
	 
	 @BeforeTest
	 public void setup() throws Exception {
	 
	 }

@Test
public void csvDataRead() throws IOException, Exception{
/*
 * Get total student
 * list 100 (total click next = total/100 div -1)
 * First page view
 * add listed student to list
 * read cvs file
 * Iterator to find each row match list student.
 * if find -- print
 * if not find --- add this row to not find temp list
 * clear list student
 * 
 * 
 * 
 */
int n = 0;
CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
CSVReader reader_id = new CSVReader(new FileReader(CSV_PATH));
 String [] csvCell;
 //while loop will be executed till the last line In CSV.
 while ((csvCell = reader.readNext()) != null) {   
	 
	 String FName = csvCell[0];
	 list.add(FName);
	 System.out.print(list.get(n) + "\n");
	 n = n + 1;
 }  
 System.out.print(list.size());
 ListIterator<String> itr=list.listIterator(); 
 
 while ((csvCell = reader_id.readNext()) != null) {   
	  
	 String id = csvCell[0];
	 	Boolean found = list.contains(id);
	 	System.out.print(found + id + "\n");
	 }
 }  
 
}
