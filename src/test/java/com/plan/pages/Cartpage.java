package com.plan.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.plan.common.HIFIConstants;
import com.plan.util.BasePageObject;

public class Cartpage  extends BasePageObject
{
	public Cartpage(WebDriver driver)
	{
		super(driver);
	}
	
	private final static Logger LOGGER = Logger.getLogger(Contactpage.class.getName());
	boolean flag = false;
	String pagetitle = null;
	String expected = null;
	String SecondSearch = "Fluffy Bunny";
	String ThridSearch = "Stuffed Frog";
	String FourthSearch = "Valentine Bear";
	
	/*
	 * First verifies the Elelment and Clicks on it. 
	 * 
	 */
	String part = null;
	public String verifyTheItemsIntheCart() throws Exception {
		try {
			
			//It will fetch the cart gettext and extract the number and stored in part
			isElementPresent(btnCart);
			expected = getText(btnCart);
			System.out.println(expected);
			part = expected.substring(6,7);
			System.out.println(part);
			
			//After adding to the cart, in the cart Page Message.
			//Items will display and Top it wil show a text message with number of items in the cart
			isElementPresent(lblcartMessage);
			String Cart = getText(lblcartMessage);
			System.out.println(Cart);
			String[] counts = Cart.split(" ");
			String count = counts[2];
			System.out.println(count);
			//Comparing both of them
			if(part.equals(count))
			{
				System.out.println("Items in the cart are matching");
			}
			else
			{
				System.out.println("Items in the cart are Not matching");
			}
			
		} catch (Exception e) {

			throw new Exception(
					"FAILED Compare the Total bumber of Items in the cart  " + "\n verifyTheItemsIntheCart " + e.getLocalizedMessage());
		}
		return part;
	}
	
	/*
	 * @author Manjunatha
	 * This methos will Needs 2 parameter @first param string value to locate the element 
	 * and @second param Count to compare with the actual extarcted value.
	 */
	
	String total = null;
	public String verifyTheSubTotal(String parent, String count) throws Exception {
		try {
			
			isElementPresent(valSubTotal(parent));
			expected = getText(valSubTotal(parent));
			System.out.println(expected);
			total = expected.substring(1);
			System.out.println(part);
			
			if (ThridSearch.contains(parent)){
				if(total.equals(count)){
				System.out.println("Items in the cart are matching");
				}
				else{
				System.out.println("Items in the cart are Not matching");
				}
			}
			else if (SecondSearch.contains(parent)){
				if(total.equals(count)){
					System.out.println("Items in the cart are matching");
				}
				else{
					System.out.println("Items in the cart are Not matching");
				}
			}
			else
			{
				if(total.equals(count)){
					System.out.println("Items in the cart are matching");
				}
				else{
					System.out.println("Items in the cart are Not matching");
				}
			}
		} catch (Exception e) {

			throw new Exception(
					"FAILED Sum the Total  " + "\n verifyTheSubTotal " + e.getLocalizedMessage());
		}
		return total;
	}
	
	
	/*
	 * @author Manjunatha
	 * This method will Clear the Cart
	 */
	public void clickOnEmptyCart() throws Exception {
		try {
			waitForAnElement(btnEmptycart, 30);
			click(btnEmptycart);
		} catch (Exception e) {
			throw new Exception("Empty Button is displayed and clicked::"  + e.getLocalizedMessage());
		}
	}
	
	
	/*
	 * @author Manjunatha
	 * This method will click on the Yes Message in the Pop up screen to clear the Cart.
	 */
	public void clickOnYes() throws Exception {
		try {
			waitForAnElement(btnYes, 30);
			click(btnYes);
		} catch (Exception e) {
			throw new Exception("Yes Button is displayed and clicked::"  + e.getLocalizedMessage());
		}
	}
	

	/*
	 * @author Manjunatha
	 * This method will click on the Continue button to start fresh shopping.
	 */
	public void clickOnContinueshopping() throws Exception {
		try {
			waitForAnElement(btnstartShopping, 30);
			click(btnstartShopping);
		} catch (Exception e) {
			throw new Exception("Continue shopping Button is displayed and clicked::"  + e.getLocalizedMessage());
		}
	}
	
	
	/*
	 * @author Manjunatha
	 * This method will take user to  cart screen to shopping page
	 */
	public void VerifyAndNavigateBack()
	{
		try {
			clickOnEmptyCart();
			clickOnYes();
			clickOnContinueshopping();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Locators
	private By lblcartMessage = By.xpath("//p[@class='cart-msg']");
	private By tbRowsCount = By.xpath("//tbody/tr/td[3]/input[1]");
	private By btnCart = By.xpath("//a[@href='#/cart']");
	private By btnEmptycart = By.xpath("//a[normalize-space()='Empty Cart']");
	private By btnYes = By.xpath("//a[normalize-space()='Yes']");
	private By btnstartShopping = By.xpath("//a[contains(text(),'Start Shopping »')]");
	
	private By btnbuy(String item) { return By.xpath("//h4[normalize-space()='"+ item +"']//following-sibling::p/a");}
	private By valSubTotal(String parent) { return By.xpath("//tr/td[normalize-space()='"+ parent +"']/following-sibling::td[3]");}
	
	
}
