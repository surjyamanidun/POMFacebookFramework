package com.facebook.base;


import com.facebook.util.TestUtil;
import com.facebook.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver eventFiringWebdriver;
    public static WebEventListener eventListener;
    public static Logger log = Logger.getLogger(TestBase.class);

    public TestBase() {
        prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "C:\\Users\\user\\IdeaProjects\\Facebookpom\\src\\main\\java\\com\\facebook\\config\\config.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // for launching the browser
    public void initialization() {
        log.info(" Starting test case execution ");
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);
        }

        // Capture screenshot when test failed
        eventFiringWebdriver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        eventFiringWebdriver.register(eventListener);
        driver = eventFiringWebdriver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        log.info("entering application URL");
        log.warn("Hey this is just a warning message");
        log.fatal("Hey this is just fatal error message");
        log.debug("this is debug message");

    }
}