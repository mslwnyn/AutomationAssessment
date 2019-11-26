package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import za.co.ilab.tshimx.testcases.ApplyOnlineTest;


public class TestListener implements ITestListener {

 private static ExtentReports extent ;
 private static ExtentTest extentTest;
  final static Logger logger = Logger.getLogger(ApplyOnlineTest.class);

   
    @Override
    public void onStart(ITestContext context) {
        
        logger.info( "***  TestListener : Test Suite " + context.getName() );
        
    }
    
    
   @Override
    public void onTestStart(ITestResult result) {
      
        ThreadLocalExtentReportFactory.setThreadLocalExtentReport();
        extent = ThreadLocalExtentReportFactory.getThreadLocalExtentReport();
        ThreadLocalExtentTestFactory.setThreadLocalExtentTest(extent,result.getMethod().getMethodName() );
        extentTest = ThreadLocalExtentTestFactory.getThreadLocalExtentTest();  
        logger.info("*** TestListener : Starting test method: " + result.getMethod().getMethodName());
        extentTest.log(LogStatus.INFO, "TestListener - Running test method: " + result.getMethod().getMethodName());
       
    }

    @Override
    public void onTestSuccess(ITestResult result) {

       logger.info("*** TestListener  : Executed " + result.getMethod().getMethodName() + ": Test Completed Successfully.");
       extentTest.log(LogStatus.PASS, "TestListener :     "+ result.getMethod().getMethodName()  + ": Test Completed Successfully.") ;
       extent.endTest(extentTest);
       extent.flush();
    }   
    
    @Override
    public void onTestFailure(ITestResult result) {
        
        logger.info("*** TestListener : Test execution " + result.getMethod().getMethodName() + " failed...");
        extentTest.log(LogStatus.FAIL, "Test has failed "); 
        extentTest.log(LogStatus.FAIL, result.getThrowable()); 
        extent.endTest(extentTest);
        extent.flush();

    }
   @Override
    public void onTestSkipped(ITestResult result) {
        
        logger.info("*** TestListener : Test " + result.getMethod().getMethodName() + " skipped...");
        extentTest.log(LogStatus.INFO, result.getMethod().getMethodName() + " : is Skipped."); 
        extentTest.log(LogStatus.SKIP, result.getThrowable());                                        
        extent.endTest(extentTest);
        extent.flush();
       
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       extentTest.log(LogStatus.PASS, result.getMethod().getMethodName()  + ": Test within  success percentage.") ;                                     
       extent.endTest(extentTest);
       extent.flush();
        
    }
    
    
    @Override
    public void onFinish(ITestContext context) {

        logger.info("*** TestListener : Test Suite " + context.getName().toString() + " ended ***");
        ThreadLocalExtentReportFactory.getThreadLocalExtentReport().flush();
        
    }



}
