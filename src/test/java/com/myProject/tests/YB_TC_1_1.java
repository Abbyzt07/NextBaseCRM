package com.myProject.tests;

import com.myProject.pages.DashboardPage;
import com.myProject.pages.LoginPage;
import com.myProject.pages.MessageTabPage;
import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class YB_TC_1_1 extends TestBase{



    @Test
    public void test1_1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.messageTab.click();

        MessageTabPage messageTabPage = new MessageTabPage();
        messageTabPage.uploadFilesIcon.click();
        Thread.sleep(2000);

        messageTabPage.uploadFilesandImages.sendKeys("C:\\Users\\burhan\\Desktop\\images\\access-modifier.png");


    }
}
