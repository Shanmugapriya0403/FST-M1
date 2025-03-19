package seleniumpractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
	 public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("https://training-support.net/webelements/alerts");
	        System.out.println("Page title: " + driver.getTitle());

	        driver.findElement(By.id("prompt")).click();

	        Alert promtAlert = driver.switchTo().alert();

	        // Print the text in the alert
	        String alertText = promtAlert.getText();
	        System.out.println("Text in alert: " + alertText);
	        // Type into the alert
	        promtAlert.sendKeys("Awesome!");
	        Thread.sleep(5000);

	        promtAlert.accept();
	        System.out.println(driver.findElement(By.id("result")).getText());

	        driver.quit();
	    }
}
