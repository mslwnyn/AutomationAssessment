package za.co.ilab.tshimx.testcases;

/**
 *
 * @author Tshimologo
 */
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.io.InputStream;
import java.util.Properties;
import java.lang.reflect.Method;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import za.co.ilab.tshimx.pageobjects.PageObjects;
import za.co.ilab.tshimx.utils.ThreadLocalDriverFactory;
import za.co.ilab.tshimx.utils.*;

public class BaseTest {
    final static Logger logger = Logger.getLogger(BaseTest.class);
    protected WebDriverWait wait;
    protected Properties env_prop;
    protected PageObjects actionKeywords;
    protected String keyword;
    protected Method method[];
  
    @BeforeTest
    @Parameters({"browser"})
    public void setupTest(String browser) throws Exception {
        this.loadProperties();
        logger.info("setupTest :  " + browser);
        if(browser.equals("chrome")){
             System.setProperty(env_prop.getProperty("chrome.webdriver.name"), env_prop.getProperty("chrome.webdriver.value"));
             logger.info("Initializing the browser:  " + browser );
             ThreadLocalDriverFactory.setThreadLocalDriver(browser);
            // wait = new WebDriverWait(ThreadLocalDriverFactory.getThreadLocalDriver(), 10);
        }
        if(browser.equals("firefox")){
             System.setProperty(env_prop.getProperty("firefox.webdriver.name"), env_prop.getProperty("firefox.webdriver.value"));
            logger.info("Initializing the browser:  " + browser );
            ThreadLocalDriverFactory.setThreadLocalDriver(browser);
            //wait = new WebDriverWait(ThreadLocalDriverFactory.getThreadLocalDriver(), 10);
        }
        if(browser.equals("ie")){
             System.setProperty(env_prop.getProperty("ie.webdriver.name"), env_prop.getProperty("ie.webdriver.value"));
            ThreadLocalDriverFactory.setThreadLocalDriver(browser);
            logger.info("Initializing the browser:  " + browser );
            ThreadLocalDriverFactory.setThreadLocalDriver(browser);
            wait = new WebDriverWait(ThreadLocalDriverFactory.getThreadLocalDriver(), 10);
        }

    }

    public void loadProperties() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
        env_prop = new Properties();
        env_prop.load(inputStream);
        inputStream.close();
    }
    

    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
    

    @Parameters({"browser"})
    @AfterClass
    public void closeBrowser(String browser) {

        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Closed "+browser+" browser  Successfully : "  );
        ThreadLocalDriverFactory.getThreadLocalDriver().quit();
     
    }
    
    protected void execute_Actions(PageObjects base) throws Exception {
        actionKeywords = base;
        method = actionKeywords.getClass().getMethods();
        for (int i = 0; i < method.length; i++) {
            if (method[i].getName().equals(keyword)) {
                method[i].invoke(actionKeywords);
                break;
            }
        }
    }

}
