package com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.JonesSalesAndInventoryProject.generic.WebDriverUtility.WebdriverUtility;

public class KeyboardPage {
	WebDriver driver;

	public KeyboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@value='Add'])[1]")
	private WebElement addBtn;
	
	@FindBy(name = "customer")
	private WebElement customerEdit;
	
	@FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//input[@placeholder='ENTER CASH']")
	private WebElement entercashEdit;
	
	@FindBy(xpath = "//button[text()='PROCEED TO PAYMENT']")
	private WebElement proceedBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getCustomerEdit() {
		return customerEdit;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getEntercashEdit() {
		return entercashEdit;
	}

	public WebElement getProceedBtn() {
		return proceedBtn;
	}
	
	public void createKeyboard(String quantity, String customername, String cash) {
		addBtn.click();
		Select customerSel = new Select(customerEdit);
		customerSel.selectByVisibleText(customername);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		submitBtn.click();
		entercashEdit.sendKeys(cash);
		proceedBtn.click();
		WebDriverWait successWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert successA=successWait.until(ExpectedConditions.alertIsPresent());
		successA.accept();
	}
}
