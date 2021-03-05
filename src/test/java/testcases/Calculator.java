package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.AbstractTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator extends AbstractTest {
	protected static AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void startDriverConnection() {
		DesiredCapabilities caps = new DesiredCapabilities();
		// caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.UDID, "R58N7200YDJ");
		// caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Vicky");
		caps.setCapability("automationName", "UiAutomator1");
		caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		// caps.setCapability("noReset", true);
		// caps.setCapability("skipDeviceInitialization", true);
		// caps.setCapability("skipServerInstallation", true);
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			new WebDriverWait(driver, 10);
		} catch (MalformedURLException e) {
			System.out.println("Error in Start Driver Connection" + e);
		}
	}

	@BeforeMethod
	public void Clear() {
		driver.findElementByAccessibilityId("Clear").click();
	}

	@Test
	public void Minus() {
		driver.findElementByAccessibilityId("1").click();
		driver.findElementByAccessibilityId("Plus").click();
		driver.findElementByAccessibilityId("7").click();
		driver.findElementByAccessibilityId("Equal").click();
		Assert.assertEquals("8", driver.findElementByAccessibilityId("Calculator input field 8").getText());
	}

	@Test
	public void Subtraction() {
		driver.findElementByAccessibilityId("9").click();
		driver.findElementByAccessibilityId("Minus").click();
		driver.findElementByAccessibilityId("6").click();
		driver.findElementByAccessibilityId("Equal").click();
		Assert.assertEquals("3", driver.findElementByAccessibilityId("Calculator input field 3").getText());
	}

	@AfterClass
	public static void TearDown() {
		driver.closeApp();
	}
}
