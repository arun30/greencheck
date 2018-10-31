package greencheck;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import details.Commonmethod;

	public class survey1 extends Commonmethod{
		
		@BeforeSuite
		public void presetup(){
			extent = new ExtentReports (System.getProperty("user.dir") +"/Extent-Report/Report.html", true);
			extent
	        .addSystemInfo("Host Name", "SoftwareTestingMaterial")
	        .addSystemInfo("Environment", "Win10 Chrome")
	        .addSystemInfo("Client", "GREENCHECK");
			extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		}
		
		@BeforeTest
		public void launch() {
			logger = extent.startTest("launch");	
			launchBrowser("chrome", "https://apagreen.com/dana_staging/Login/index");
			//extent.endTest(logger);
		}
		
		/**
		 * login & dashboard page 
		 */

		@Test(priority=1)
		public void list1() {
			
			try {
				//logger = extent.startTest("login");	
				//launchBrowser("chrome", "https://apagreen.com/dana_staging/Login/index");
				enterTextBox("xpath", "//input[@class='ur_name form-control']", "driv4");
				enterTextBox("xpath", "//input[@class='ps_admin form-control']", "prop65");
				clickElement("xpath", "/html/body/div[1]/div/div/div/div/div[2]/form/div[3]/button");
				wait(10);
				verifyText("xpath","/html/body/div[3]/div/div/div/h2", "Supplier Dashboard");
				logger.log(LogStatus.PASS, "Supplier Dashboard " , logger.addScreenCapture(takeScreenshot("applnpassed.png")));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Supplier Dashboard failed" + e.getMessage() , logger.addScreenCapture(takeScreenshot("loginfailed.png")));
			e.printStackTrace();
		}
		
	}
		
		
		/**
		 * no-draft part# save
		 */
		
		@Test(priority=2)
		public void list2() {
			try {
				MouseOver("xpath", "/html/body/div[1]/div/div/div[2]/div/ul/li[1]/a");
				clickElement("xpath", "/html/body/div[1]/div/div/div[2]/div/ul/li[1]/ul/li/a");
				verifyText("xpath","/html/body/div[3]/div/div/div/h2", "Survey List");
				clickElement("xpath", "/html/body/div[4]/div/div/div[1]/div[6]/div[1]/table/tbody/tr[5]/td[1]/center/div/label");
				clickElement("xpath", "/html/body/div[4]/div/div/div[1]/div[6]/center/div/button[1]");
				verifyText("xpath", "//*[@id=\"susbtanceadded_070KC14590\"]", "No-Draft");
				logger.log(LogStatus.PASS, "No-Draft success" , logger.addScreenCapture(takeScreenshot("Draftpassed.png")));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "No-Draft failed" + e.getMessage() , logger.addScreenCapture(takeScreenshot("No-Draftfailed.png")));
			e.printStackTrace();
		}
					
		}
		
		/*@Test(priority=3)
		public void list3() {
			try {
				clickElement("xpath", "/html/body/div[4]/div/div/div[1]/div[6]/div[1]/table/tbody/tr[5]/td[1]/center/div/label");
				clickElement("xpath", "/html/body/div[4]/div/div/div[1]/div[6]/center/div/button[2]");
				goBackParentWindow(declarationcheck);
			}
		}*/
		
		/**
		 * yes draft part# save
		 */
		
		
		@Test(priority=3)
		public void list4() {
			try {
				clickElement("xpath", "/html/body/div[4]/div/div/div[1]/div[6]/div[1]/table/tbody/tr[8]/td[2]/a");
				verifyText("xpath", "/html/body/div[4]/div/div/h2", "Survey Detail");
				clickElement("xpath", "/html/body/div[5]/div[1]/div[1]/div[6]/div[1]/div[2]/div[2]/div/label");
				clickElement("xpath", "/html/body/div[5]/div[1]/div[1]/div[8]/div/div/div/div[1]/div/label");
				enterTextBox("xpath", "//*[@id=\"tags\"]", "1,1-Dichloroethane | 75-34-3 | Cancer | 100");
				clickElement("xpath", "/html/body/div[5]/div[1]/div[2]/div/div[2]/button");
				clickElement("xpath", "/html/body/div[5]/div[1]/div[5]/div[2]/div/div[2]/div/label");
				clickElement("xpath", "/html/body/div[5]/div[3]/button");
				verifyText("xpath", "/html/body/div[5]/div[6]/div/div[1]/table/tbody/tr/td[2]", "1,1-Dichloroethane | 75-34-3");
				clickElement("xpath", "/html/body/div[5]/div[6]/div/div[2]/button[1]");
				wait(10);
				verifyText("xpath", "//*[@id=\"susbtanceadded_070WJ10190\"]", "Yes-Draft");
				logger.log(LogStatus.PASS, "yes-Draft success" , logger.addScreenCapture(takeScreenshot("Draftpassed.png")));
			} catch (Exception e) {
				logger.log(LogStatus.FAIL, "yes-Draft failed" + e.getMessage() , logger.addScreenCapture(takeScreenshot("yes-Draftfailed.png")));
				e.printStackTrace();
			}
			finally {
				
				extent.endTest(logger);
			
			}
		}
		
		
		@AfterTest
		public void close() {
			closeBrowser();
		}
		
		@AfterSuite
		public void cleanup(){
			extent.flush();
			extent.close();
		}
		
		
		
		
		
		
		
			
		
		
		
	}



