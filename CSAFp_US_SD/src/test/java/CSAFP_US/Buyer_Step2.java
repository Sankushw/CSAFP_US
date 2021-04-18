package CSAFP_US;


import org.openqa.selenium.WebDriver;
import Wrappers.GenericWrappers_US;


public class Buyer_Step2  extends GenericWrappers_US
{
	static WebDriver dr;
	public String buyer_awaitingAction() throws InterruptedException 
	{
		Thread.sleep(5000);
		clickByXpath("//*[@id='left-nav']/div/a[4]");   // awaiting buyer action
		clickByXpath("//*[@id='content-main']/p[4]/a"); // fixed price		
		System.out.println("In buyer" + RIPC_step1.FixedPrice_ID);
		enterById("FLD_REQUEST_NUMBER", RIPC_step1.FixedPrice_ID); // fp id
		clickByName("btnGo");  //click go
		clickByXpath("//*[@id='content-main']/form/table[5]/tbody/tr[2]/td[1]/a");  
		//click on fp id
		Thread.sleep(3000);
		String FPID = getTextByXpath("//*[@id='content-main']/h1");
		return FPID;
	}

	public String buyer_verifyProjectAttributes() throws InterruptedException 
	{
		clickByXpath("//*[@id='content-main']/div[3]/table/tbody/tr/td[3]/a");
        Thread.sleep(3000);
		   String pageTitle = getPageTitle();
		   return pageTitle;
	}


	public String buyer_milestone() throws InterruptedException
	{
		clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
	   	 Thread.sleep(3000);
	   	 String PageTitle = getPageTitle();
	   	 return PageTitle;
	}

	public String buyer_verifyPeopleInvolved() throws InterruptedException {
		 // click on next
   	 clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
   	 Thread.sleep(5000);
   	 String PageTitle = getPageTitle();
   	 return PageTitle;
	}

	public String buyer_verifySuppliers() throws InterruptedException {
		// click on next
		clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
		Thread.sleep(5000);
		String PageTitle = getPageTitle();
		return PageTitle;
	}
	
	//public String buyer_supplierContract() throws InterruptedException {
		// click on next
		//clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
		//Thread.sleep(5000);
		//clickByXpath("//*[@id='content-form']/div[1]/div/table[1]/tbody/tr[1]/td/table/tbody/tr[3]/td[8]/a");
		// clickById(suppliers_onpage_clicked_action('commandbutton-suppliers-contract-selection','922334');return
		// false;);
		//dr = new FirefoxDriver();
		//dr.findElement(By.cssSelector("a[title=\"View\"]")).click();	
		//dr.findElement(By.xpath("//button[@onclick= suppliers_onpage_clicked_action('commandbutton-suppliers-contract-selection','922337');return false;\"]")).click();
		//clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[11]/td/table/tbody/tr[2]/td[6]/a");
		//Thread.sleep(2000);
		//clickByName("preConfiguredContract");
		//clickByName("commandbutton-save_done");
		//Thread.sleep(5000);
		//String PageTitle = getPageTitle();
		//return PageTitle;
	//}

	public String buyer_verifySupplierQues() throws InterruptedException {
		 // enter if any ques req
   	 
   	 //click on next
   	 clickByXpath("//*[@id='content-main']/div[3]/table/tbody/tr/td[4]/a");
   	 Thread.sleep(5000);
   	String PageTitle = getPageTitle();
   	 return PageTitle;
	}

	public String buyer_enterEvaluationCriteria() throws InterruptedException {
				
				// click on next
				clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
				 Thread.sleep(4000);
				String PageTitle = getPageTitle();
		    	 return PageTitle;
	}
	
	public String buyer_termsandconditions() throws InterruptedException {
		
		// click on next
		Thread.sleep(2000);
		//clickById("commandbutton-nav-send-to-suppliers");
		// Thread.sleep(5000);
		String PageTitle = getPageTitle();
    	return PageTitle;
}
	public String buyer_SkipSupplier() throws InterruptedException {
  	 /* // click on skip supplier quotation and proceed to requisition button
  	  clickById("commandbutton-nav-skip-supplier-quotation");*/
  	  acceptAlert();
  	  
  	unhandledAlert("commandbutton-nav-skip-supplier-quotation");
  	
 // select reason code
  	 selectVisibileTextById("reasonCode", "Only known solution provider for requirement");
  	 enterByName("comments", "test only");
	     clickByName("commandbutton-confirmSkip");
	     
	     selectIndexById("sourceSelectionCode", 4);
  		selectIndexById("ssvTechnique", 5);
  		enterById("sourceSelectionDesc", "selection_desc");
  		enterById("fvDescription", "fvdesc");
  		clickById("allowPrHandsFree2");
  		clickById("stayOpen1");
  		clickByName("commandbutton-createPOBtn");
  		
  		buyer_FinalizeRequisition ();
  		buyer_logout();
  		
  		String PageTitle = getPageTitle();
    	return PageTitle;
  	
	}
  	 
  	 // select reason code
  	 //selectVisibileTextById("reasonCode", "Only known solution provider for requirement");
  	 //enterById("comments", "test only");
	     //clickByName("commandbutton-confirmSkip")
    	 	 
    	

	

	public void buyer_FinalizeRequisition () throws InterruptedException {
  		clickById("accountingForBond3");
  		//  click on milestone
  		clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[31]/td/table/tbody/tr[2]/td[1]/a");
  		
  		// select commodity code
  		selectIndexById("commodityCode", 4);
  		
  				
  		// click on edit this milestone
  		clickByName("commandbutton-prEdit");
  		// enter milestone unit price
  		enterById("prMilunitPrice", "12");
  		clickByName("commandbutton-save_done");
  		
  		clickById("commandbutton-nav-draft-requisition");
  		
	}
  		public void buyer_logout() {
      	  clickByXpath("//*[@id='breadcrumbs']/a");
	        	clickByLink("Sign out");
	    		acceptAlert();
		
	
	}
}