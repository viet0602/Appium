package common;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class AbstractTest {
	protected AppiumDriver<MobileElement> driver;

	public void startDriverConnection(String udid, String appPackage, String appActivity) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.UDID, "R58N7200YDJ");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Vicky");
		caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		caps.setCapability("noReset", true);
		try {
			driver = new AndroidDriver <MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println("Error in Start Driver Connection"+ e);
		}
	}

	public void close() {
		driver.closeApp();
	}
}
