package pages;


import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationInquiryPage extends BasePage {



    public AuthorizationInquiryPage(WebDriver driver) {

            super(driver);
    }
    @FindBy(xpath="//button[contains(text(),'Authorization Inquiry')]")
    private WebElement authInqBtn;

    @FindBy (xpath="//input[@name='UST_EPLUS__Authorization_ID__c']")
    private WebElement authID;
    @FindBy(xpath = "//button[@name='Authorization Type']")
    private WebElement authType;

    @FindBy(xpath = "//button[@name='UST_EPLUS__Secondary_Reason__c']")
    private WebElement secondaryReason;

    @FindBy(xpath = "//button[@name='UST_EPLUS__Tertiary_Reason__c']")
    private WebElement tertiaryReason;

    @FindBy(xpath = "//button[@name='UST_EPLUS__Mark_as_Complaint__c']")
    private WebElement markAsComplaint;

    @FindBy(xpath="//button[@name='Priority']")
    private WebElement priority;

    @FindBy(xpath="//input[@name='Subject']")
    private WebElement subject;
   @FindBy(xpath="//textarea[@name='Description']")
    private WebElement Description;

    @FindBy(xpath="//button[contains(text(),'Save')]")
    private WebElement save;

    @FindBy(xpath="//span[contains(text(), 'Did you educate the member on their secondary plan process for authorization, non covered services and the appeals and grievances process?')]")
    private WebElement declaration;




    public void authInqClick(){
        wait.until(ExpectedConditions.visibilityOf(authInqBtn)).click();
       }
@SneakyThrows
public void enterAuthID(String authIDVal){
    wait.until(ExpectedConditions.visibilityOf(authID)).click();
    authID.sendKeys(authIDVal);

}

    @SneakyThrows
    public void selectAuthType(String authTypeVal){
        wait.until(ExpectedConditions.visibilityOf(authType)).click();
        driver.findElement(By.xpath("//*[@data-value='"+authTypeVal+"']")).click();

    }
    @SneakyThrows
    public void selectSecondaryReason(String secondaryReasonVal) {
        wait.until(ExpectedConditions.visibilityOf(secondaryReason)).click();
        driver.findElement(By.xpath("//*[@data-value='"+secondaryReasonVal+"']")).click();
    }

    @SneakyThrows
    public void selectTertiaryReason(String tertiaryReasonVal) {((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tertiaryReason);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tertiaryReason);

        wait.until(ExpectedConditions.visibilityOf(tertiaryReason)).click();
Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@data-value='"+tertiaryReasonVal+"']")).click();
    }

    @SneakyThrows
    public void setMarkAsComplaint(String markAsComplaintVal) {
        wait.until(ExpectedConditions.visibilityOf(markAsComplaint)).click();
        driver.findElement(By.xpath("//*[@data-value='"+markAsComplaintVal+"']")).click();
    }
    @SneakyThrows
public void setPriority(String priorityVal){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priority);
    wait.until(ExpectedConditions.visibilityOf(priority)).click();
    driver.findElement(By.xpath("//*[@data-value='"+priorityVal+"' and @role='option']")).click();
    //wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(subjectVal);
    }
   /* @SneakyThrows
    public void enterSubject(String subjectVal){
        wait.until(ExpectedConditions.visibilityOf(subject)).click();
      wait.until(ExpectedConditions.visibilityOf(subject)).clear();
      wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(subjectVal);

    }*/
    @SneakyThrows
    public void enterDescription(String desc){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Description);
        wait.until(ExpectedConditions.visibilityOf(Description)).click();
        wait.until(ExpectedConditions.visibilityOf(Description)).sendKeys(desc);

    }
    @SneakyThrows
    public void setDeclaration(){

        wait.until(ExpectedConditions.visibilityOf(declaration)).click();


    }
public void saveInq(){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
    wait.until(ExpectedConditions.elementToBeClickable(save)).click();
}


}
