package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.MemberSearchPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.When;
import pages.PageFactoryManager;
import utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MemberPageStepDefinition {

	//private WebDriver driver = DriverFactory.getDriver();

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final MemberSearchPage memberSearch;
    private static String memberID;
    private static String memberType;
    //private WebDriver driver = DriverFactory.getDriver();

    public MemberPageStepDefinition(TestContext context)
    {
       driver = context.driver;
        memberSearch = PageFactoryManager.getMemberSearchPage(context.driver);
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @When("clicks on the navigate icons")
    public void clicks_on_the_navigate_icons() {

        memberSearch.searchIcon();
    }


    @When("clicks on member search menu")
    public void clicks_on_member_search_menu() {
        memberSearch.memberSearchMenuOption();
    }

    @Given("user enter the {string}")
    public void user_enter_the(String memID) {
        memberSearch.memberID(memID);
    }

    @Given("user enter the memberId")
    public void user_enter_the_member_id(List<Map<String, String>> memberId)  {
        memberSearch.memberID(memberId.get(0).get("memberID"));
    }


    @Given("click on Search button")
    public void click_on_search_button() {
        memberSearch.searchBttn();
    }
    @Given("Collect the details from Member Inquiry sheet {string} and  rowNum {int}")
    public void collect_the_details_from_sheet_and_row_num(String sheetName, Integer rowNum) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testData\\testData.xlsx";
        List<Map<String,String>> testData = reader.getData(filePath, sheetName);
        memberID = testData.get(rowNum).get("Member ID");
        memberType = testData.get(rowNum).get("Member Type");
    }


}
