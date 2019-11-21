package za.co.ilab.tshimx.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 *
 * @author Tshimologo
 */
public class HomePage implements PageObjects {
    
    WebDriver driver;

    @FindBy(how = How.XPATH,using = "//nav[@class='navigation-right text-right']/ul/li[4]/a[contains(text(),'CAREERS')]")
    WebElement link;

    public  HomePage (WebDriver driver){
        this.driver=driver;
    
    }
    
    public void clickCareersPage(){
        link.click();
    }
}
