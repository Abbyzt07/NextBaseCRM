package com.myProject.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myProject.utilities.BrowserUtils;
import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static ExtentReports report;

    protected static ExtentHtmlReporter htmlReporter;

    protected static ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());

            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();
    }
}
