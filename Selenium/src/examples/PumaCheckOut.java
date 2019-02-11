package examples;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PumaCheckOut {
	
	@Test
	public void checkOut() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//launch url
		driver.get("https://in.puma.com/");
		String link = driver.getCurrentUrl();
		
		try {
			URL url = new URL(link);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int respcode = con.getResponseCode();
			if(respcode == 200) {
				System.out.println("Connection OK, Link is working fine");
			}else
				System.out.println("Not Connected, link or server may have problem");
			
		} catch (IOException e) {
			System.out.println("Exception caught");
		}
		
		
/*		//Naviate to Sports option
		//xpath by link text
		//WebElement sports =  driver.findElement(By.linkText("SPORTS"));
		//xpath by attribute
		//String sportsxp = "//ul/li[4]/a[@data-subnav='sports-subnav']";
		String sportsxp = "//div/div[2]/ul/li[4]/a[contains(text(),'SPORTS')]";
		String sports_football = "//li[3]/div/div/div[1]/ul/li[4]/a[2]";
		
		WebElement sports =  driver.findElement(By.xpath(sportsxp));
		WebElement sports_foot =  driver.findElement(By.xpath(sports_football));
		Actions act = new Actions(driver);
		act.moveToElement(sports).perform();
		
		Thread.sleep(1000);
		
		//works with thread.sleep
		//driver.findElement(By.xpath(sports_football)).click();
		
		//works with thread.sleep
		act.moveToElement(sports_foot).click().perform();

		
//		//WebDriver Wait working
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(sports_foot)).click();
		
		//works
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", sports_foot);
		
		Thread.sleep(1000);
		
		String shoexp = "//ul/div/div/div[1]/li/a[1]";
		WebElement shoesel = driver.findElement(By.xpath(shoexp));
//		act.moveToElement(shoesel).click().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", shoesel);
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(shoesel)).click();
		shoesel.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='180~229']")).click();
		Thread.sleep(2000);
		WebElement add = driver.findElement(By.xpath("//input[@id='add1']"));
		js.executeScript("arguments[0].click();", add);
		Thread.sleep(1000);
		WebElement to_cart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		js.executeScript("arguments[0].click();", to_cart);
		
		Thread.sleep(2000);
		
		WebElement price = driver.findElement(By.xpath("//span[contains(text(),'7,499.00')]"));
		String actual = price.getText();
		String expected = "\u20B97,499.00";
		
		Assert.assertEquals(actual, expected);
		
		WebElement element = driver.findElement(By.xpath("//select[@onchange='this.form.submit()'] "));
		Select selQty = new Select(element);
		WebElement qty = selQty.getFirstSelectedOption();
		String qty1 = qty.getText();
		System.out.println(qty1);
		String actualshoe = qty1;
		String expectshoe = "2 ";

		Assert.assertEquals(actualshoe, expectshoe);

		WebElement finalPrice = driver.findElement(By.xpath("(//span[contains(text(),'14,998')])[2]"));
		String actualfp = finalPrice.getText();
		String expectfp = "\u20B914,998";
		
		Assert.assertEquals(actualfp, expectfp);
		
		
		Thread.sleep(2000);

		//driver.quit();
*/		
		
	}

}
