package za.co.ilab.tshimx.testcases;

/**
 * @author Tshimologo
 */

import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import za.co.ilab.tshimx.pageobjects.ApplyOnlinePage;
import za.co.ilab.tshimx.pageobjects.CareersPage;
import za.co.ilab.tshimx.pageobjects.HomePage;
import za.co.ilab.tshimx.pageobjects.SouthAfricaPage;
import za.co.ilab.tshimx.utils.ThreadLocalDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import za.co.ilab.tshimx.utils.ReadExcel;
import za.co.ilab.tshimx.utils.ThreadLocalExtentReportFactory;
import za.co.ilab.tshimx.utils.ThreadLocalExtentTestFactory;
import za.co.ilab.tshimx.utils.domain.Person;
import za.co.ilab.tshimx.utils.hibernate.HibernateDatabaseAccess;

public class ApplyOnlineTest extends BaseTest {
    final static Logger logger = Logger.getLogger(ApplyOnlineTest.class);

    @Parameters({"browser"})
    @Test
    public void clickCareersLink(String browser) throws Exception {
        
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "ApplyOnlineTest: clickCareersLink Test  ");
        logger.info("Starting Test : clickCareersLink ");
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Starting Test : clickCareersLink ");
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "SETUP - Browser : " + browser );
        ThreadLocalDriverFactory.getThreadLocalDriver().navigate().to(env_prop.getProperty("website.url"));
        Thread.sleep(20000);

        if (ThreadLocalDriverFactory.getThreadLocalDriver().getTitle().equals("Home Page - iLAB")) {
            Assert.assertTrue(true);
            ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.PASS, "Page Title is correct: Home Page - iLAB");
        } else {
            Assert.assertTrue(false);
            ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.FAIL, "Page Title is incorrect. ");
        }

        HomePage homePage = PageFactory.initElements(ThreadLocalDriverFactory.getThreadLocalDriver(), HomePage.class);
        String screenshotPath = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath));
        String sPath = env_prop.getProperty("datafile_url");
        ReadExcel.setExcelFile(sPath, "homePage");
        for (int iRow = 1; iRow <2; iRow++) {
            
            keyword = ReadExcel.getCellData(iRow, 1);
            logger.info("HomePage: The keyword is " +keyword);
            
            execute_Actions(homePage);
        }
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Link Clicked");
        Thread.sleep(20000);
        logger.info("Ending  Test : clickCareersLink Test");
        ThreadLocalExtentReportFactory.getThreadLocalExtentReport().endTest(ThreadLocalExtentTestFactory.getThreadLocalExtentTest());
    }

    @Test(dependsOnMethods = {"clickCareersLink"})
    public void clickSouthAficaLink() throws Exception {

        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO," ApplyOnlineTest: clickSouthAficaLink Test" );
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Starting Test : clickCareersLink Test");
        logger.info("Starting Test : clickCareersLink Test");
        JavascriptExecutor js = (JavascriptExecutor) ThreadLocalDriverFactory.getThreadLocalDriver();
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(20000);
        String screenshotPath = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath));
        Thread.sleep(20000);
        if (ThreadLocalDriverFactory.getThreadLocalDriver().getTitle().equals("CAREERS - iLAB")) {
            Assert.assertTrue(true);
            ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.PASS, "Page Title is correct: CAREERS - iLAB");
        } else {
            Assert.assertTrue(false);
            ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.FAIL, "Page Title is incorrect. ");
        }
        CareersPage careersPage = PageFactory.initElements(ThreadLocalDriverFactory.getThreadLocalDriver(), CareersPage.class);
        String sPath = env_prop.getProperty("datafile_url");
        ReadExcel.setExcelFile(sPath, "careerspage");
        for (int iRow = 1; iRow <2; iRow++) {
            keyword = ReadExcel.getCellData(iRow, 1);
            logger.info("CareersPage : The keyword is " +keyword);
            execute_Actions(careersPage);
        }
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Link Clicked");
        Thread.sleep(20000);
        logger.info("Ending  Test : clickSouthAficaLink Test");
        ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Ending  Test : clickSouthAficaLink Test");
        
    }


       @Test(dependsOnMethods = {"clickSouthAficaLink"})
       public void clickFirstJobLink() throws Exception {
          
           ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO,"ApplyOnlineTest: clickFirstJobLink Test " );
           ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Starting Test : clickSouthAficaLink Test");
           logger.info("Starting Test : clickCareersLink Test");
           Thread.sleep(20000);
           String screenshotPath = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
           ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath));
           Thread.sleep(20000);
           if (ThreadLocalDriverFactory.getThreadLocalDriver().getTitle().equals("SOUTH AFRICA - iLAB")) {
               Assert.assertTrue(true);
               ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.PASS, "Page Title is correct: SOUTH AFRICA - iLAB");
           } else {
               Assert.assertTrue(false);
               ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.FAIL, "Page Title is incorrect. ");
           }
           SouthAfricaPage southAfricaPage = PageFactory.initElements(ThreadLocalDriverFactory.getThreadLocalDriver(), SouthAfricaPage.class);
           String sPath = env_prop.getProperty("datafile_url");
           ReadExcel.setExcelFile(sPath, "southafrica_jobs_Page");
           for (int iRow = 1; iRow <2; iRow++) {
               keyword = ReadExcel.getCellData(iRow, 1);
               logger.info("SouthAfricaPage: The keyword is " +keyword);
               execute_Actions(southAfricaPage);
           }
           ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Link Clicked");
           Thread.sleep(20000);
           logger.info("Ending  Test : clickFirstJobLink Test");
           ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Ending  Test : clickFirstJobLink Test");
       }
    
          @Test(dependsOnMethods = {"clickFirstJobLink"})
          public void clickApplyOnlineLink() throws Exception {

              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO,"ApplyOnlineTest: clickApplyOnlineLink Test " );
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Starting Test :  clickApplyOnlineLink Test ");
              logger.info("Starting Test : clickApplyOnlineLink Test");
              String screenshotPath = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath));
              Thread.sleep(20000);
              JavascriptExecutor js = (JavascriptExecutor) ThreadLocalDriverFactory.getThreadLocalDriver();
              js.executeScript("window.scrollBy(0,1000)");
              Thread.sleep(20000);
              String screenshotPath1 = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath1));
              Thread.sleep(20000);
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Page Title is : " + ThreadLocalDriverFactory.getThreadLocalDriver().getTitle());
              ApplyOnlinePage applyOnlinePage = PageFactory.initElements(ThreadLocalDriverFactory.getThreadLocalDriver(), ApplyOnlinePage.class);
              String sPath = env_prop.getProperty("datafile_url");
              ReadExcel.setExcelFile(sPath, "apply_online_page");
              for (int iRow = 1; iRow <2; iRow++) {
                  keyword = ReadExcel.getCellData(iRow, 1);
                  logger.info("ApplyOnlinePage: The keyword is " +keyword);
                  execute_Actions(applyOnlinePage);
              }
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Link Clicked");
              Thread.sleep(20000);
              logger.info("Ending  Test : clickApplyOnlineLink Test");
          }

          @Test(dataProvider = "data", dependsOnMethods = {"clickApplyOnlineLink"})
          public void fillTheApplyOnlineForm(String name,String email) throws Exception {

              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO,"ApplyOnlineTest: fillTheApplyOnlineForm Test ");
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO,"ApplyOnlineTest: fillTheApplyOnlineForm Test ");
              logger.info("Starting Test : fillTheApplyOnlineForm Test");
              Thread.sleep(20000);
              String screenshotPath2 = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath2));
              Thread.sleep(20000);
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Page Title is : " + ThreadLocalDriverFactory.getThreadLocalDriver().getTitle());
              ApplyOnlinePage applyOnlinePage2 = PageFactory.initElements(ThreadLocalDriverFactory.getThreadLocalDriver(), ApplyOnlinePage.class);

                  applyOnlinePage2.inputName(name);
                  applyOnlinePage2.inputEmail(email);
                  applyOnlinePage2.inputPhoneNumber();
                  Thread.sleep(20000);
                  applyOnlinePage2.clickSendApplication();

              Thread.sleep(20000);
              String screenshotPath3 = BaseTest.getScreenshot(ThreadLocalDriverFactory.getThreadLocalDriver(), "screenshot_");
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, ThreadLocalExtentTestFactory.getThreadLocalExtentTest().addScreenCapture(screenshotPath3));
              Thread.sleep(20000);

              if (applyOnlinePage2.getErrorMessage().equals("You need to upload at least one file")) {
                  ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.PASS, "Error Message Exists");
                  Assert.assertTrue(true);

              } else {
                  ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.FAIL, "Different Error Message exists: " + applyOnlinePage2.getErrorMessage());
                  Assert.assertTrue(false);
              }
              ThreadLocalExtentTestFactory.getThreadLocalExtentTest().log(LogStatus.INFO, "Link Clicked");
              Thread.sleep(20000);
              logger.info("Ending  Test : fillTheApplyOnlineForm Test");
          }
    /*      */
    @DataProvider(name = "data")
    public Object[][] getUserDetails() throws FileNotFoundException, IOException {
        String[][] data = new String[1][2];

        if (env_prop.getProperty("data.access").equalsIgnoreCase("csv_file")) {
            String line = "";
            String cvsSplitBy = ",";
            int k = 0;
            BufferedReader br = new BufferedReader(new FileReader(env_prop.getProperty("user.details")));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] array1 = line.split(cvsSplitBy);
                logger.info(line);
                logger.info("Array1 length " + array1.length);
                for (int i = 0; i < +array1.length; i++) {
                    data[k][i] = array1[i];
                    logger.info(data[k][i]);
                }
                k++;
            }
            br.close();
        } else if (env_prop.getProperty("data.access").equalsIgnoreCase("database")) {
            HibernateDatabaseAccess dbAccess = new HibernateDatabaseAccess();
            Person person = dbAccess.getPersonDetails();
            data[0][0] = person.getName();
            data[0][1] = person.getEmail();
        }
        return data;
    }

}
