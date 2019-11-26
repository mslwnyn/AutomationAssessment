package za.co.ilab.tshimx.utils;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ThreadLocalExtentReportFactory {

    private static ThreadLocal<ExtentReports > extentReport = new ThreadLocal<>();

    public synchronized static void setThreadLocalExtentReport () {
            extentReport = ThreadLocal.withInitial(() -> ExtentManager.getInstance());
    }

    public synchronized static ExtentReports getThreadLocalExtentReport () {
        return extentReport.get();
    }

    

}


