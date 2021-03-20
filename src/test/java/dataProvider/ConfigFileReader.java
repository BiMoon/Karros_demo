package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
public class ConfigFileReader {
 
	 private Properties properties;
	 private final String propertyFilePath= "src//test//resources//data_input/user_pass.properties";
	 
	 
	 public ConfigFileReader(){
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
	 
	 public String getUsername(){
		 String username_email = properties.getProperty("user");
		 if(username_email!= null) return username_email;
		 else throw new RuntimeException("This user name is not specified in the Configuration.properties file."); 
	 }
	 
	 public String getPassword() { 
		 String  password= properties.getProperty("pass");
		 if(password != null) return password;
		 else throw new RuntimeException("Password not specified in the Configuration.properties file."); 
	 }
	 
	 
}