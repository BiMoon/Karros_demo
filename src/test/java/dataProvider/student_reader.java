package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class student_reader{
	 private Properties properties;
	 private final String propertyFilePath= "src//test//resources//data_input/student_data.properties";
	 
	 public student_reader(){
	 
		 BufferedReader reader;
	 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
	 try {
		 properties.load(reader);
		 reader.close();
	 } catch (IOException e) {
		 e.printStackTrace();
	 	}
	 } 
	 catch (FileNotFoundException e) 
	 	{
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 	} 
	 }
	 
	 public String get_f_name(){
		 String f_name = properties.getProperty("f_name");
		 if(f_name!= null) return f_name;
		 else throw new RuntimeException("This user name is not specified in the Configuration.properties file."); 
	 }
	 
	 public String get_l_name() { 
		 String  l_name= properties.getProperty("l_name");
		 if(l_name != null) return l_name;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
	 }
	 public String get_b_day() { 
		 String  b_day= properties.getProperty("b_day");
		 if(b_day != null) return b_day;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
	 }
	 public String get_grade() { 
		 String  grade = properties.getProperty("grade");
		 if(grade != null) return grade;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
		 
	 }
	 public String get_school_name() { 
		 String  school_name= properties.getProperty("school_name");
		 if(school_name != null) return school_name;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
	 }
	 public String get_student_id() { 
		 String student_id= properties.getProperty("student_id");
		 if(student_id != null) return student_id;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
	 }
	 
	 public String get_lagacy_id() { 
		 String  lagacy_id = properties.getProperty("lagacy_id");
		 if(lagacy_id != null) return lagacy_id;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
	 }
}
