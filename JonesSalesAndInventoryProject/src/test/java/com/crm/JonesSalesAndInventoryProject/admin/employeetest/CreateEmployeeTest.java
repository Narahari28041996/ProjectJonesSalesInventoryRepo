package com.crm.JonesSalesAndInventoryProject.admin.employeetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.JonesSalesAndInventoryProject.BaseClassUtility.BaseClassUtility;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.EmployeePage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.HomePage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.LoginPage;
import com.crm.JonesSalesAndInventoryProject.ObjectRepositoryUtility.SupplierPage;

public class CreateEmployeeTest extends BaseClassUtility {
	@Test(groups = { "smokeTest" })
	public void createEmployeeWithoutHireDate() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		String empFirstName = eUtil.getDataFromExcel("Employee", 1, 2);
		String empLastName = eUtil.getDataFromExcel("Employee", 1, 3);
		String empGender = eUtil.getDataFromExcel("Employee", 1, 4);
		String empEmail = eUtil.getDataFromExcel("Employee", 1, 5);
		String empPhoneNumber = eUtil.getDataFromExcel("Employee", 1, 6) + jUtil.getRandomNumber();
		String empJob = eUtil.getDataFromExcel("Employee", 1, 7);
		String empProvince = eUtil.getDataFromExcel("Employee", 1, 9);
		String empMunicipality = eUtil.getDataFromExcel("Employee", 1, 10);
		hp.getEmployee_Link().click();
		EmployeePage empp = new EmployeePage(driver);
		empp.getEmployeeEdit().click();
		empp.createEmployeeWithoutHireDate(empFirstName, empLastName, empGender, empEmail, empPhoneNumber, empJob,
				empProvince, empMunicipality);
		String actEmpFirstName = empFirstName;
		System.out.println(actEmpFirstName);

		String expEmpFirstName;
		for (;;) {
			try {
				expEmpFirstName = driver.findElement(By.xpath("//td[text()='" + empFirstName + "']")).getText();
				System.out.println(expEmpFirstName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				nextBtn.click();
			}
		}
		/*Assert.assertEquals(true, expEmpFirstName.equals(actEmpFirstName));*/
	}

	@Test(groups = {"smokeTest"})
	public void createEmployeeWithHireDate() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		String empFirstName = eUtil.getDataFromExcel("Employee", 1, 2);
		String empLastName = eUtil.getDataFromExcel("Employee", 1, 3);
		String empGender = eUtil.getDataFromExcel("Employee", 1, 4);
		String empEmail = eUtil.getDataFromExcel("Employee", 1, 5);
		String empPhoneNumber = eUtil.getDataFromExcel("Employee", 1, 6) + jUtil.getRandomNumber();
		String empJob = eUtil.getDataFromExcel("Employee", 1, 7);
		String empHireDate = jUtil.getFormatDateDDMMYYYY();
		String empProvince = eUtil.getDataFromExcel("Employee", 1, 9);
		String empMunicipality = eUtil.getDataFromExcel("Employee", 1, 10);
		hp.getEmployee_Link().click();
		EmployeePage empp = new EmployeePage(driver);
		empp.getEmployeeEdit().click();
		empp.createEmployeeWithHireDate(empFirstName, empLastName, empGender, empEmail, empPhoneNumber, empJob,
				empHireDate, empProvince, empMunicipality);
		String actEmpFirstName = empFirstName;
		System.out.println(actEmpFirstName);

		String expEmpFirstName;
		for (;;) {
			try {
				expEmpFirstName = driver.findElement(By.xpath("//td[text()='" + empFirstName + "']")).getText();
				System.out.println(expEmpFirstName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				nextBtn.click();
			}
		}
		Assert.assertEquals(true, expEmpFirstName.equals(actEmpFirstName));
	}

	@Test(groups= "smokeTest")
	public void displayEmployeeDetailsTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();
		String username = eUtil.getDataFromExcel("Product", 1, 5);
		String password = eUtil.getDataFromExcel("Product", 1, 6);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		String empFirstName = eUtil.getDataFromExcel("Employee", 1, 2);
		String empLastName = eUtil.getDataFromExcel("Employee", 1, 3);
		String empGender = eUtil.getDataFromExcel("Employee", 1, 4);
		String empEmail = eUtil.getDataFromExcel("Employee", 1, 5);
		String empPhoneNumber = eUtil.getDataFromExcel("Employee", 1, 6) + jUtil.getRandomNumber();
		String empJob = eUtil.getDataFromExcel("Employee", 1, 7);
		String empProvince = eUtil.getDataFromExcel("Employee", 1, 9);
		String empMunicipality = eUtil.getDataFromExcel("Employee", 1, 10);
		hp.getEmployee_Link().click();
		EmployeePage empp = new EmployeePage(driver);
		empp.getEmployeeEdit().click();
		empp.createEmployeeWithoutHireDate(empFirstName, empLastName, empGender, empEmail, empPhoneNumber, empJob,
				empProvince, empMunicipality);
		empp.getSearchEdit().sendKeys(empFirstName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement detailButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Details')]")));
		detailButton.click();
		String empFullName = eUtil.getDataFromExcel("Employee", 4, 2);
		String actEmpName = empFullName;
		System.out.println(actEmpName);

		String expEmpName = driver.findElement(By.xpath("//h5[contains(text(),'" + empFullName + "')]"))
				.getText();
		System.out.println(expEmpName);
		Assert.assertEquals(true, expEmpName.contains(actEmpName));
	}
}