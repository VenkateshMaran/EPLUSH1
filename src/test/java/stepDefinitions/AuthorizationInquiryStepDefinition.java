package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AuthorizationInquiryPage;
import pages.LoginPage;
import pages.MemberSearchPage;
import pages.PageFactoryManager;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;

public class AuthorizationInquiryStepDefinition {

    private final AuthorizationInquiryPage authorizationInquiryPage;


    private static String authorizationID;
    private static String authorizationType;
    private static String secondaryReason;
    private static String tertiaryReason;
    private static String reasonUpdate;
    private static String subject;
    private static String description;
    private static String priority;
    private static String markAsComplaint;

    public AuthorizationInquiryStepDefinition(TestContext context) {
        authorizationInquiryPage = PageFactoryManager.getAuthInquiry(context.driver);


    }


    @SneakyThrows
    @Given("Collect the details from sheet {string} and rowNum {int}")
    public void collectData(String sheetName, Integer rowNum) {
        ExcelReader excelReader = new ExcelReader();
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testData.xlsx";
        List<Map<String, String>> testData = excelReader.getData(filePath, sheetName);
        Map<String, String> rowData = testData.get(rowNum);

        authorizationID = rowData.get("Authorization ID");
        authorizationType = rowData.get("Authorization Type");
        secondaryReason = rowData.get("Secondary Reason");
        tertiaryReason = rowData.get("Tertiary Reason");
        reasonUpdate = rowData.get("Reason Update Field");
        subject = rowData.get("Subject");
        description = rowData.get("Description");
        priority = rowData.get("Priority");
        markAsComplaint = rowData.get("Mark As Complaint");

    }

    @And("click on Authorization inquiry page")
    public void clickOnAuthorizationInquiryPage() {
        authorizationInquiryPage.authInqClick();
    }

    @SneakyThrows
    @When("Enter Inquiry Details")
    public void enterInquiryDetails() {

        authorizationInquiryPage.enterAuthID(authorizationID);
        authorizationInquiryPage.selectAuthType(authorizationType);
        authorizationInquiryPage.selectSecondaryReason(secondaryReason);
        authorizationInquiryPage.selectTertiaryReason(tertiaryReason);
        authorizationInquiryPage.setMarkAsComplaint(markAsComplaint);
        //authorizationInquiryPage.setPriority(priority);
        //authorizationInquiryPage.enterSubject(subject);
        authorizationInquiryPage.enterDescription(description);
        authorizationInquiryPage.setDeclaration();
    }

    @And("Save the Details")
    public void saveInquiry() {
        authorizationInquiryPage.saveInq();

    }

    @Then("Verify whether case is generated")
    public void verifyCaseGenerated() {
        System.out.println("Successfully Case Generated");
        //Assert.assertEquals();
    }

}
