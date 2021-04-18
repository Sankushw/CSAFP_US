package CSAFP_US_BD;

import java.io.File;

import Wrappers.GenericWrappers_US_BD;

public class RIPC_Step5 extends GenericWrappers_US_BD
{
public String reqSearch() throws InterruptedException
{
	clickByXpath("//*[@id='left-nav']/div/a[8]");
	enterById("FLD_REQ_NUM_SEARCH", RIPC_step1.FixedPrice_ID);
	clickByXpath("//*[@id='content-main']/form/table/tbody/tr[9]/td[3]/div/span/input");
	clickByXpath("//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a");//open request
	Thread.sleep(5000);
	String FPID = getTextByXpath("//*[@id='content-main']/h1");
	return FPID;
	
}
public String openRequest() throws InterruptedException
{
	clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[12]/td/table/tbody/tr[2]/td[1]/a");
	Thread.sleep(5000);
	   String pageTitle = getPageTitle();
	   return pageTitle;
}
public String PR() throws InterruptedException
{
	Thread.sleep(2000);
	clickById("accountingForBond3");
	selectIndexById("metroApprovalReason", 1);
	/*clickByXpath("//*[@id='content_form']/div[1]/div/table/tbody/tr[30]/td/table/tbody/tr[2]/td[1]/a");
	Thread.sleep(5000);*/
	
	//selectVisibileTextByxpath("//*[@id='workLocationCountry']","United States");
	
	selectVisibileTextByxpath("//*[@id='workLocationCountry']","United States");
	
	selectVisibileTextByCssSelector("*[id^='commodity']", "T95 SUBC TRAVEL&MISC");  
	waitBrowser();
	clickByXpath("//*[@id='commandbutton-nav-create-purchase-requisition']");	
	waitBrowser();
	Thread.sleep(2000);
	   String pageTitle = getPageTitle();
	   
	   //deleting snapshots captured in Screenshot folder will be deleted at the end of the flow
	   File dir = new File(System.getProperty("user.dir")+"/Screenshots/JP");
		
		if(dir.isDirectory() == false) {
			System.out.println("Not a directory. Do nothing");
			return "";
		}
		File[] listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
	   
	   return pageTitle;
}
}
