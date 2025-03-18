package com.crm.JonesSalesAndInventoryProject.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Narahari
 * This utility file is used for Properties data
 */
public class PropertiesUtility {

	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./configAppData/SalesAndInventory_CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
}