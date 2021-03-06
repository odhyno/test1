package test.selenium;

//Corsico Alessandro

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintRequestPostTest {

	@Test
	public void requestPostTest() {

		String result = "";

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/FinalISPW/LoginWeb.jsp");

		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).click();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/input")).click();

		WebElement dummy = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/textarea"));

		result = dummy.getAttribute("value");

		// Create a Logger
		Logger logger = Logger.getLogger(PrintRequestPostTest.class.getName());

		// log messages using log(Level level, String msg)
		logger.log(Level.INFO, result);

		driver.close();
	}

}
