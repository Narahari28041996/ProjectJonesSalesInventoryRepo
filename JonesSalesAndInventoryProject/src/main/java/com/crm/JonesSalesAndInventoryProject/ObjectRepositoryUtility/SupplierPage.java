package com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SupplierPage {
	WebDriver driver;

	public SupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//h4/a[@href='#']")
	private WebElement supplierEdit;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchEdit;

	@FindBy(name = "companyname")
	private WebElement companyEdit;
	
	@FindBy(name = "phonenumber")
	private WebElement phoneNumberEdit;
	
	@FindBy(id = "province")
	private WebElement provinceEdit;
	
	@FindBy(id = "city")
	private WebElement cityEdit;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;

	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getSupplierEdit() {
		return supplierEdit;
	}
	
	public WebElement getProvinceEdit() {
		return provinceEdit;
	}

	public WebElement getCityEdit() {
		return cityEdit;
	}

	public WebElement getCompanyEdit() {
		return companyEdit;
	}

	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}
	
	public void createSupplierWithoutProvinceAndCity(String companyName, String phoneNumber) {
		companyEdit.sendKeys(companyName);
		phoneNumberEdit.sendKeys(phoneNumber);
		saveBtn.click();
	}
	
	public void createSupplierWithProvinceAndCity(String companyName, String province, String city, String phoneNumber) {
		companyEdit.sendKeys(companyName);
		Select provinceSel=new Select(provinceEdit);
		provinceSel.selectByVisibleText(province);
		Select citySel=new Select(cityEdit);
		citySel.selectByVisibleText(city);
		phoneNumberEdit.sendKeys(phoneNumber);
		saveBtn.click();
	}
}