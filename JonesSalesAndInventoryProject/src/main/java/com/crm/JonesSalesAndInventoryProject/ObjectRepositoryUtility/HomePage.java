package com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.WebdriverUtility;

/**
 * @author Narahari This page contains the logout method from the application
 * including the links of Product and Supplier modules
 */

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customer_Link;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//span[text()='Employee']")
	private WebElement employee_Link;
	
	@FindBy(xpath = "//a[text()='Keyboard']")
	private WebElement keyboard_Link;
	
	@FindBy(xpath = "//span[text()='Supplier']")
	private WebElement supplier_Link;

	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement admin_Img;

	@FindBy(partialLinkText = "Logout")
	private WebElement logout_Link;

	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement alert_Logout;

	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getCustomer_Link() {
		return customer_Link;
	}

	public WebElement getEmployee_Link() {
		return employee_Link;
	}

	public WebElement getKeyboard_Link() {
		return keyboard_Link;
	}

	public WebElement getSupplier_Link() {
		return supplier_Link;
	}

	public WebElement getAdmin_Img() {
		return admin_Img;
	}

	public WebElement getLogout_Link() {
		return logout_Link;
	}

	public WebElement getAlert_Logout() {
		return alert_Logout;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	/**
	 * This method is used to log out from the Application
	 */

	public void logOutFromApp() {
		WebdriverUtility wUtil = new WebdriverUtility();
		wUtil.mouseMoveOnElement(driver, admin_Img);
		admin_Img.click();
		logout_Link.click();
		alert_Logout.click();
	}
}