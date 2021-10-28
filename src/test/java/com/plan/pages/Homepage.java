package com.plan.pages;

import javax.swing.tree.ExpandVetoException;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.plan.common.HIFIConstants;
import com.plan.util.BasePageObject;

public class Homepage extends BasePageObject {
	public Homepage(WebDriver driver) {
		super(driver);
	}

	private final static Logger LOGGER = Logger.getLogger(Homepage.class.getName());

	// Page Object Model- Stored all the page related objects
	boolean flag = false;
	
	String pagetitle = null;

	/**
	 * @author Manjunath Ole
	 * @return
	 * @throws Exception Gets the Title of the page
	 */

	public String verifyHomePageTitle() throws Exception {
		try {
			pagetitle = driver.getTitle().trim();
			System.out.println("Page Title is " + pagetitle);
			Assert.assertEquals(pagetitle, HIFIConstants.HOME_TITLE, "Title of the Page is not Matching");
		} catch (Exception e) {

			throw new Exception(
					"FAILED GETING THE HOMEPAGE TITLE  " + "\n verifyHomePageTitle " + e.getLocalizedMessage());
		}
		return pagetitle;
	}


	/**
	 * @author Manjunath Ole
	 * @return
	 * @throws 
	 */
	public Contactpage clickOnContactButton() throws Exception {

		try {
			isElementDisplayedAndEnabled(lnkHomeButton, 10);
			isElementDisplayedAndEnabled(lnkContact, 10);
			click(lnkContact);
		} catch (Exception e) {
			javaScriptClick(lnkContact);
			throw new Exception("FAILED CLICKING ON Contact Button " + clickOnContactButton() + e.getLocalizedMessage());
		}
		return new Contactpage(driver);
	}
	

	/**
	 * @author Manjunath Ole
	 * @return
	 * @throws 
	 */
	public Shoppage clickOnShopButton() throws Exception {

		try {
			isElementDisplayedAndEnabled(lnkHomeButton, 10);
			isElementDisplayedAndEnabled(lnkShop, 10);
			click(lnkShop);
		} catch (Exception e) {
			javaScriptClick(lnkShop);
			throw new Exception("FAILED CLICKING ON Shop Button " + clickOnContactButton() + e.getLocalizedMessage());
		}
		return new Shoppage(driver);
	}
	
	
	//Element Locators
	
	private By lnkHomeButton = By.partialLinkText("Home");
	private By lnkContact = By.cssSelector("a[href='#/contact']");
	private By lnkShop = By.cssSelector("a[href='#/shop']");
	

}
