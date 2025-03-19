package testngpractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	 
    @BeforeTest
    public void beforeMethod() {
        driver = new FirefoxDriver();
 
        driver.get("https://training-support.net/webelements/target-practice");
    }
 
    @Test
    public void testCase1() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }
 
    @Test
    public void testCase2() {
        // This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }
 
    @Test(enabled = false)
    public void testCase3() {
        // This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
 
    @Test
    public void testCase4() {
        throw new SkipException("Skipping test case");
    }
 
    @AfterTest
    public void afterMethod() {
        // Close the browser
        driver.close();
    }
}
