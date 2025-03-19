package seleniumpractice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/selects");
        System.out.println("Page title: " + driver.getTitle());

        // Find the dropdown
        WebElement selectElement = driver.findElement(By.cssSelector("select.h-80"));
        // Pass the WebElement to the Select object
        Select multiSelect = new Select(selectElement);

        // Select "HTML" using visible text
        multiSelect.selectByVisibleText("HTML");
        // Select 4th, 5th, and 6th index options
        for (int i = 3; i <= 5; i++) {
            multiSelect.selectByIndex(i);
        }
        // Select "Node" using value attribute
        multiSelect.selectByValue("nodejs");
        // Print the selected options
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Deselect the 5th index option
        multiSelect.deselectByIndex(4);
        // Print the selected options
        selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}
