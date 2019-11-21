package za.co.ilab.tshimx.pageobjects;

/**
 *
 * @author Tshimologo
  * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import za.co.ilab.tshimx.utils.PhoneNumberGenerator;

public class ApplyOnlinePage implements PageObjects {
    
    WebDriver driver;
    @FindBy(how = How.XPATH,using = "//a[@class='wpjb-button wpjb-form-toggle wpjb-form-job-apply']")
    WebElement link;
    @FindBy(how = How.XPATH,using = "//input[@id='applicant_name']")
    WebElement applicant_name;
    
    @FindBy(how = How.XPATH,using = "//input[@id='email']")
    WebElement email;
    
    @FindBy(how = How.XPATH,using = "//input[@id='phone']")
    WebElement phone;
    
    @FindBy(how = How.XPATH, using = "//input[@id='wpjb_submit']")
    WebElement sendButton;
    
    @FindBy(how = How.XPATH, using = "//span[@class='wpjb-glyphs wpjb-icon-attention']")
    WebElement errorMessage;
    
    public  ApplyOnlinePage (WebDriver driver){
        this.driver=driver;
    
    }
    
    public void inputName(String name){
        applicant_name.sendKeys(name);
    }
    
    public void inputEmail(String emailAddress){
        email.sendKeys(emailAddress);
    }
    
    public void inputPhoneNumber(){
        phone.sendKeys(PhoneNumberGenerator.getPhoneNumber());
    }
    
    public void clickSendApplication(){
        sendButton.click();
    }
    
    public void applyOnline(){
        link.click();
    }
    
    
     public String getErrorMessage(){
        return errorMessage.getText();
    }
    
    
    
    
    
    
}
