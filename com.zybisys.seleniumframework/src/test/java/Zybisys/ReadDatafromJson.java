package Zybisys;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDatafromJson {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser jsonparser=new JSONParser();
		
		FileReader reader=new FileReader(".\\jsonFiles\\jsonlogin.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject empjsonobject=(JSONObject)obj;
		
		
	}

}
