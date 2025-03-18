package com.crm.JonesSalesAndInventoryProject.BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.HomePage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.LoginPage;
import com.crm.JonesSalesAndInventoryProject.generic.DatabaseUtility.DatabaseUtility;
import com.crm.JonesSalesAndInventoryProject.generic.FileUtility.ExcelUtility;
import com.crm.JonesSalesAndInventoryProject.generic.FileUtility.PropertiesUtility;
import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.JavaUtility;
import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.UtilityClassObject;
import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.WebdriverUtility;


public class BaseClassUtility {
	public DatabaseUtility db = new DatabaseUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebdriverUtility wUtil = new WebdriverUtility();
	public PropertiesUtility pUtil = new PropertiesUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws Exception {
		System.out.println("-----Connect to DB, Report Config-----");
		db.getDatabaseConnection();
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configCS() throws Exception {
		System.out.println("-----Launch the Browser-----");
		String BROWSER = pUtil.getDataFromPropertiesFile("browser");
		//String BROWSER=browser;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		wUtil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		String URL = pUtil.getDataFromPropertiesFile("url");
		driver.get(URL);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Exception {
		System.out.println("-----Login to Sales And Inventory System Application -----");
		String USERNAME = pUtil.getDataFromPropertiesFile("username");
		String PASSWORD = pUtil.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() throws Exception {
		System.out.println("-----Logout from the  Sales And Inventory System Application ------");
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() throws Exception {
		System.out.println("-----Close the Browser-----");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("-----Disconnect to DB, Report Backup-----");
		db.closeDatabaseConnection();
	}

}