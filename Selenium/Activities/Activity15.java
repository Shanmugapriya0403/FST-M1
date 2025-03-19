package seleniumpractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-attributes");
        System.out.println("Page title is: " + driver.getTitle());

        // Find the input fields and enter values
        driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]")).sendKeys("Raiden Shogun");
        driver.findElement(By.xpath("//input[contains(@id, '-email')]")).sendKeys("raiden@electromail.com");
        driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]")).sendKeys("2025-06-26");
        driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]")).sendKeys("It will be electric!");
	
        // Find and click the submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Wait for the success message and print it
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")))
                .getText();
        System.out.println("Success message: " + message);

        driver.quit();
    }
}
