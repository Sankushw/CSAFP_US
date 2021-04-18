package CSAFP_US;


import java.io.File;

import Wrappers.GenericWrappers_US;

public class RIPC_Step3 extends GenericWrappers_US
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
	selectIndexById("metroApprovalReason", 1);
	//selectVisibileTextByCssSelector("*[id^='commodity']", "Y260 Technical Services Y260");  
	//waitBrowser();
	//clickByXpath("//*[@id='commandbutton-nav-create-purchase-requisition']");	
	//waitBrowser();
	
	clickByXpath("//*[@id='content_form']/html/body/div[6]/div[2]/form/div[1]/div/table/tbody/tr[29]/td/table/tbody/tr[4]/td[2]/select/option[2]");		
	waitBrowser();
	clickByXpath("//*[@id='commandbutton-nav-create-purchase-requisition']");
	
	//deleting snapshots captured in Screenshot folder will be deleted at the end of the flow
	   File dir = new File(System.getProperty("user.dir")+"/Screenshots/US");
		
		if(dir.isDirectory() == false) {
			System.out.println("Not a directory. Do nothing");
			return "";
		}
		File[] listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
	
	return PR();	
	
	
}
}
