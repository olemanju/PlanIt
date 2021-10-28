package com.plan.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.plan.common.HIFIConstants;
import com.plan.util.BasePageObject;

import freemarker.core.ReturnInstruction.Return;

public class Shoppage extends BasePageObject
{
	public Shoppage(WebDriver driver)
	{
		super(driver);
	}
	
	
	private final static Logger LOGGER = Logger.getLogger(Shoppage.class.getName());
	boolean flag = false;
	String pagetitle = null;
	String expected = null;
	String FirstSearch = "Funny Cow";
	String SecondSearch = "Fluffy Bunny";
	String ThridSearch = "Stuffed Frog";
	String FourthSearch = "Valentine Bear";
	 
	
	/*
	 * @author Manjunatha
	 * This method will verify the Title of the Page
	 */
	public String verifyShopPageTitle() throws Exception {
		try {
			pagetitle = getCurrentPageTitle();
			System.out.println("Page Title is ShopPage " + pagetitle);
			Assert.assertEquals(pagetitle, HIFIConstants.CONTACT_TITLE, "Title of the Page is not Matching");
		} catch (Exception e) {

			throw new Exception(
					"FAILED GETING THE HOMEPAGE TITLE  " + "\n verifyHomePageTitle " + e.getLocalizedMessage());
		}
		return pagetitle;
	}
	
	/*
	 * @author Manjunatha
	 * This method will verify cartItem is displayed on the page
	 */
	public boolean isCartItemIsDisplayed(String search) throws Exception {
		try {
			waitForAnElement(ItemIntheCart(search), 30);
			flag = isElementPresent(ItemIntheCart(search));
		} catch (Exception e) {
			throw new Exception("ForName Label is displayed::" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/*
	 * @author Manjunatha
	 * This method pass the Item to be clicked and internally verify's number of times need to be clicked.
	 */
	public void clickOnBuy(String ItemName) throws Exception {
		try {
			waitForAnElement(btnbuy(ItemName), 30);
			if(FirstSearch.contains(ItemName))
			{
				int counter = 1;
				for (int i=1; i<=2; i++)
				{
						click(btnbuy(ItemName));
						if (counter==2)
						{
							break;
						}
				}
			}
			else if(SecondSearch.contains(ItemName))
			{
				
					click(btnbuy(ItemName));
			}
			
		} catch (Exception e) {
			
			throw new Exception("Failed to add items to the Cart" + e.getLocalizedMessage());
		}
	}
	
	
	public void VerifyItemsToThecart(String Search)
	{
		try {
			
			if(ThridSearch.contains(Search))
			{
				isCartItemIsDisplayed(Search);
				clickOnBuySecondTime(Search);
			}
			else if(SecondSearch.contains(Search))
			{
				isCartItemIsDisplayed(Search);
				clickOnBuySecondTime(Search);
			}
			else
			{
				isCartItemIsDisplayed(Search);
				clickOnBuySecondTime(Search);
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	/*
	 * @author Manjunatha
	 * This method pass the Item to be clicked and internally verify's number of times need to be clicked.
	 */
	public void clickOnBuySecondTime(String ItemName) throws Exception {
		try {
			waitForAnElement(btnbuy(ItemName), 30);
			if(ThridSearch.contains(ItemName))
			{
				int counter = 1;
				for (int i=1; i<=2; i++)
				{
						click(btnbuy(ItemName));
						if (counter==2)
						{
							break;
						}
				}
			}
			else if(SecondSearch.contains(ItemName))
			{
				
				int counter = 1;
				for (int i=1; i<=5; i++)
				{
						click(btnbuy(ItemName));
						if (counter==5)
						{
							break;
						}
				}
			}
			else
			{
				int counter = 1;
				for (int i=1; i<=3; i++)
				{
						click(btnbuy(ItemName));
						if (counter==3)
						{
							break;
						}
				}
			}
			
		} catch (Exception e) {
			
			throw new Exception("Failed to add items to the Cart" + e.getLocalizedMessage());
		}
	}
	
	/*
	 * @author Manjunatha
	 * This method pass the Item to be added to the card and it will be added.
	 */
	
	public void VerifyItemsAndClickToAddCart(String Search)
	{
		try {
			
			if(ThridSearch.contains(Search))
			{
				isCartItemIsDisplayed(Search);
				clickOnBuySecondTime(Search);
			}
			else if(SecondSearch.contains(Search))
			{
				isCartItemIsDisplayed(Search);
				clickOnBuySecondTime(Search);
			}
			else
			{
				isCartItemIsDisplayed(Search);
				clickOnBuySecondTime(Search);
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
	/**
	 * @author Manjunath Ole
	 * @return
	 * @throws 
	 */
	public Cartpage clickOnCartButton() throws Exception {

		try {
			isElementDisplayedAndEnabled(btnCart, 10);
			click(btnCart);
		} catch (Exception e) {
			javaScriptClick(btnCart);
			throw new Exception("FAILED CLICKING ON SHOP Button " + clickOnCartButton() + e.getLocalizedMessage());
		}
		return new Cartpage(driver);
	}
	
	//Locators
	private By btnbuy(String item) { return By.xpath("//h4[normalize-space()='"+ item +"']//following-sibling::p/a");}
	private By ItemIntheCart(String parent) { return By.xpath("//h4[normalize-space()='"+ parent +"']/parent::*");}
	private By btnCart = By.xpath("//a[@href='#/cart']");
	
	
	
	
	


	
	//private By //h4[normalize-space()='Funny Cow']//following-sibling::p/a
}
