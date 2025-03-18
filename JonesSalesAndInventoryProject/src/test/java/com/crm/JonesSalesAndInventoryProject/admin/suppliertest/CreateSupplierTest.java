package com.crm.JonesSalesAndInventoryProject.admin.suppliertest;

import java.time.Duration;

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
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.LoginPage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.SupplierPage;
/**
 * @author Narahari
 * 
 */
@Listeners(com.crm.JonesSalesAndInventoryProject.generic.ListenerUtility.ListenerImplementationClass.class)
public class CreateSupplierTest extends BaseClassUtility {
	@Test(groups = {"smokeTest"})
	public void createSupplierTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		String supplierName = eUtil.getDataFromExcel("Supplier", 1, 1) + jUtil.getRandomNumber();
		String supplierPhoneNumber = eUtil.getDataFromExcel("Supplier", 1, 4);
		hp.getSupplier_Link().click();
		SupplierPage supp = new SupplierPage(driver);
		supp.getSupplierEdit().click();
		supp.createSupplierWithoutProvinceAndCity(supplierName, supplierPhoneNumber);
		String actSupplierName = supplierName;
		System.out.println(actSupplierName);

		String expSupplierName;
		for (;;) {
			try {
				expSupplierName = driver.findElement(By.xpath("//td[text()='" + supplierName + "']")).getText();
				System.out.println(expSupplierName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				nextBtn.click();
			}
		}
		Assert.assertEquals(true, expSupplierName.equals(actSupplierName));
	}

	@Test(groups = {"smokeTest"})
	public void createSupplierWithProvinceAndCity() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		String supplierName = eUtil.getDataFromExcel("Supplier", 4, 1) + jUtil.getRandomNumber();
		String provinceName = eUtil.getDataFromExcel("Supplier", 4, 2);
		String municipalityName = eUtil.getDataFromExcel("Supplier", 4, 3);
		String supplierPhoneNumber = eUtil.getDataFromExcel("Supplier", 4, 4);
		hp.getSupplier_Link().click();
		SupplierPage supp = new SupplierPage(driver);
		supp.getSupplierEdit().click();
		supp.createSupplierWithProvinceAndCity(supplierName, provinceName, municipalityName, supplierPhoneNumber);
		String actSupplierName = supplierName;
		System.out.println(actSupplierName);

		String expSupplierName;
		for (;;) {
			try {
				expSupplierName = driver.findElement(By.xpath("//td[text()='" + supplierName + "']")).getText();
				System.out.println(expSupplierName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				nextBtn.click();
			}
		}
		Assert.assertEquals(true, expSupplierName.equals(actSupplierName));
	}
	
	@Test(groups = {"smokeTest"})
	public void displaySupplierDetailsTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		String supplierName = eUtil.getDataFromExcel("Supplier", 1, 1);
		String supplierPhoneNumber = eUtil.getDataFromExcel("Supplier", 1, 4);
		hp.getSupplier_Link().click();
		SupplierPage supp = new SupplierPage(driver);
		supp.getSupplierEdit().click();
		supp.createSupplierWithoutProvinceAndCity(supplierName, supplierPhoneNumber);
		supp.getSearchEdit().sendKeys(supplierName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement detailButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Details')]")));
		detailButton.click();
		String actSupplierName = supplierName;
		System.out.println(actSupplierName);

		String expSupplierName = driver.findElement(By.xpath("//h5[contains(text(),'" + supplierName + "')]")).getText();
		System.out.println(expSupplierName);
		Assert.assertEquals(true, expSupplierName.contains(actSupplierName));
	}
}