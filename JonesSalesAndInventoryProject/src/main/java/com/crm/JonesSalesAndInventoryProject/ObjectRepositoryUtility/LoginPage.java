package com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.WebdriverUtility;

/**
 * @author Narahari
 * contains Login page elements and business libraries like
 * login()
 */
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user")
	private WebElement username_Edit;

	@FindBy(name = "password")
	private WebElement password_Edit;

	@FindBy(name = "btnlogin")
	private WebElement login_Btn;


	public WebElement getUsername_Edit() {
		return username_Edit;
	}

	public WebElement getPassword_Edit() {
		return password_Edit;
	}

	public WebElement getLogin_Btn() {
		return login_Btn;
	}

	/**
	 * This method used to login to application based on url,username and password
	 * 
	 * @param url
	 * @param username
	 * @param paswword
	 */

	public void loginToApp(String username, String paswword) {
		username_Edit.sendKeys(username);
		password_Edit.sendKeys(paswword);
		login_Btn.click();
		WebdriverUtility wUtil=new WebdriverUtility();
		wUtil.handlingAlertWithExplicitWait(driver);
	}
}