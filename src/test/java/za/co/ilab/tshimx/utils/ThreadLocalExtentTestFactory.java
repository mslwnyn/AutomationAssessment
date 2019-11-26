package za.co.ilab.tshimx.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ThreadLocalExtentTestFactory {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public synchronized static void setThreadLocalExtentTest (ExtentReports extentReport,String details) {
        extentTest = ThreadLocal.withInitial(() -> extentReport.startTest(details));
    }

    public synchronized static ExtentTest getThreadLocalExtentTest() {
        return extentTest.get();
    }



}

