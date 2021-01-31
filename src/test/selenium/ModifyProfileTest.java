package test.selenium;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModifyProfileTest {

	@Test
	public void modifyProfileTest() {

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/FinalISPW/LoginWeb.jsp");

		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).click();

		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/input")).click();

		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[1]/input")).click();

		WebElement dummy = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/textarea"));

		String result = dummy.getAttribute("value");

		// Create a Logger
		Logger logger = Logger.getLogger(ModifyProfileTest.class.getName());

		// log messages using log(Level level, String msg)
		logger.log(Level.INFO, result);

		driver.close();
	}
}
