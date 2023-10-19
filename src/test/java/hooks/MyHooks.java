package hooks;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import context.TestContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExcelReader;

public class MyHooks {
	private WebDriver driver;
	private TestContext context;

	public MyHooks(TestContext context)
	{
		this.context = context;
	}
	
	
	//it will execute before every scenario, if feature file having 2 example for scenario outline then it will execute twice
	@Before()
	public void before(Scenario scenario) throws MalformedURLException
	{
		System.out.println("BEFORE THREAD ID : "+ Thread.currentThread().getId() + ", "
				+ "SCENARIO NAME: " + scenario.getName());
		driver = DriverFactory.initializeDriver("chrome");
		//driver = DriverFactory.initializeLambdaDriver("edge");
		//for non static methods 
		//driver = new DriverFactory().initializeDriver();
		context.driver = driver;

		System.out.println("Before hooks executed");
	}

	@Before("@ScenarioMemberType1")
	public void before1(Scenario scenario) throws MalformedURLException
	{
		System.out.println("BEFORE THREAD ID : "+ Thread.currentThread().getId() + ", "
				+ "SCENARIO NAME: " + scenario.getName());
		driver = DriverFactory.initializeDriver("chrome");
		context.driver = driver;

		System.out.println("Before hooks executed");
	}

	
	/*
	 * We can use more than one before and after for multiple tag based on the scenario
	 * @Before("@Scenario1") 
	 * public void beforeScenario1() 
	 * { 
	 * driver = DriverFactory.initializeDriver(); 
	 * //for non static methods 
	 * //driver = new DriverFactory().initializeDriver();
	 * System.out.println("Before hooks executed"); 
	 * }
	 */
	
	//User can use @BeforeStep and @AfterStep for every steps 
	
	  @AfterStep 
	  public void addScreenshot(Scenario scenario) {
		  //if(scenario.isFailed()) { 
			  final byte[] screenshot = ((TakesScreenshot)
		  driver).getScreenshotAs(OutputType.BYTES); 
			  scenario.attach(screenshot, "image/png", scenario.getName()); //}
		  System.out.println(scenario.getName() +"Scenario Status: "+ scenario.getStatus());
		  }
	
	@After
	public void after(Scenario scenario)
	{
		System.out.println("AFTER THREAD ID : "+ Thread.currentThread().getId() + ", "
				+ "SCENARIO NAME: " + scenario.getName());
		//driver.quit();
		System.out.println("After hooks executed");
	}
	

}
