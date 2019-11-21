package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */

import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String pattern = "yyyyMMddHHmm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());            
            extent = new ExtentReports(System.getProperty("user.dir") + "//reports//report_"+date+".html");
            extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
            extent.addSystemInfo("Selenium Version", "x.xxx.xx").addSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
