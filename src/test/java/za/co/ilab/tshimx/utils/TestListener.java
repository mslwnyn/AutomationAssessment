package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import za.co.ilab.tshimx.testcases.ApplyOnlineTest;


public class TestListener implements ITestListener {

    final static Logger logger = Logger.getLogger(ApplyOnlineTest.class);


    @Override
    public synchronized void onStart(ITestContext context) {

        logger.info("***  TestListener : Test Suite " + context.getName());

    }


    @Override
    public synchronized void onTestStart(ITestResult result) {

        ThreadLocalExtentReportFactory.setThreadLocalExtentReport();
        ExtentTestManager.startTest( result.getMethod().getMethodName() );
        logger.info("*** TestListener : Starting test method: " + result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(LogStatus.INFO, "TestListener - Running test method: " + result.getMethod().getMethodName());

    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {

        logger.info("*** TestListener  : Executed " + result.getMethod().getMethodName() + ": Test Completed Successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "TestListener :     " + result.getMethod().getMethodName() + ": Test Completed Successfully.");
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {

        logger.info("*** TestListener : Test execution " + result.getMethod().getMethodName() + " failed...");
        ExtentTestManager.getTest().log(LogStatus.FAIL, " Test has failed ");
        ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();
        

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {

        logger.info("*** TestListener : Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(LogStatus.INFO, Thread.currentThread().getName()+": "  + result.getMethod().getMethodName() + " : is Skipped.");
        ExtentTestManager.getTest().log(LogStatus.SKIP, result.getThrowable());
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();

    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       
        ExtentTestManager.getTest().log(LogStatus.PASS, result.getMethod().getMethodName() + ": Test within  success percentage.");
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();
     
    }
    
    
    @Override
    public  synchronized  void onFinish(ITestContext context) {

        logger.info("*** TestListener : Test Suite " + context.getName().toString() + " ended ***");
        //ExtentTestManager.getTest().log(LogStatus.INFO,  context.getName() + " : OnFinish executed on Machine: " + context.getHost());
        ExtentManager.getInstance().flush();
        
    }

}
