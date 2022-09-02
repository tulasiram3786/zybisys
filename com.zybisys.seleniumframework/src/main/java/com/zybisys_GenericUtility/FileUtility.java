package com.zybisys_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * this is FileUtility Object Libraries
 * @author Tulasiram
 *
 */
public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on key which you pass as an argument 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertiesData(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.PROPERTIFILE_PATH);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}
