package CSAFP_US_BD;


import org.openqa.selenium.WebDriver;

import Wrappers.GenericWrappers_US_BD;

public class RIPC_step1 extends GenericWrappers_US_BD
{
	 WebDriver dr;
	public  static String FixedPrice_ID = "";
	public String ripc_CreateRequest() throws Exception{
		
		clickByXpath("//*[@id='content-main']/form[1]/div/span/input");
	    clickById("FLD_REQ_TYPE");
		clickById("FLD_NORMAL_TYPE2");
		clickByXpath("//*[@id='content-main']/form/div/span[1]/input");
		Thread.sleep(3000);
		FixedPrice_ID = getTextByXpath("//*[@id='content-main']/h1");
		//CSAFP_BuyerSubmitToSupplierPage.fixedPriceId = FixedPrice_ID;
		System.out.println("In req" + FixedPrice_ID);
		String title = getPageTitle();
		  return title;  
  }
     
  public String ripc_enterProjectAttributes() throws InterruptedException{

	  //sub category
	  //selectIndexById("requestingSubcat1", 4);
    		// Select the Client
    		selectVisibileTextById("client", "SOLUTIONS SW");
    	    // Select the industry
    		selectIndexById("industrySector", 7);
   	       // Enter the customer name
    	    enterById("customerNumber", "customer");
            // Enter the project name
    	    enterById("projectName", "testing_L2");
    	    // Enter the request description
    	    enterById("requestDescription", "request description");
    	    // Select the commodity
    	    selectVisibileTextByName("commodityType","IT Consulting");
    	    // importing the requirement doc
    	    // click the attach req doc button
    	    clickByXpath("//*[@id='sow_attach_button']/input");
    	    Thread.sleep(5000);
    	 
    	    // switch to second window
    	    switchToLastWindow();
            Thread.sleep(2000);
         // switch to second window
    	    switchToLastWindow();
            Thread.sleep(2000);
         // import file for windows
            enterById("importFile",System.getProperty("user.dir") + "\\Links.txt");
          //enterById("importFile",System.getProperty("user.dir") + "/Links.txt");
            
            //Linux
           // File homedir = new File(System.getProperty("user.home"));
           // File fileToRead = new File(homedir, "/Links.txt");
           // enterById("importFile",System.getProperty("user.home") + "/Links.txt");
            //enterById("importFile",System.getProperty("user.dir") + "/Links.txt");
           
            Thread.sleep(5000);
            // click on upload button
            clickById("submitButton");
            Thread.sleep(3000);
            closeBrowser();
            //switch to parent window
             switchToParentWindow();
             
             Thread.sleep(2000);
             clickById("flowDownTerms1");
             clickById("workLocationType1");
             Thread.sleep(1000);
            
            /*Thread.sleep(5000);
            // click on upload button
            clickById("submitButton");
            Thread.sleep(3000);
            closeBrowser();
            //switch to parent window
             switchToParentWindow();*/
             
             /*Thread.sleep(2000);
             clickById("flowDownTerms1");
             clickByXpath("//*[@id='workLocationAlterable1']");*/
             //clickById("workLocationType1");
             Thread.sleep(1000);
             selectVisibileTextByxpath("//*[@id='workLocationCountry']","United States");
             selectVisibileTextByxpath("//*[@id='workLocationRegion']","New York");
             selectVisibileTextByxpath("//*[@id='workLocationCity']","NEW YORK");
             selectVisibileTextByxpath("//*[@id='workLocationStreetIbm']","55 BROADWAY");
             
             
            clickByXpath("//*[@id='workLocationAlterable1']");
            // go to next page
            clickByXpath("//*[@id='content-main']/div[3]/table/tbody/tr/td[3]/a");  
            Thread.sleep(3000);
             String nextPageTitle = getPageTitle();
             return nextPageTitle;
	  
  }  
  public String ripc_enterProjectAttributes_Other() throws InterruptedException{

	  //sub category
	  selectIndexById("requestingSubcat1", 4);
    		// Select the Client
    		selectVisibileTextById("client", "SOLUTIONS SW");
    	    // Select the industry
    		selectIndexById("industrySector", 7);
   	       // Enter the customer name
    	    enterById("customerNumber", "customer");
            // Enter the project name
    	    enterById("projectName", "testing_L2");
    	    // Enter the request description
    	    enterById("requestDescription", "request description");
    	    // Select the commodity
    	    selectVisibileTextByName("commodityType","IT Consulting");
    	    // importing the requirement doc
    	    // click the attach req doc button
    	    clickByXpath("//*[@id='sow_attach_button']/input");
    	    Thread.sleep(5000);
    	 
    	    // switch to second window
    	    switchToLastWindow();
            Thread.sleep(2000);
            // import file
            enterById("importFile", System.getProperty("user.dir") + "\\Links.txt");
            Thread.sleep(1000);
            // click on upload button
            clickById("submitButton");
            Thread.sleep(3000);
            closeBrowser();
            //switch to parent window
             switchToParentWindow();
          

             Thread.sleep(2000);
             clickById("flowDownTerms1");
             clickById("workLocationType1");
             Thread.sleep(1000);
            /* selectVisibileTextByxpath("//*[@id='workLocationCountry']","United States");
             selectVisibileTextByxpath("//*[@id='workLocationRegion']","New York");
             selectVisibileTextByxpath("//*[@id='workLocationCity']","NEW YORK");
             selectVisibileTextByxpath("//*[@id='workLocationStreetIbm']","55 BROADWAY");*/
            
             
       
             clickById("workLocationAlterable1"); 
            //clickByXpath("//*[@id='workLocationAlterable1']");
            // go to next page
            clickByXpath("//*[@id='content-main']/div[3]/table/tbody/tr/td[3]/a");  
            Thread.sleep(7000);
             String nextPageTitle = getPageTitle();
             return nextPageTitle;
	  
  }  
	  
	  
  
  public String ripc_addMilestone() throws InterruptedException{
	    // Enter Expected Start Date
	  Thread.sleep(2000);
        enterByXpath("//*[@id='expectedStartDate']","11 Dec 2020" );
        // Enter Expected End Date
        enterByXpath("//*[@id='expectedEndDate']", "11 Jan 2021");
        // Enter estimated price
        enterByXpath("//*[@id='estimatedPrice']", "10");
        selectVisibileTextById("currency","USD");
        
        // Add milestone
        clickByName("commandbutton-addMilestone");
        Thread.sleep(3000);
        String nextPage =  getPageTitle();
        return nextPage;
  
  }
	  

  public String ripc_enterMilestoneDetails() throws InterruptedException{
	// enter milestone name
        enterByXpath("//*[@id='msName']", "milestone_1");
        // enter milestone description
        enterByXpath("//*[@id='msDescription']","milestone_description");
        //enter deliverables
        enterById("msQuantity", "1");
        
        selectVisibileTextById("msType","Resource Support - FTE Hourly");
        
        
        // Add JRSS
        clickByName("commandbutton-add_job_role_skill_set");
        Thread.sleep(5000);
        String nextPage = getPageTitle();
        return nextPage;
       	  
  }
 
  public String add_JRSS() throws InterruptedException{
	  
	  selectVisibileTextById("resourcePlanPopupJobRole", "Application Developer");
        Thread.sleep(3000);
        selectVisibileTextById("resourcePlanPopupSkillSet", "Java.Core");
        clickByXpath("//*[@id='content_form']/div[3]/div/table[3]/tbody/tr/td/input[1]");
        selectVisibileTextByCssSelector("*[id^='band']", "Band C");  
        enterByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/input", "1");
        Thread.sleep(5000);
        clickByName("commandbutton-save_done");
        Thread.sleep(5000);
       String nextPage = getPageTitle();
       return nextPage;
  }
  

   public String click_PeopleInvolved() throws InterruptedException{
	   clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
	   Thread.sleep(3000);
	   String nextPage = getPageTitle();
	   return nextPage;
   }

   
   public String click_Suppliers() throws InterruptedException{
	   clickByXpath("//*[@id='Request details']/table/tbody/tr[4]/td/a");
	   // select the checkbox for supplier
       
       clickByXpath("//*[@id='1000118974~IBMSAPGC0']");
    // click to next page
       clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
       Thread.sleep(5000);
	   String nextPage = getPageTitle();
	   return nextPage;
   }
   
   
   public String ripc_supplierQuestions() throws InterruptedException{
	// click to next page
      clickByXpath("//*[@id='CSAFP10']");
       // click to next page
       clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
       Thread.sleep(4000);
 	  String nextPage = getPageTitle();
	   return nextPage;      
   }
   
   public String ripc_supplierEvaluation() throws InterruptedException 
   {
	   clickByXpath("//*[@id='content-main']/div[1]/table/tbody/tr/td[4]/a");
       Thread.sleep(3000);
 	   String nextPage = getPageTitle();
	   return nextPage;      
	}
 
   
   public String ripc_termsandconditions() throws InterruptedException
   {
	   Thread.sleep(1000);
	   clickByXpath("//*[@id='commandbutton-nav-submit']");
	   Thread.sleep(3000);
 	   String nextPage = getPageTitle();
	   return nextPage;   	   
   }

    public String ripc_submitRequest() throws InterruptedException
    {
        clickByXpath("//*[@id='specialTerms1']");
       // clickById("flowDownTerms2");
        enterById("commentToBuyer", "Comment to buyer");
        Thread.sleep(4400);
        clickByName("commandbutton-proceedSubmission");
        Thread.sleep(4000);
        String nextPage = getPageTitle();
 	    return nextPage; 
}
    
}
