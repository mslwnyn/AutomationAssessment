package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;


public class BrowserOptionsManager {
     
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--whitelisted-ips");
        //options.addArguments("--headless");
        return options;
    }

    
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        //profile.setAcceptUntrustedCertificates(true);
        //profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        //profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.addArguments("--headless");
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    public static InternetExplorerOptions  getInternetExplorerOptions () {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        ieOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        ieOptions.setCapability("requireWindowFocus", true);
        return ieOptions;

    }
}
