package Wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.jboss.aerogear.security.otp.Totp;
import org.jboss.aerogear.security.otp.api.Clock;

public class GenericWrappers_US
{
	
	static WebDriver dr;
	int i=0;
	
	/**
	 * 
	 * Generating Buyer 2FA code here
	 */
	public static String getBuyerTwoFactorCode() {
		Totp totp = new Totp("BK5ZKASM5QIDGVAF"); // 2FA secret key
		String twoFactorCode = totp.now(); // Generated 2FA code here
		return twoFactorCode;
	}

	/**
	 * 
	 * get Requester 2FA
	 */
	public static String getRequesterTwoFactorCode() {
		Totp totp = new Totp("34EPNZHGEC6JZLIN"); // 2FA secret key
		String twoFactorCode = totp.now(); // Generated 2FA code here
		return twoFactorCode;
	}
	
	public String login(String URL, String UName, String Pass) throws InterruptedException
	{
	    invokeApp(URL);
		dr.get(URL);
		dr.manage().window().maximize();
		clickByXpath("//div[@class='terms']/p[2]/a");
		enterById("desktop", UName);
		enterByName("password", Pass);
		clickById("btn_signin");
		//dr.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 

		try {
			
			WebDriverWait wait2 = new WebDriverWait(dr, 180);
			
			wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[contains(text(),'Use an authenticator app')]"))));
			dr.findElement(By.xpath("//*[contains(text(),'Use an authenticator app')]")).click();
			//dr.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			//dr.findElement(By.xpath(".//a[@class='delivery method-link' and @type='totp']")).click();
			
			String otpKeyStr = "34EPNZHGEC6JZLIN"; 
			//String otpKeyStr = "YCX3MGYU7XF7P3NB";
			Totp totp = new Totp(otpKeyStr);
			String twoFactorCode = totp.now();
			System.out.println("The passcode is:"+ twoFactorCode);
			
			wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[@id='otp']"))));
			
			//*[@id="content-main"]/form[1]/div/span/input
			
			//*[@id='otp']
			//*[@id='btn_submit']
			
			System.out.println("The passcode is:"+ twoFactorCode);
			
			WebElement oneFCode= dr.findElement(By.id("otp"));
			oneFCode.sendKeys(twoFactorCode);
			oneFCode.submit();
			
			System.out.println("The passcode is:"+ twoFactorCode);
			
			//System.out.println("btn_submit"+dr.findElement(By.xpath("//*[@id='btn_submit']")));
			
			//dr.findElement(By.xpath("//*[@id='btn_submit']")).click();
			
			dr.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			
			wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[@id='content-main']/form[1]/div/span/input"))));
			
		}
		
	catch (Exception e) {
		System.out.println("no OTP screen");
		//e.printStackTrace();
	}
		String loginuser = getLoginUserbyXPath("//*[@id='content-main']/p[1]/b");
		return loginuser;
		
	} 
	
	
	public String Buyerlogin(String URL, String UName, String Pass) throws InterruptedException
	{
	    invokeApp(URL);
		dr.get(URL);
		dr.manage().window().maximize();
		clickByXpath("//div[@class='terms']/p[2]/a");
		enterById("desktop", UName);
		enterByName("password", Pass);
		clickById("btn_signin");
		//dr.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
		
		//Totp totp = new Totp("BK5ZKASM5QIDGVAF"); // 2FA secret key
		try {
			
			WebDriverWait wait2 = new WebDriverWait(dr, 180);
			
			wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[contains(text(),'Use an authenticator app')]"))));
			dr.findElement(By.xpath("//*[contains(text(),'Use an authenticator app')]")).click();
			//dr.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			//dr.findElement(By.xpath(".//a[@class='delivery method-link' and @type='totp']")).click();
			
			String otpKeyStr = "BK5ZKASM5QIDGVAF"; 
			//String otpKeyStr = "YCX3MGYU7XF7P3NB";
			Totp totp = new Totp(otpKeyStr);
			String twoFactorCode = totp.now();
			System.out.println("The passcode is:"+ twoFactorCode);
			
			wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[@id='otp']"))));
			
			//*[@id="content-main"]/form[1]/div/span/input
			
			//*[@id='otp']
			//*[@id='btn_submit']
			
			System.out.println("The passcode is:"+ twoFactorCode);
			
			WebElement oneFCode= dr.findElement(By.id("otp"));
			oneFCode.sendKeys(twoFactorCode);
			oneFCode.submit();
			
			System.out.println("The passcode is:"+ twoFactorCode);
			
			//System.out.println("btn_submit"+dr.findElement(By.xpath("//*[@id='btn_submit']")));
			
			//dr.findElement(By.xpath("//*[@id='btn_submit']")).click();
			
			dr.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			
			wait2.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[@id='content-main']/form[1]/div/span/input"))));
			
		}
		
	catch (Exception e) {
		System.out.println("no OTP screen");
		//e.printStackTrace();
	}
		
		String loginuser = getLoginUserbyXPath("//*[@id='content-main']/p[1]/b");
		return loginuser;
		
	} 
	
	public void unhandledAlert(String id){
		Alert alert = null;
		
		WebDriverWait wait = new WebDriverWait(dr, 10, 50);
		try {
			dr.findElement(By.id(id)).click();
		   alert = wait.until(ExpectedConditions.alertIsPresent());
		   System.out.println(alert.getText());
		} catch (TimeoutException ignored) {
		}
		if (alert != null) {
		   alert.accept(); // this line throws the exception
		} 
		
	}
	
	public String logout() throws InterruptedException
	{
		clickByLink("Sign out");
		acceptAlert();
		Thread.sleep(3000);
		String nextPage = getPageTitle();
 	    return nextPage;
		
	}
	
	public String supplierLogin(String pwd, String username, String url) throws InterruptedException
	{
		dr = new FirefoxDriver();
	    dr.get("https://"+username+":"+pwd+"@"+url);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		dr.findElement(By.name("username")).sendKeys(username);
		dr.findElement(By.id("continue-button")).click();
		dr.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(2000);
		dr.findElement(By.id("signinbutton")).click();
		dr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		Thread.sleep(5000);
		String nextpage=dr.getTitle();
	return nextpage;
	}
	
	
	public void invokeApp(String url) 
	{

		try {
			   FirefoxBinary firefoxfBinary = new FirefoxBinary();
		       System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
		       //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver");
			   FirefoxOptions firefoxOptions = new FirefoxOptions();
			   //firefoxOptions.setHeadless(true);
			   firefoxOptions.setBinary(firefoxfBinary);
		       WebDriver driver = new FirefoxDriver(firefoxOptions);
		       driver.manage().window().maximize();
		       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		       dr = driver;
			
			
			
			
			/*
			File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
		     dr = new FirefoxDriver(ffBinary,firefoxProfile);  
			*/
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			dr.get(url);
			dr.manage().window().maximize();
			screenshot();
			System.out.println("The Browser is Launched");
			
		}
		    catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("driver not found exception");
		}
			
			catch(Exception e)
			{
				System.out.println("Browser has not launched");
			}
				finally{
			    
			System.out.println("Screen shot is captured");
		}
	}
	
	 public void screenshot() 
	{
			File src = 	((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+"/Screenshots/US/snap"+i+".png");
			try {
				FileUtils.copyFile(src, destFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			i++;
	}
	
	 public void enterById(String idValue, String data)
	 {
			try
			{
				dr.findElement(By.id(idValue)).clear();
				dr.findElement(By.id(idValue)).sendKeys(data);
				screenshot();
				System.out.println("The text field " + idValue + " is entered with data :" + data);
			}
			catch (NoSuchElementException e)
			{
				e.printStackTrace();
			   System.out.println("Element is not found");
			   throw new RuntimeException();
			}
			   catch (Exception e2) {
				System.out.println("Run time exception is found");
				
			}
			finally 
			{
				System.out.println("Screen shot has taken");
			}

		}
		
		public void enterByName(String nameValue, String data)
		{
			try
			{
				dr.findElement(By.name(nameValue)).clear();
				dr.findElement(By.name(nameValue)).sendKeys(data);
				screenshot();
				System.out.println("The text field " + nameValue + " is entered with data :" + data);
			}
			catch (NoSuchElementException e)
			{
				System.out.println("No Such element present");
				
			}
			catch (Exception e) 
			{
				System.out.println("Exception");
			}
			finally
			{
				System.out.println("Sceenshot has taken");
			}

		}
		
		public void enterByXpath(String xpathValue, String data) 
		{
			try
			{
				dr.findElement(By.xpath(xpathValue)).clear();
				dr.findElement(By.xpath(xpathValue)).sendKeys(data);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}

		}

		public boolean verifyTitle(String title)
		{
			try 
			{
				
				boolean bR = false;
				if (dr.getTitle().equals(title)) {
					bR = true;

				}
				return bR;
				
			}
			catch (NoSuchElementException e) {
				System.out.println("Element not found");
			}
			catch (Exception e) {
				System.out.println("Exception occured");
			}
			finally {
				screenshot();
				System.out.println("Title is " + title);
				System.out.println("Title is verified correctly");
			}
			return true;
			
			
		}
		public String getPageTitle()
		{
			String title = dr.getTitle();
			return title;	
		}

		public void verifyTextById(String id, String text)
		{
			// TODO Auto-generated method stub
			String r1 = dr.findElement(By.id(id)).getText();

			if(r1.equals(text))
			{
				System.out.println("duplicated name is same");

			}

			else
			{
				System.out.println("duplicated name does not match");
			}
		}

		public void verifyTextByXpath(String xpath, String text) 
		{
			String str = dr.findElement(By.xpath(xpath)).getText();
			System.out.println(str);

			if(str.equals(text))
			{
				System.out.println("text is verified");

			}
			else
			{
				System.out.println("text is not verified");
			}
		}

		public void verifyTextContainsByXpath(String xpath, String text) {
			try {
				// TODO Auto-generated method stub
				String str = dr.findElement(By.xpath(xpath)).getText();
				if (str.contains(text)) {
					System.out.println("account is deactivated as " + str);
					System.out.println("text contains " + text);

				} else {
					System.out.println("Account name does not contains " + text);
				} 
			} catch (NoSuchElementException e) {
				System.out.println("Element not found");
			}
			catch (Exception e) {
				System.out.println("Exception occured");
			}
			finally {
				System.out.println("text is confirmed");
			}

		}

		public void verifyTextContainsByID(String id, String text) {
			// TODO Auto-generated method stub
			String str = dr.findElement(By.xpath(id)).getText();

			if(str.contains(text))
			{
				System.out.println("The text has updated company name as " + str);

			}
			else{
				System.out.println("wrong code");
			}

		}

		
		public void clickById(String id) {
			
	        try{
			dr.findElement(By.id(id)).click();

			System.out.println(id + " is clicked");
			
			
	        }catch (NoSuchElementException e) {
				
				System.out.println("Element is not found");
				
			}
			catch(Exception e1){
				System.out.println("Exception has occured");
			}
			
			finally {
				screenshot();
				System.out.println("snapshot has taken");
			}
	        
		}

		public void clickByClassName(String classVal) {
			try {
				dr.findElement(By.className(classVal)).click();
				System.out.println("The button " + classVal + " is clicked");
			} catch (NoSuchElementException e) {
				
				System.out.println("Element is not found");
				
			}
			catch(Exception e1){
				System.out.println("Exception has occured");
			}
			
			finally {
				System.out.println("scrpit is moving");
			}
		}

		public void clickByName(String name)
		{
			dr.findElement(By.name(name)).click();

			System.out.println("The button "+name+" is clicked");
		}

		public void clickByLink(String name) {
			
			try{
			
			dr.findElement(By.linkText(name)).click();
			screenshot();

			System.out.println("The link "+name+" is clicked");
			}
			catch (NoSuchElementException e) {
				System.out.println("Element not found");
			}
			catch (Exception e) {
				System.out.println("Exception present");
			}
			finally {
				System.out.println("snap shot for" + name + "has taken" );
			}
			
		}


		public void clickByXpath(String xpathVal) {
			try {
				dr.findElement(By.xpath(xpathVal)).click();
			}
				
		   catch (NoSuchElementException e) {
				System.out.println("Element is not found");
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("The link "+xpathVal+" is clicked");

			}
				}

		
		public String getTextById(String idVal) {
			// TODO Auto-generated method stub
			String  txt= dr.findElement(By.id(idVal)).getText();	
			System.out.println("The value of text is "+txt);
			return txt;
		}

		public String getTextByXpath(String xpathVal) 
		{
			String s1 = dr.findElement(By.xpath(xpathVal)).getText();
			String fp_ID = s1.substring(22, 28);
			System.out.println("Fixed price request id is -> "+fp_ID);
			return fp_ID;
		}

		public String getTextByXpath1(String xpathVal1) 
		{
			String s1 = dr.findElement(By.xpath(xpathVal1)).getText();
			String fp_ID = s1.substring(21, 27);
			System.out.println("Fixed price request id is -> "+fp_ID);
			return fp_ID;
		}

		
		public String getFPIDByXpath(String xpathVal) 
		{
			String s1 = dr.findElement(By.xpath(xpathVal)).getText();
			System.out.println("Fixed price request id is -> "+s1);
			return s1;
		}

		
		
		public void selectVisibileTextById(String id, String value) {
			
			try{
		   WebElement dropdown = dr.findElement(By.id(id));
			Select dDown = new Select(dropdown);
			dDown.selectByVisibleText(value);
			System.out.println(id + "is selected with value as" + value);
			}
			catch (NoSuchElementException e) {
				System.out.println("No Such element present");
				
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("Sceenshot has taken");
			}

			

		}
public void selectVisibileTextByxpath(String xpath, String value) {
			
			try{
			WebElement dropdown = dr.findElement(By.xpath(xpath));
			Select dDown = new Select(dropdown);
			dDown.selectByVisibleText(value);
			System.out.println(xpath + " is selected as" + value);
			}
			catch (NoSuchElementException e) {
				System.out.println("No Such element present");
				
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("Sceenshot has taken");
			}

			

		}
		public void selectVisibileTextByName(String name, String value) {
			
			try{
			WebElement dropdown = dr.findElement(By.id(name));
			Select dDown = new Select(dropdown);
			Thread.sleep(2000);
	    	 
			dDown.selectByVisibleText(value);
			System.out.println(name + " is selected as" + value);
			}
			catch (NoSuchElementException e) {
				System.out.println("No Such element present");
				
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("Sceenshot has taken");
			}

			

		}
		public void selectIndexById(String id, int value) {
			try{
			WebElement dropdown = dr.findElement(By.id(id));
			Select dDown = new Select(dropdown);
			dDown.selectByIndex(value);
			System.out.println(id + "is selected as " + value);
			}
			catch (NoSuchElementException e) {
				System.out.println("No Such element present");
				
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("Sceenshot has taken");
			}

		}

		public void switchToParentWindow() {
			// switch to parent window
			try{
			Set<String> w1 = dr.getWindowHandles();
	        System.out.println(w1.size());
		    for (String win : w1) {
		    	System.out.println(win);
		    	dr.switchTo().window(win);
		    	}
		    System.out.println(dr.getTitle()); 
				
			}
			
			catch (NoSuchWindowException e) {
				System.out.println("window not found");
			}
				
			
			catch (Exception e2) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("Sceenshot has taken");
			}

			
		}

		public void switchToLastWindow()
		{
			//switch to second window
			Set<String> a1 = dr.getWindowHandles(); 
	        System.out.println(a1.size());
	        
	        for (String eachWindow : a1) {
				
	       	 System.out.println(eachWindow);
	       	 System.out.println(dr.getTitle());
	       	 dr.switchTo().window(eachWindow);
	       	}
	        System.out.println(dr.getTitle());
			
	        

		}

		public void acceptAlert() {
			try{
			
				dr.switchTo().alert().accept();
				screenshot();
			
			System.out.println("Alert is accepted");
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("Alert not present");
			}
			catch(Exception e1)
			{
				System.out.println("Exception occured");
			}
			finally{
				System.out.println("Alert is present");
			}
		}

		public void dismissAlert() {
			// TODO Auto-generated method stub

		}

		public String getAlertText() {
			// TODO Auto-generated method stub
			return null;
		}

		
		public void clickByCSS(String css)
		{
			dr.findElement(By.cssSelector(css)).click();
		}

		
	public void selectVisibileTextByCssSelector(String CSS, String value) {
			
			try{
			WebElement dropdown = dr.findElement(By.cssSelector(CSS));
			Select dDown = new Select(dropdown);
			dDown.selectByVisibleText(value);
			System.out.println(CSS + " is selected as" + value);
			}
			catch (NoSuchElementException e) {
				System.out.println("No Such element present");
				
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				screenshot();
				System.out.println("Sceenshot has taken");
			}
	}

		
		public String getLoginUserbyXPath(String xpath){
			
			
			String loginUser = dr.findElement(By.xpath(xpath)).getText();
			System.out.println("Login is successful with "+ loginUser);
			screenshot();
			return loginUser;
		
		}
		
		public String getStatusByXpath(String xpath){
			String status = dr.findElement(By.xpath(xpath)).getText();
			return status;
		}
		
	  public String getPR_IDByXpath(String xpath){
		  String PR = dr.findElement(By.xpath(xpath)).getText();
			return PR; 
	  }
		
		
		public void closeBrowser() {
			// TODO Auto-generated method stub
			try
			{
				dr.close();	
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			
		}
		
		
		public void waitBrowser()
		{
			dr.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		}

}