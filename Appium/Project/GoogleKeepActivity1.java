package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

//Goal: Use the Google Keep app to add a note.

public class GoogleKeepActivity1 {
	AppiumDriver driver;
	WebDriverWait wait;

	// Setup function
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();

		// server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void googleKeepTest() throws InterruptedException {
		// Open the Google Keep app and Click the Create New Note button to add a new
		// Note.
		driver.findElement(AppiumBy.id("com.google.android.keep:id/speed_dial_create_close_button")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
		Thread.sleep(2000);
		// Add a title for the note and add a small description.
		// Find Title and enter a text in it.
		driver.findElement(
		AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]")).sendKeys("Note1");
		// find the note section and add description into it.
		driver.findElement(
		AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]")).sendKeys("This is the first Note");
		// Press the back button
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		Thread.sleep(2000);

		// make an assertion to ensure that the note was added.
		String Noteadded = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\"]")).getText();
		Assert.assertTrue(Noteadded.contains("Note1"));

	}

	// Browser Close
	@AfterClass
	public void closeBrowser() {
		driver.quit();

	}

}
