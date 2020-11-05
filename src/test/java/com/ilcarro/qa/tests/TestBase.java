package com.ilcarro.qa.tests;

import com.ilcarro.qa.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase implements ITestNGListener {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public void setUp(){
        app.init();

    }
    @BeforeMethod
    public  void  startTest(Method m, Object[] p){
        logger.info("Start test "+ m.getName() + " with data: " + Arrays.asList(p));
    }
    @AfterMethod (alwaysRun = true)
    public  void  stopTest(ITestResult result){

        if (result.isSuccess()){
            logger.info("Passed: Test method " + result.getMethod().getMethodName());
        } else {
            logger.error("Failed: Test method " + result.getMethod().getMethodName());
            logger.info("Screenshot: " + app.session().takeScreenshot());
        }

        logger.info("Stop test ");
        logger.info("===============================================================================================");
    }



    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();
    }


}
