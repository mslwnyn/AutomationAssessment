package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ThreadLocalDriverFactory {
    
     private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public synchronized static void setThreadLocalDriver (String browser) {
        if (browser.equals("firefox")) {
            tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(BrowserOptionsManager.getFirefoxOptions()));
        } else if (browser.equals("chrome")) {
            tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(BrowserOptionsManager.getChromeOptions()));
        }  else if (browser.equals("ie")) {
            tlDriver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(BrowserOptionsManager.getInternetExplorerOptions()));
        }
    }

    public synchronized static WebDriver getThreadLocalDriver () {
        return tlDriver.get();
    }
    
}
