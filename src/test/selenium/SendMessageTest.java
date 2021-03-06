package test.selenium;

//Monnati Leonardo

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;


public class SendMessageTest {
  private WebDriver driver;
  JavascriptExecutor js;
  private String pw= "password";
	private String us= "username";
	private String message= "message";
  
  
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
 
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void sendMessage() {
    driver.get("http://localhost:8080/FinalISPW/LoginWeb.jsp");
    driver.manage().window().setSize(new Dimension(765, 703));
    driver.findElement(By.name(us)).click();
    driver.findElement(By.name(us)).sendKeys("gino");
    driver.findElement(By.name(pw)).click();
    driver.findElement(By.name(pw)).sendKeys("gino");
    driver.findElement(By.name("action")).click();
    driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(4) > input")).click();
    driver.findElement(By.name(us)).click();
    driver.findElement(By.name(us)).sendKeys("admin");
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    driver.findElement(By.name(message)).click();
    driver.findElement(By.name(message)).sendKeys("nuovo test");
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
  }
}
