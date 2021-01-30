package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestSelenium1 {
	
	public static void main(String[]args) {
	
		
		String result ="";
		
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/FinalISPW/LoginWeb.jsp");
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("gino");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).click();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/input")).click();
		
		WebElement dummy = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/textarea"));
		
		result = dummy.getAttribute("value");
		
		System.out.println(result);
		
		driver.close();
		//return result; 
	}

}
