package CSAFP_US_BD;

import Wrappers.GenericWrappers_US_BD;

public class Buyer_Step4 extends GenericWrappers_US_BD
{
	public String buyer_awaitingAction() throws InterruptedException 
	{
		Thread.sleep(5000);
		clickByXpath("//*[@id='left-nav']/div/a[4]");   // awaiting buyer action
		clickByXpath("//*[@id='content-main']/p[4]/a"); // fixed price		
		//System.out.println("In buyer" + RIPC_step1.FixedPrice_ID);
		enterById("FLD_REQUEST_NUMBER", RIPC_step1.FixedPrice_ID); // fp id
		clickByName("btnGo");  //click go
		clickByXpath("//*[@id='content-main']/form/table[5]/tbody/tr[2]/td[1]/a");  
		//click on fp id
		Thread.sleep(5000);
		String FPID = getTextByXpath("//*[@id='content-main']/h1");
		return FPID;
	}
	public String buyer_winner() throws Exception
	{
		clickByName("chkBoxFinalistSupplier");
		clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[10]/td/input[2]");
		clickByName("chkBoxWinnerSupplier");
		clickByName("commandbutton-proceedReq");
		Thread.sleep(5000);
		System.out.println("HII");
		acceptAlert();
		System.out.println("HIIIIIIIIIIIIIIIiii");
		 Thread.sleep(3000);
		   String pageTitle = getPageTitle();
		   return pageTitle;
	}
	
	public String purchaseReq() throws InterruptedException
	{
		selectIndexById("sourceSelectionCode", 4);
		selectIndexById("ssvTechnique", 4);
		enterById("sourceSelectionDesc", "Source selection description");
		enterById("fvDescription", "Fair value determination description");
		clickById("allowPrHandsFree2");
		//clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[18]/td[2]/input");
		 //Thread.sleep(5000);
		 clickByName("commandbutton-createPOBtn");
		 //clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[25]/td/input");
		 Thread.sleep(5000);
		   String pageTitle = getPageTitle();
		   return pageTitle;
	}
	public String buyer_reason() throws InterruptedException
	{
		selectIndexById("metroApprovalReason", 1);
		Thread.sleep(1000);
		clickByXpath("//*[@id='commandbutton-nav-draft-requisition']");
		Thread.sleep(3000);
		clickByXpath("//*[@id='breadcrumbs']/a");
		Thread.sleep(3000);
		   String pageTitle = getPageTitle();
		   return pageTitle;
	}

}
