package org.example;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchoolBright {

    AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 27");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\Appium\\School Bright_7.0.15_Apkpure.apk");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void login()
    {
        driver.manage().timeouts().implicitlyWait(75,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"ข้าม\"]")).click();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"TH\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"School\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text=\" Thossaporn Wittaya School\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Student ID/Staff ID/Mobile No\"]")).sendKeys("+6622544383");
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("Roadstar1988_");
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"LOGIN\"]")).click();
        Assert.assertFalse("Element is displayed on the screen", driver.findElement(By.xpath("//android.widget.TextView[@text=\"CLOSE\"]")).isDisplayed());
    }


    @AfterTest

    public void tearDown(){

        if(driver!=null)
        {
            driver.quit();
        }
    }

}
