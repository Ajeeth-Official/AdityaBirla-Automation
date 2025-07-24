package org.adityabirla.lifeInsurance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginPage {

	public static WebDriver driver;
	@Test
	public static void browserlanuch() {

		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\eclipse\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://113.193.29.163/ABSLI/Account/Login");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());

	}
	@Test
	public static void loginPage() {

		WebElement username = driver.findElement(By.id("ContentPlaceHolder1_txtUserName"));
		username.sendKeys("gradatim");
		WebElement password = driver.findElement(By.id("ContentPlaceHolder1_txtPassword"));
		password.sendKeys("Password1$");
		WebElement submit =driver.findElement(By.id("ContentPlaceHolder1_btnSubmit"));
		submit.click();
		String title =driver.getTitle();
		System.out.println(title);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
@Test
	public static void changeProduct() throws InterruptedException {

		WebElement account =driver.findElement(By.id("liAccount"));
		account.click();
		Thread.sleep(5000);
		WebElement changeProduct =driver.findElement(By.xpath("//*[@id=\"liAccount\"]/div/ul/li[2]/a"));
		changeProduct.click();

		WebElement product = driver.findElement(By.id("ContentPlaceHolder1_ddlPlan"));
		Select selectPlan = new Select(product);

		List<WebElement> options = selectPlan.getOptions();
		System.out.println("Total options in dropdown: " + options.size());

		for (WebElement option : options) {
			if (option.getText().contains("Group Smart Select")) {
				option.click();
				break;
			}
		}


		WebElement ProductName =driver.findElement(By.id("lblDefaultPlan"));

		String productname1 =ProductName.getText();
		System.out.println(productname1);

		if(productname1.equalsIgnoreCase("Group Smart Select")) {
			driver.quit();
		}
	}

	
	public static void main(String[] args) throws InterruptedException {

		browserlanuch();
		loginPage();
		changeProduct();



	}

}
