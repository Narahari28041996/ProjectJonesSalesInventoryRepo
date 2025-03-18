package com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.JavaUtility;
import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.WebdriverUtility;

/**
 * @author Narahari
 * This is used to create the details of 
 * the employee
 */
public class EmployeePage {
	WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4/a[@href='#']")
	private WebElement employeeEdit;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchEdit;
	
	@FindBy(xpath = "(//input[@placeholder='First Name'])[3]/../../div[1]/input")
	private WebElement firstnameEdit;
	
	@FindBy(xpath = "(//input[@placeholder='Last Name'])[3]/../../div[2]/input")
	private WebElement lastnameEdit;
	
	@FindBy(name = "gender")
	private WebElement genderEdit;
	
	@FindBy(xpath = "(//input[contains(@name,'email')])[1]/../../div[4]/input")
	private WebElement emailEdit;
	
	@FindBy(xpath = "(//input[@placeholder='Phone Number'])[3]/../../div[5]/input")
	private WebElement phonenumberEdit;
	
	@FindBy(name = "jobs")
	private WebElement jobEdit;
	
	@FindBy(xpath = "(//input[@placeholder='Hired Date'])[1]/../../div[7]/input")
	private WebElement hiredateEdit;
	
	@FindBy(id = "province")
	private WebElement provinceEdit;
	
	@FindBy(id = "city")
	private WebElement cityEdit;
	
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement saveBtn;

	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getEmployeeEdit() {
		return employeeEdit;
	}

	public WebElement getFirstnameEdit() {
		return firstnameEdit;
	}

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getGenderEdit() {
		return genderEdit;
	}

	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getPhonenumberEdit() {
		return phonenumberEdit;
	}

	public WebElement getJobEdit() {
		return jobEdit;
	}

	public WebElement getHiredateEdit() {
		return hiredateEdit;
	}

	public WebElement getProvinceEdit() {
		return provinceEdit;
	}

	public WebElement getCityEdit() {
		return cityEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param gender
	 * @param email
	 * @param phonenumber
	 * @param job
	 * @param province
	 * @param city
	 */
	
	public void createEmployeeWithoutHireDate(String firstname, String lastname, String gender, String email, String phonenumber, String job, String province, String city) {
		firstnameEdit.sendKeys(firstname);
		lastnameEdit.sendKeys(lastname);
		Select genderSel = new Select(genderEdit);
		genderSel.selectByVisibleText(gender);
		emailEdit.sendKeys(email);
		phonenumberEdit.sendKeys(phonenumber);
		Select jobSel = new Select(jobEdit);
		jobSel.selectByVisibleText(job);
		Select provSel = new Select(provinceEdit);
		provSel.selectByVisibleText(province);
		Select citySel = new Select(cityEdit);
		citySel.selectByVisibleText(city);
		saveBtn.click();
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param gender
	 * @param email
	 * @param phonenumber
	 * @param job
	 * @param hiredate
	 * @param province
	 * @param city
	 */

	public void createEmployeeWithHireDate(String firstname, String lastname, String gender, String email, String phonenumber, String job, String hiredate, String province, String city) {
		firstnameEdit.sendKeys(firstname);
		lastnameEdit.sendKeys(lastname);
		Select genderSel = new Select(genderEdit);
		genderSel.selectByVisibleText(gender);
		emailEdit.sendKeys(email);
		phonenumberEdit.sendKeys(phonenumber);
		Select jobSel = new Select(jobEdit);
		jobSel.selectByVisibleText(job);
		Actions act = new Actions(driver);
		act.sendKeys(hiredateEdit,hiredate).perform();
		Select provSel = new Select(provinceEdit);
		provSel.selectByVisibleText(province);
		Select citySel = new Select(cityEdit);
		citySel.selectByVisibleText(city);
		saveBtn.click();

	}
}
