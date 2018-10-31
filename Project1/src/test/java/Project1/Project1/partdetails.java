package Project1.Project1;

import java.io.File;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import details.Commonmethod;

public class partdetails extends Commonmethod {

@BeforeSuite
	public void presetup(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/Extent-Report/Report.html", true);
		extent
        .addSystemInfo("Host Name", "SoftwareTestingMaterial")
        .addSystemInfo("Environment", "Win10 Chrome")
        .addSystemInfo("Client", "Enginetech");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}

	
/*	@BeforeMethod
    public void browser() {
		launchBrowser("chrome", "https://apaengineering.net/ETcatalog");
		//waitForWebElement("link", "Engine Parts Search", 30);
		
	}
		*/


	@Test
	public void case1() {
 try {
			logger = extent.startTest("appln");	
	 launchBrowser("chrome", "http://autopartsasia.org/ETcatalog/");		
		//waitForWebElement("link", "Engine parts", 10);
		//verifyTitle("Enginetech Catalog");
			clickElement("xpath", "/html/body/header/div[2]/div/div/div[3]/ul/li[1]/a");
			waitForWebElement("link", "VEHICLE APPLICATION", 10);
			clickElement("id", "AC1497C");
			clickElement("xpath", "/html/body/div[1]/div[2]/div/div/div[3]/div[2]/div[2]/div[3]/div[2]/div[2]/table/tbody/tr[1]/td[3]/a");
			verifyTitle("Category");
			//logger.log(LogStatus.PASS, "Category " , logger.addScreenCapture(takeScreenshot("applnpassed.png")));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "application search failed " + e.getMessage() , logger.addScreenCapture(takeScreenshot("applnfailed.png")));
			e.printStackTrace();
		}
		finally {
			
			extent.endTest(logger);
		
		}
	}
	
	@AfterMethod
	public void close() {
		closeBrowser();
	}
	
	@AfterSuite
	public void cleanup(){
		extent.flush();
		extent.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
