package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ThreadLocalDriverFactory {
    
     private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public synchronized static void setThreadLocalDriver (String browser) {
        if (browser.equals("firefox")) {
            tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(BrowserOptionsManager.getFirefoxOptions()));
            tlDriver.get().manage().window().maximize();
        } else if (browser.equals("chrome")) {
            tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(BrowserOptionsManager.getChromeOptions()));
            tlDriver.get().manage().window().maximize();
        }  else if (browser.equals("ie")) {
            tlDriver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(BrowserOptionsManager.getInternetExplorerOptions()));
            tlDriver.get().manage().window().maximize();
        }else if (browser.equals("edge")) {
            tlDriver = ThreadLocal.withInitial(() -> new EdgeDriver());
            tlDriver.get().manage().window().maximize();
        }
    }

    public synchronized static WebDriver getThreadLocalDriver () {
        return tlDriver.get();
    }
    
}
