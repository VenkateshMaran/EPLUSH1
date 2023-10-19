
  package runner;

  import io.cucumber.testng.AbstractTestNGCucumberTests;
  import  io.cucumber.testng.CucumberOptions;
  import org.testng.annotations.DataProvider;

  // @CucumberOptions(plugin = "message:target/cucumber-report.ndjson")

  @CucumberOptions(
          //plugin= {"pretty","html:target/cucumber.html"},
//         tags = //"@ScenarioMemberType or @A&GInquiryScenario",
//                 "@MedicalBenefitIssue or @HealthBenefitIssue",
          plugin = {
                  "html:target/cucumber/cucumber.html",
                  "json:target/cucumber.json",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
          },
          dryRun = false,
          monochrome = true,
          glue = {"stepDefinitions", "hooks"},
         features = {"src/test/resources/features/A&GInquiryWithExcel.feature"}
          //features = {"src/test/resources/features/MemberVerification.feature", "src/test/resources/features/A&GInquiry.feature"}

  )


  public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

      @Override
      @DataProvider(parallel = false)
      public Object[][] scenarios() {
          return super.scenarios();
      }



 }
