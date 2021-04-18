package CSAFP_US_BD;

import Wrappers.GenericWrappers_US_BD;

public class Buyer_Step2  extends GenericWrappers_US_BD
{

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

	public String buyer_verifySupplierQues() throws InterruptedException {
		 // enter if any ques req
   	 
   	 // click on next
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
		clickById("commandbutton-nav-send-to-suppliers");
		 Thread.sleep(5000);
		String PageTitle = getPageTitle();
    	 return PageTitle;
}

	public String buyer_submitToSupplier() throws InterruptedException
	{
		enterByXpath("//*[@id='commentToSupplier']", "Comment To Supplier");
		Thread.sleep(1000);
	     clickByXpath("//*[@id='content_form']/div/div/table/tbody/tr[13]/td[1]/input[1]");
	     Thread.sleep(5000);
	 	String PageTitle = getPageTitle();
   	 return PageTitle;
	}
}
