package com.plan.test;

import java.lang.reflect.Method;
import java.util.logging.LogManager;

//import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.plan.common.HIFIConstants;
import com.plan.pages.Cartpage;
import com.plan.pages.Contactpage;
import com.plan.pages.Homepage;
import com.plan.pages.Shoppage;
import com.plan.util.BaseTestObject;
import com.plan.ExtentReports.ExtentTestManager;


public class LoginPageTest extends BaseTestObject {

	// Fetching the values from the property file
	public String forename = ObjProperty.getProperty("Forename");
	public String surname = ObjProperty.getProperty("Surname");
	public String email = ObjProperty.getProperty("Email");
	public String telephone = ObjProperty.getProperty("Telephone");
	public String message = ObjProperty.getProperty("Message");
	public String funnyCow = ObjProperty.getProperty("FunnyCow");
	public String fluffyBunny = ObjProperty.getProperty("FluffyBunny");
	public String stuffedFrog = ObjProperty.getProperty("StuffedFrog");
	public String valentineBear = ObjProperty.getProperty("ValentineBear");
	public String StuffedFrogCount = ObjProperty.getProperty("StuffedFrogCount");
	public String FluffyBunnyCount = ObjProperty.getProperty("FluffyBunnyCount");
	public String ValentineBearCount = ObjProperty.getProperty("ValentineBearCount");
	

	// Creating the objects for the Classes
	Homepage objhomepage;
	Contactpage objcontactpage;
	Shoppage objshoppage;
	Cartpage objcartpage;

	// Extent manager Obj
	ExtentTestManager extentlog;

	boolean flag = false;

	String home_page_title = null;
	String TotalItemsIntheCart = null;
	String Enter_search_value = null;
	String FirstSubtotal = null;
	String Secondsubtotal = null;
	String ThirdSubtotal = null;
	

	// @Parameters({"browserType"})
	/**
	 * @author Manjunath Below Test case coveres End to end flow Testcase and willexecute 5 times
	 * 
	 * @throws Exception
	 */
	@Test(priority = 0, enabled = true, description = "Verify all the Fields on the Page with Error Message and Submit the form with valida data")
	public void verifyEndtoEndFlowForErrorAndSuccessForSubmition(Method method) throws Exception {
		try {
			for(int i=1; i<=5; i++)
			{
				int counter = i;
			// Reporter Log Starts for the Test case
			ExtentTestManager.startTest(method.getName(),
					"User will verify al the Errormessages and Elements on the Page and Entered all the details and submitted.");
			objhomepage = new Homepage(driver);
			home_page_title = objhomepage.verifyHomePageTitle();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified the Home Page Title is " + home_page_title);
			objcontactpage = objhomepage.clickOnContactButton();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on ContactButton ");
			objcontactpage.verifyConatctPageTitle();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified the page title for Contactpage ");
			objcontactpage.verifyAllTheErrorMessage();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified all the error messages in verifyAllTheErrorMessage Method");
			objcontactpage.VerifyTheSuccessMessage(forename,surname,email,telephone,message);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Entered Required Fields and Submitted and validated the Success Message with forname");
			ExtentTestManager.getTest().log(LogStatus.PASS, "End to End flow is completed and Iteration is   " + counter );
			}
		} catch (Exception e) {
			throw new Exception("FAILED COMPELTE THE END TO FLOW " + e.getLocalizedMessage());
		}

	}
	


	/**
	 * 
	 * @author Manjunath Below Test case Verify User is able to Add items to the cart
	 * 
	 * @throws Exception
	 */
	
	@Test(priority = 1, enabled = true, description = "Verify User is able to Add items to the cart")
	public void verifyItemsInthecart(Method method) throws Exception {
		try {
			// Reporter Log Starts for the Test case
			ExtentTestManager.startTest(method.getName(),
					"Verify User is able to Add items to the cart");
			objhomepage = new Homepage(driver);
			home_page_title = objhomepage.verifyHomePageTitle();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified the Home Page Title is " + home_page_title);
			objshoppage = objhomepage.clickOnShopButton();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Shop Button ");
			objshoppage.clickOnBuy(funnyCow);
			objshoppage.clickOnBuy(fluffyBunny);
			objcartpage = objshoppage.clickOnCartButton();
			TotalItemsIntheCart= objcartpage.verifyTheItemsIntheCart();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Total Items in the cart " + TotalItemsIntheCart);
			objcartpage.VerifyAndNavigateBack();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Second Test case Executed");

		} catch (Exception e) {

			throw new Exception("Not able to add to the cart" + e.getLocalizedMessage());
		}

	}
	


	/**
	 * @author Manjunath Below Test case  Verify user is able to add to the cart and verify the subtotal
	 * 
	 * @throws Exception
	 */

	@Test(priority = 2, enabled = true, description = "Verify user is able to add to the cart and verify the subtotal")
	public void verifyItemsInTheCartAndSubTotal(Method method) throws Exception {
		try {
			ExtentTestManager.startTest(method.getName(),
					"Verify user is able to add to the cart and verify the subtotal.");
			objhomepage = new Homepage(driver);
			home_page_title = objhomepage.verifyHomePageTitle();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified the Home Page Title is " + home_page_title);
			objshoppage = objhomepage.clickOnShopButton();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Shop Button ");
			objshoppage.VerifyItemsAndClickToAddCart(stuffedFrog);
			objshoppage.VerifyItemsAndClickToAddCart(fluffyBunny);
			objshoppage.VerifyItemsAndClickToAddCart(valentineBear);
			objcartpage = objshoppage.clickOnCartButton();
			objcartpage.verifyTheItemsIntheCart();
			FirstSubtotal=objcartpage.verifyTheSubTotal(stuffedFrog,StuffedFrogCount);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The sub total for an item " + stuffedFrog + ", " + FirstSubtotal);
			Secondsubtotal = objcartpage.verifyTheSubTotal(fluffyBunny,FluffyBunnyCount);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The sub total for an item " + fluffyBunny +  ", " +  Secondsubtotal);
			ThirdSubtotal = objcartpage.verifyTheSubTotal(valentineBear,ValentineBearCount);
			ExtentTestManager.getTest().log(LogStatus.PASS, "The sub total for an item " + valentineBear + ", "  + ThirdSubtotal);
			objcartpage.VerifyAndNavigateBack();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Third Test case Executed");

		} catch (Exception e) {
			throw new Exception("Not able to add to the cart and Failed to verify the SubTotal"
					+ e.getLocalizedMessage());
		}

	}
	


}
