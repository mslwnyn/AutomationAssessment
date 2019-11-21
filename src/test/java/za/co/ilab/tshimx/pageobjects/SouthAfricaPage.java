package za.co.ilab.tshimx.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author Tshimologo
 */
public class SouthAfricaPage implements PageObjects {
     WebDriver driver;

    @FindBy(how = How.XPATH,using = "//div[contains(h3,'CURRENT OPENINGS')]/div/div/div/div[@class='wpjb-job-list wpjb-grid']/div[1]/div[2]/span/a[1]")
    WebElement link;

    public  SouthAfricaPage (WebDriver driver){
        this.driver=driver;
    
    }
    
    public void clickOntheFirstJoB(){
        link.click();
    }
}
