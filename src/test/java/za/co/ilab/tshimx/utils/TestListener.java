package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import za.co.ilab.tshimx.testcases.ApplyOnlineTest;

public class TestListener implements ITestListener {
    
    final static Logger logger = Logger.getLogger(ApplyOnlineTest.class);
   

    public void onStart(ITestContext context) {
        
         logger.info("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {

        logger.info("*** Test Suite " + context.getName() + " ending ***");
       
    }

    public void onTestStart(ITestResult result) {
       
     logger.info("*** Running test method " + result.getMethod().getMethodName() + "...");
    }

    public void onTestSuccess(ITestResult result) {
       logger.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        
    }

    public void onTestFailure(ITestResult result) {
         logger.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
       
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
       
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
        
    }



}
