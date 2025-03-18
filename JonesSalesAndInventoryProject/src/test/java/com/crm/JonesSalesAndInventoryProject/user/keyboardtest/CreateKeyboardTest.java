package com.crm.JonesSalesAndInventoryProject.user.keyboardtest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.JonesSalesAndInventoryProject.BaseClassUtility.BaseClassUtility;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.HomePage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.KeyboardPage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.LoginPage;

/**
 * @author Narahari
 * This is used to integrate the user test data
 * containing the details of the keyboard with
 * customer details in the admin page
 */
//@Listeners(com.crm.SalesAndInventorySystemProject.generic.ListenerUtility.ListenerImplementationClass.class)
public class CreateKeyboardTest extends BaseClassUtility {
	@Test(groups="integrationTest")
	public void createKeyboardTest() throws Throwable {
		String quantity = eUtil.getDataFromExcel("Product", 1, 2);
		String custname = eUtil.getDataFromExcel("Product", 1, 3);
		String price = eUtil.getDataFromExcel("Product", 1, 4);
		HomePage hp = new HomePage(driver);
		hp.getKeyboard_Link().click();
		KeyboardPage mp = new KeyboardPage(driver);
		mp.createMonitor(quantity, custname, price);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		hp.getCustomer_Link().click();
		String searchname = eUtil.getDataFromExcel("Product", 4, 3);
		hp.getSearchBtn().sendKeys(searchname);
		String actSearchName = searchname;
		System.out.println(actSearchName);

		String expSearchName;

		for (;;) {
			try {
				expSearchName = driver.findElement(By.xpath("//td[text()='"+searchname+"']")).getText();
				System.out.println(expSearchName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				nextBtn.click();
			}
		}
		Assert.assertEquals(true, expSearchName.equals(actSearchName));
	}
}