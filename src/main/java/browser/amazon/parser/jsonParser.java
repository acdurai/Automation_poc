package browser.amazon.parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import browser.amazon.commons.configBean;
import browser.amazon.driverCommons.LaunchBrowser;

public class jsonParser extends configBean {
	
	private  Logger log = Logger.getLogger(LaunchBrowser.class.getName());
	
	public JSONObject parseJsonFile(String fileName) {

	        JSONParser parser = new JSONParser();
	        JSONObject jsonObject = null;

	        try {
	        	String path = System.getProperty("user.dir");
	        	log.info("Reading the following json file  " +path+"/src/main/resources/"+fileName );
	        	Reader reader = new FileReader(path+"/src/main/resources/"+fileName);

	            jsonObject = (JSONObject) parser.parse(reader);
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return jsonObject;
	    }
	
	public String getStringData(JSONObject jsonObject, String keyName) {
		String value = (String) jsonObject.get(keyName);
		return value;
	}
	
	public void parseJsonFile() {
		JSONObject jo = parseJsonFile("config.json");
		setBrowserName(getStringData(jo, "browserName").toUpperCase());
		setAppUrl(getStringData(jo, "appurl"));
		
	}
	
	public static void main(String[] args) {
		jsonParser jp = new jsonParser();
		JSONObject jo = jp.parseJsonFile("config.json");
		System.out.println(jp.getStringData(jo, "browserName"));
		System.out.println(jp.getStringData(jo, "appurl"));
	}
	
}
