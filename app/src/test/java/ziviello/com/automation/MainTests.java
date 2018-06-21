package ziviello.com.automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;

/*
JSON per creare la sessione con APPIUM

{
  "deviceName": "Nexus 5X",
  "appPackage": "ziviello.com.automation",
  "appActivity": ".MainActivity",
  "platformName": "Android"
}

 */

public class MainTests {

    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //sostiture le capability con quelle relative al vostro simulatore
        capabilities.setCapability("deviceName", "Nexus 5X");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "8.1.0");
        //sostiture le capability con quelle relative al vostro progetto
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "ziviello.com.automation");
        capabilities.setCapability("appActivity", ".MainActivity");
        //sostituire il path del vostro server APPIUM nel mio caso e in locale
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void ButtuonsClick() {

        driver.findElement(By.id("button1")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("button2")).click();
    }

    @After
    public void End() {
        driver.quit();
    }
}