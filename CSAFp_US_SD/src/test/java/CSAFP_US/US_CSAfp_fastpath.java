package CSAFP_US;


import static org.testng.AssertJUnit.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class US_CSAfp_fastpath {

	public WebDriver driver;
	Properties config1;
	FileInputStream fis;
	RIPC_step1 step1;
	Buyer_Step2 step2;
	RIPC_Step3 step3;
	

	@BeforeClass
	public void beforeClass() {
		readProperty();
		}

	/**
	 * Reading the properties file and loading
	 */
	public void readProperty() {
		config1 = new Properties();
		step1 = new RIPC_step1();
		step2 = new Buyer_Step2();
		step3 = new RIPC_Step3();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
			config1.load(fis);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	@Test(priority = 1, groups = { "requester" })
	public void ripc_loginTest() throws Exception {

		String expectedLoginUser = "Hello Two Requester";
		String actualLoginUser = step1.login(config1.getProperty("BLUE_TEST_URL"), config1.getProperty("US_REQ_ID"),
				config1.getProperty("US_BLUE_PWD"));
		/*String actualLoginUser = step1.login(config1.getProperty("BLUE_TEST_URL_US"), config1.getProperty("US_REQ_ID"),
				config1.getProperty("US_BLUE_PWD"));*/
		System.out.println(actualLoginUser);
		assertEquals(actualLoginUser, expectedLoginUser);

	}

	@Test(priority = 2, groups = { "requester" }, dependsOnMethods = { "ripc_loginTest" })
	public void ripc_createRequestTest() throws Exception {
		String expectedPageTitle = "CSA Fixed Price - Project attributes";
		String actualPageTitle = step1.ripc_CreateRequest();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 3, groups = { "requester" }, dependsOnMethods = { "ripc_createRequestTest" })
	public void ripc_enterProjectAttributesTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Milestones";
		String actualPageTitle = step1.ripc_enterProjectAttributes();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 4, groups = { "requester" }, dependsOnMethods = { "ripc_enterProjectAttributesTest" })
	public void ripc_addMilestoneTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Milestones - milestone detail";
		String actualPageTitle = step1.ripc_addMilestone();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 5, groups = { "requester" }, dependsOnMethods = { "ripc_addMilestoneTest" })
	public void ripc_enterMilestoneDetailsTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Job role and skill set selection";
		String actualPageTitle = step1.ripc_enterMilestoneDetails();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 6, groups = { "requester" }, dependsOnMethods = { "ripc_enterMilestoneDetailsTest" })
	public void add_JRSSTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Milestones";
		String actualPageTitle = step1.add_JRSS();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 7, groups = { "requester" }, dependsOnMethods = { "add_JRSSTest" })
	public void click_PeopleInvolvedTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - People involved";
		String actualPageTitle = step1.click_PeopleInvolved();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 8, groups = { "requester" }, dependsOnMethods = { "click_PeopleInvolvedTest" })
	public void click_SuppliersTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Supplier questions";
		String actualPageTitle = step1.click_Suppliers();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 9, groups = { "requester" }, dependsOnMethods = { "click_SuppliersTest" })
	public void ripc_supplierQuestionsTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Supplier evaluation criteria";
		String actualPageTitle = step1.ripc_supplierQuestions();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 10, groups = { "requester" }, dependsOnMethods = { "ripc_supplierQuestionsTest" })
	public void ripc_supplierEvaluationTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Terms and conditions";
		String actualPageTitle = step1.ripc_supplierEvaluation();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 11, groups = { "requester" }, dependsOnMethods = { "ripc_supplierEvaluationTest" })
	public void ripc_termsandcondition() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Submit to buyer";
		String actualPageTitle = step1.ripc_termsandconditions();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 12, groups = { "requester" }, dependsOnMethods = { "ripc_termsandcondition" })
	public void ripc_submitRequestTest() throws InterruptedException {
		String expectedPageTitle = "Contractor sourcing application | Contractor sourcing application";
		String actualPageTitle = step1.ripc_submitRequest();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 13, groups = { "buyer" }, dependsOnGroups = { "requester" })
	public void buyer_loginTest() throws InterruptedException {
		String expectedLoginUser = "Hello BuyerTwo CSAFP";
		String actualLoginUser = step1.Buyerlogin(config1.getProperty("BLUE_TEST_URL"), config1.getProperty("US_BUYER_ID"),
				config1.getProperty("BLUE_PWD"));
		System.out.println(actualLoginUser);
		assertEquals(actualLoginUser, expectedLoginUser);
	}

	@Test(priority = 14, groups = { "buyer" }, dependsOnMethods = { "buyer_loginTest" })
	public void buyer_awaitingActionTest() throws InterruptedException { // verifies
																			// the
																			// same
																			// fixed
																			// price
																			// id
																			// is
																			// opened
																			// by
																			// buyer
		String expected_FixedPriceID = RIPC_step1.FixedPrice_ID;
		System.out.println("expected fixed price id is " + expected_FixedPriceID);
		String actual_FixedPriceID = step2.buyer_awaitingAction();
		System.out.println("Actual fixed price id is " + actual_FixedPriceID);
		assertEquals(actual_FixedPriceID, expected_FixedPriceID);
		System.out.println("fixed price id is verified correctly as " + expected_FixedPriceID);
	}

	@Test(priority = 15, groups = { "buyer" }, dependsOnMethods = { "buyer_awaitingActionTest" })
	public void buyer_verifyProjectAttributesTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Milestones";
		String actualPageTitle = step2.buyer_verifyProjectAttributes();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 16, groups = { "buyer" }, dependsOnMethods = { "buyer_verifyProjectAttributesTest" })
	public void buyer_milestoneTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - People involved";
		String actualPageTitle = step2.buyer_milestone();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 17, groups = { "buyer" }, dependsOnMethods = { "buyer_milestoneTest" })
	public void buyer_verifyPeopleInvolvedTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Suppliers";
		String actualPageTitle = step2.buyer_verifyPeopleInvolved();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}
	
	/*@Test(priority = 18, groups = { "buyer" }, dependsOnMethods = { "buyer_verifyPeopleInvolvedTest" })
	public void buyer_supplierContract() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Suppliers";
		String actualPageTitle = step2.buyer_supplierContract();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}*/

	@Test(priority = 18, groups = { "buyer" }, dependsOnMethods = { "buyer_verifyPeopleInvolvedTest" })
	public void buyer_verifySuppliersTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Supplier questions";
		String actualPageTitle = step2.buyer_verifySuppliers();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 19, groups = { "buyer" }, dependsOnMethods = { "buyer_verifySuppliersTest" })
	public void buyer_verifySupplierQuesTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Supplier evaluation criteria";
		String actualPageTitle = step2.buyer_verifySupplierQues();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}


	
	@Test(priority = 20, groups = { "buyer" }, dependsOnMethods = { "buyer_verifySupplierQuesTest" })
	public void buyer_enterEvaluationCriteriaTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Terms and conditions";
		String actualPageTitle = step2.buyer_enterEvaluationCriteria();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test(priority = 21, groups = { "buyer" }, dependsOnMethods = { "buyer_enterEvaluationCriteriaTest" })
	public void buyer_termsandcondition() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Terms and conditions";
		String actualPageTitle = step2.buyer_termsandconditions();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test(priority = 22, groups = { "buyer" }, dependsOnMethods = { "buyer_termsandcondition" })
	public void buyer_SkipSupplier() throws InterruptedException {
		String expectedPageTitle = "Contractor sourcing application | Contractor sourcing application";
		//String expectedPageTitle = "CSA Fixed Price - Purchase requisition - requisition details";
		String actualPageTitle = step2.buyer_SkipSupplier();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}	


	@Test(priority = 23, groups = { "requester1" }, dependsOnMethods = { "buyer_SkipSupplier" })
	public void ripc_loginTest1() throws Exception {
		String expectedLoginUser = "Hello Two Requester";
		String actualLoginUser = step3.login(config1.getProperty("BLUE_TEST_URL"), config1.getProperty("US_REQ_ID"),
				config1.getProperty("BLUE_PWD"));
		System.out.println(actualLoginUser);
		assertEquals(actualLoginUser, expectedLoginUser);
	}

	@Test(priority = 24, groups = { "requester1" }, dependsOnMethods = { "ripc_loginTest1" })
	public void RIPC_reqSearchTest() throws InterruptedException { // verifies
																	// the same
																	// fixed
																	// price id
																	// is opened
																	// by buyer
		String expected_FixedPriceID = RIPC_step1.FixedPrice_ID;
		System.out.println("expected fixed price id is " + expected_FixedPriceID);
		String actual_FixedPriceID = step3.reqSearch();
		System.out.println("Actual fixed price id is " + actual_FixedPriceID);
		assertEquals(actual_FixedPriceID, expected_FixedPriceID);
		System.out.println("fixed price id is verified correctly as " + expected_FixedPriceID);
	}

	@Test(priority = 25, groups = { "requester1" }, dependsOnMethods = { "RIPC_reqSearchTest" })
	public void RIPC_openRequestTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Purchase requisitions";
		String actualPageTitle = step3.openRequest();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);

	}

	/*@Test(priority = 26, groups = { "requester1" }, dependsOnMethods = { "RIPC_openRequestTest" })
	public void RIPC_PRTest() throws InterruptedException {
		String expectedPageTitle = "CSA Fixed Price - Purchase requisitions";
		String actualPageTitle = step3.PR();
		System.out.println("actual page title is " + actualPageTitle);
		assertEquals(actualPageTitle, expectedPageTitle);
	}*/

}
