package za.co.ilab.tshimx.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author Tshimologo
 */
public class CareersPage implements PageObjects {
    WebDriver driver;

    @FindBy(how = How.XPATH,using = "//a[text()='South Africa']")
    WebElement link;

    public  CareersPage (WebDriver driver){
        this.driver=driver;
    
    }
    
    public void search_southafrica_jobs(){
        link.click();
    }
    
   
}
