import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	
	public WebDriver driver;

    public TestCase() {
    }

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Login_to_the_application_with_valid_credentials() throws InterruptedException {
    	driver.get("https://www.saucedemo.com/");
       	driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(), "Products");
        
    }
    
    @Test
    public void verify_the_logout_feature() throws InterruptedException {
    	driver.get("https://www.saucedemo.com/");
       	driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login_logo']")).getText(), "Swag Labs");
        
    }

    @AfterTest
    public void tearDown() {
       driver.quit();
    }

}
