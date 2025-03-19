package seleniumpractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("confirmation")).click();

        Alert confirmAlert = driver.switchTo().alert();

        // Print the text in the alert
        String alertText = confirmAlert.getText();
        System.out.println("Text in alert: " + alertText);

        // Close the alert by clicking OK
        confirmAlert.accept();

		
		  //again open confirm alert to cancel
		  driver.findElement(By.id("confirmation")).click(); Alert confirmAlertBox =
		  driver.switchTo().alert();
		  
		  confirmAlert.dismiss();
		 

        System.out.println(driver.findElement(By.id("result")).getText());

        driver.quit();
    }
}
