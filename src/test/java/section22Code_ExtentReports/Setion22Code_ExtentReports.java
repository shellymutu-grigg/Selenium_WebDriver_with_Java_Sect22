package section22Code_ExtentReports;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Setion22Code_ExtentReports {

	ExtentReports extentReports;

	@BeforeTest
	public void config() {

		// ExtentSparkReporter
		String pathnameString = System.getProperty("user.dir") + "//reports//index.html";
		System.out.println(
				MessageFormat.format("Report director: {0}", System.getProperty("user.dir") + "/reports/index.html"));
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathnameString);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		// ExtentReports
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "Shelly Mutu-Grigg");
	}

	@Test
	public void initalDemo() {
		ExtentTest test = extentReports.createTest("Inital Demo");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("https://rahulshettyacademy.com/client/");
		System.out.println(MessageFormat.format("Webpage Title: {0}", webDriver.getTitle()));
		// Make a test take a screenshot
		// test.addScreenCaptureFromBase64String("");
		webDriver.close();
		test.fail("Results do not match");

		// End the extent report lifecycle
		extentReports.flush();
	}
}
