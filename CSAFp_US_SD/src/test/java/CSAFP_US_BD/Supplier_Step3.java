package CSAFP_US_BD;

import Wrappers.GenericWrappers_US_BD;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Supplier_Step3 extends GenericWrappers_US_BD
{
	private static final WebElement ResponseFile = null;
	static WebDriver dr;
	
	public String supplier_request() throws InterruptedException 
	{
		clickByXpath("//button[@name='search']");//search
		//(xpath= "//button[@class='bx--list-box__field']")
		//clickByXpath("//button[@class='bx--btn bx--btn--secondary]"); //close
		clickByXpath("//*[@touranchor='search-form']/div/div[1]/div/button[1]");
		clickByXpath("//button[@class='bx--list-box__field']");//select drop down
		Thread.sleep(3000);
		clickByXpath("//div[@class='bx--list-box__menu-item__option' and contains(text(),'Fixed Price')]"); //select FP from drop down
		Thread.sleep(3000);
		
		
		enterByXpath("//input[@placeholder='Request Number']", RIPC_step1.FixedPrice_ID); //search
		Thread.sleep(3000);
		
		clickByXpath("//button[@class='bx--btn bx--btn--primary']");
		
		
		//clickByXpath("//*[@class='bx--btn bx--btn--primary']");//request open
		
		clickByXpath("//mat-table/mat-row/mat-cell[1]");
		Thread.sleep(5000);
		
		clickByXpath("//button[@class='bx--btn bx--btn--primary ng-star-inserted']");//Accept Terms & Conditions
		Thread.sleep(5000);
		
		//bx--btn bx--btn--primary ng-star-inserted
		
		clickByXpath("//span[@class='bx--radio-button__appearance']");//priorIBMer
		Thread.sleep(5000);
		clickByXpath("//span[@class='headerTitle' and contains(text(),'Response Attachments')]");//Response attachment
		//Thread.sleep(5000);
		
		String AttachmentPath = System.getProperty("user.dir") + "\\Request.txt";
		WebDriverWait wait2 = new WebDriverWait(dr, 180);
		
		wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//div[@class='bx--row response-attachments']/div[1]/ibm-file-uploader/div[1]/button//parent::div/input"))));
		
		dr.findElement(By.xpath("//div[@class='bx--row response-attachments']/div[1]/ibm-file-uploader/div[1]/button//parent::div/input")).sendKeys(AttachmentPath);
		
		//button[contains(@for,'file-uploader-0') and contains(text(),' Attach ')]//parent::div/input
		
		//wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//div[@class='bx--row response-attachments']/div[1]/ibm-file-uploader/div[1]/button//parent::div/input").sendKeys(System.getProperty("user.dir") + "\\Request.txt"))));
		//String AttachmentPath = System.getProperty("user.dir") + "\\Request.txt";
		//ResponseFile.sendKeys("\\Request.txt");
		//enterById("importFile",System.getProperty("user.dir") + "\\Links.txt");
		
		//(By.xpath("//div[@class='bx--row response-attachments']/div[1]/ibm-file-uploader/div[1]/button//parent::div/input")))).sendKeys(System.getProperty("user.dir") + "\\Request.txt");
		Thread.sleep(5000);
		
		
		
		//dr.findElement(By.xpath("//div[@class='bx--row response-attachments']/div[1]/ibm-file-uploader/div[1]/button//parent::div/input")).sendKeys("\\Request.txt");
		
		/*dr.findElement(By.xpath("//div[@class='bx--row response-attachments']/div[1]/ibm-file-uploader/div[1]/button//parent::div/input")).sendKeys(System.getProperty("user.dir") + "\\Links.txt");
		Thread.sleep(5000);*/
		
		//File file = new File("/home/user/path/to/file");
		//WebElement.sendKeys(file.getAbsolutePath());
		
		//enterById("importFile",System.getProperty("user.dir") + "\\Links.txt");
        
        clickByXpath("//span[@class='headerTitle' and contains(text(),'Milestones')]"); // click on Milestone header
        
        Thread.sleep(500);
        
        clickByXpath("//mat-expansion-panel[4]/div/div/div/div[2]/div[1]/table/tbody/mat-row/mat-cell[1]/a"); //select Milestone 
        Thread.sleep(5000);
        
     //   clickByXpath("//div[@class='bx--dropdown-input__field-wrapper ng-star-inserted']");//add UOM
     //   Thread.sleep(5000);
        
    //    clickByXpath("//div[@class='bx--list-box__menu-item__option' and contains(text(),'Month')]");//select UOM
      //  Thread.sleep(3000);
        
        clickByXpath("//mat-accordion/mat-expansion-panel/div/div/div[3]/div[1]/div/div/table/tbody/mat-row/mat-cell[1]/a");//select job role
        Thread.sleep(8000);
        
        enterByXpath("//input[@formcontrolname='proposedRate']", "500"); // add proposed Rate
       // Thread.sleep(5000);
        
        clickByXpath("//mat-accordion/mat-expansion-panel[2]/div/div/clapp-resource-plan-form/div/div/form/div[8]/div/button[2]");//save proposed Rate
        Thread.sleep(8000);
        
        clickByXpath("//mat-sidenav-container/mat-sidenav/div/div/clapp-milestone-detail/div[1]/button[2]"); // save Milestone 
        Thread.sleep(8000);
        
        clickByXpath("//span[@class='headerTitle' and contains(text(),'Questions & Sub-contracting (sub-tier)')]");//header
        Thread.sleep(5000);
        
        enterByXpath("//input[@formcontrolname='answer']", "fixed price"); //answer 2 ques
        Thread.sleep(5000);
        
        clickByXpath("//button[@class='bx--btn bx--btn--primary bx--btn--sm' and contains(text(),'Submit')]");//submit response
        Thread.sleep(3000);
        
        clickByXpath("//button[@class='bx--btn bx--btn--primary']");//confirm submit
        Thread.sleep(5000); 
        
       // String FPID = getTextByXpath("//span[@class='section-title ng-star-inserted']");
       // System.out.println("Page FPID for supplier login===>"+FPID);
		return RIPC_step1.FixedPrice_ID;
		
		/*String PageTitle = getPageTitle();
		System.out.println("Page title for supplier login===>"+PageTitle);
	   	 return PageTitle;*/
		
	}


	public String supplier_requestDetails() throws InterruptedException 
	{
		//clickByXpath("//button[contains(text(),'Accept Terms & Conditions')]");
		
		clickByXpath("//button[@class='bx--btn bx--btn--primary ng-star-inserted']");//Accept Terms & Conditions
		Thread.sleep(5000);
		
		//bx--btn bx--btn--primary ng-star-inserted
		
		clickByXpath("//span[@class='bx--radio-button__appearance']");//priorIBMer
		Thread.sleep(3000);
		clickByXpath("//span[@class='headerTitle' and contains(text(),'Response Attachments')]"); //Response attachment
		Thread.sleep(3000);
		clickByXpath("//button[@class='bx--btn bx--btn--primary bx--btn--sm' and contains(text(),'Attach')]"); // Attach Attachments
	    Thread.sleep(5000);
	 
	    // switch to second window
	    switchToLastWindow();
        Thread.sleep(2000);
        // import file
	    enterById("file-uploader-0", System.getProperty("user.dir") + "\\Request.txt");
        Thread.sleep(3000);
        // click on upload button
        clickById("submitButton");
        Thread.sleep(3000);
        closeBrowser();
        //switch to parent window
         switchToParentWindow();
         
         Thread.sleep(2000);
        clickByXpath("//span[@class='headerTitle' and contains(text(),'Milestones')]"); 
         Thread.sleep(5000);
		String pageTitle = getPageTitle();
		   return pageTitle;
		
	}
	public String supplier_milestone() throws InterruptedException 
	{
		clickByXpath("//*[@id='content_form']/div/div/table[2]/tbody/tr[2]/td[1]/a");
		Thread.sleep(3000);
		enterById("proposedRate", "50000");
		clickByXpath("//*[@id='content_form']/div[1]/div/table[4]/tbody/tr/td[1]/input");
		Thread.sleep(2000);
		clickByXpath("//*[@id='content_form']/div/div/table[3]/tbody/tr[9]/td[2]/input");
		
		Thread.sleep(3000);
		String pageTitle = getPageTitle();
		   return pageTitle;
		
	}
	public String supplier_milestoneSummary() throws InterruptedException
	{
		clickByXpath("//*[@id='commandbutton-nav-submit-response']");
		Thread.sleep(3000);
		String pageTitle = getPageTitle();
		   return pageTitle;
	}
	public String supplier_submitResponse() throws InterruptedException 
	{
		enterByXpath("//*[@id='Questions']/table/tbody/tr/td[2]/input","contact person");
		enterById("supplierComment","Any concern or issue you might want us to know. Put your comment here");
		Thread.sleep(1000);
		clickByXpath("//*[@id='content_form']/div/div/div/table/tbody/tr[4]/td/input[1]");
		Thread.sleep(3000);
		String pageTitle = getPageTitle();
		
		   return pageTitle;
		
	}
	
}
