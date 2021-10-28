package com.plan.pages;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.plan.common.HIFIConstants;
import com.plan.util.BasePageObject;

public class Contactpage extends BasePageObject {
	public Contactpage(WebDriver driver) {
		super(driver);
	}

	private final static Logger LOGGER = Logger.getLogger(Contactpage.class.getName());
	boolean flag = false;
	String pagetitle = null;
	String expected = null;
	String Message = "we appreciate your feedback.";

	/*
	 * @author Manjunatha r
	 */
	public String verifyConatctPageTitle() throws Exception {
		try {
			pagetitle = getCurrentPageTitle();
			System.out.println("Page Title is Conatct " + pagetitle);
			Assert.assertEquals(pagetitle, HIFIConstants.CONTACT_TITLE, "Title of the Page is not Matching");
		} catch (Exception e) {

			throw new Exception(
					"FAILED GETING THE  TITLE  " + "\n verifyConatctPageTitle " + e.getLocalizedMessage());
		}
		return pagetitle;
	}

	
	/*
	 * @author Manjunatha
	 * This method will Compare the Welcome text 
	 */
	public String verifyAndCompareWelcomeText() throws Exception {
		try {
			expected = getText(lblWelcomeMessage);
			Assert.assertEquals(expected, HIFIConstants.WELCOME_TEXT, "Compare isnot matching");
		} catch (Exception e) {

			throw new Exception("FAILED COMPARE  " + "\n verifyAndCompareWelcomeText " + e.getLocalizedMessage());
		}
		return expected;
	}


	/*
	 * @author Manjunatha
	 * This method will Compare Error Message for welcome
	 */
	public String verifyWelcomeTextErrorMessageAndCompare() throws Exception {
		try {
			expected = getText(lblWelcome_ErrorMessage);
			Assert.assertEquals(expected, HIFIConstants.WELCOME_ERROR, "Error Message is not Matching");
		} catch (Exception e) {

			throw new Exception(
					"FAILED COMPARE " + "\n verifyWelcomeTextErrorMessageAndCompare " + e.getLocalizedMessage());
		}
		return expected;
	}

	/*
	 * @author Manjunatha
	 * This method will Verify the forname label is displayed
	 */
	public boolean isFornameLabelDisplayed() throws Exception {
		try {
			waitForAnElement(lblForename, 30);
			flag = isElementPresent(lblForename);
		} catch (Exception e) {
			throw new Exception("ForName Label is displayed::" + isFornameLabelDisplayed() + e.getLocalizedMessage());
		}
		return flag;
	}

	
	/*
	 * @author Manjunatha
	 * This method will Verify the forname textbox is displayed
	 */
	public boolean isFornameTextBoxDisplayed() throws Exception {
		try {
			waitForAnElement(txtForme, 30);
			flag = isElementPresent(txtForme);
		} catch (Exception e) {
			throw new Exception(
					"ForName textBox is displayed::" + isFornameTextBoxDisplayed() + e.getLocalizedMessage());
		}
		return flag;
	}

	
	/*
	 * @author Manjunatha
	 * This method will Compare the Forname Error Message
	 */
	public String verifyForNameErrorAndCompare() throws Exception {
		try {

			isElementPresent(errForname);
			expected = getText(errForname);
			Assert.assertEquals(expected, HIFIConstants.FORNAME_ERROR, "Error Message is not Matching");
		} catch (Exception e) {

			throw new Exception("FAILED GETING THE Forname Error Message  " + "\n verifyForNameErrorAndCompare "
					+ e.getLocalizedMessage());
		}
		return expected;
	}

	/*
	 * @author Manjunatha
	 * This method verify the submit button 
	 */
	public boolean isSubmitButtonisplayed() throws Exception {
		try {
			waitForAnElement(btnSubmit, 30);
			flag = isElementPresent(btnSubmit);
		} catch (Exception e) {
			throw new Exception("Submit Button is displayed::" + isSubmitButtonisplayed() + e.getLocalizedMessage());
		}
		return flag;
	}

	/*
	 * @author Manjunatha
	 * This method will Verify the Email error Message
	 */
	public String verifyEmailErrorAndCompare() throws Exception {
		try {
			isElementPresent(errEmail);
			expected = getText(errEmail);
			Assert.assertEquals(expected, HIFIConstants.EMAIL_ERROR, "Email Error Message is not Matching");
		} catch (Exception e) {

			throw new Exception("FAILED GETING THE Email Error Message  " + "\n verifyEmailErrorAndCompare "
					+ e.getLocalizedMessage());
		}
		return expected;
	}
	
	/*
	 * @author Manjunatha
	 * This method will Compare the Email Message
	 */

	public String verifyYourEmailTextAndCompare() throws Exception {
		try {
			isElementPresent(lblYourEmailMessage);
			expected = getText(lblYourEmailMessage);
			Assert.assertEquals(expected, HIFIConstants.YOUR_EMAIL, "Email text is not Matching");
		} catch (Exception e) {

			throw new Exception("FAILED compare THE Email  Message  " + "\n verifyYourEmailTextAndCompare "
					+ e.getLocalizedMessage());
		}
		return expected;
	}

	/*
	 * @author Manjunatha
	 * This method will Compare the Email  Message
	 */
	public String verifyWeNeverEmailTextAndCompare() throws Exception {
		try {
			isElementPresent(lblSpamErroMessage);
			expected = getText(lblSpamErroMessage);
			Assert.assertEquals(expected, HIFIConstants.WE_NEVER, "Error Message is not Matching");
		} catch (Exception e) {

			throw new Exception("FAILED compare THE Email Error Message  " + "\n verifyWeNeverEmailTextAndCompare "
					+ e.getLocalizedMessage());
		}
		return expected;
	}

	/*
	 * @author Manjunatha
	 * This method will Compare the Telephone  Message
	 */
	public String verifyTeleMessageAndCompare() throws Exception {
		try {
			isElementPresent(lbltelephoneMessage);
			expected = getText(lbltelephoneMessage);
			Assert.assertEquals(expected, HIFIConstants.TELE_MESSAGE, "Error Message is not Matching");
		} catch (Exception e) {

			throw new Exception("FAILED compare THE Telephone Error Message  " + "\n verifyTeleMessageAndCompare "
					+ e.getLocalizedMessage());
		}
		return expected;
	}

	/*
	 * @author Manjunatha
	 * This method will Compare the Message Text Error Message
	 */
	public String verifyMessageErrorAndCompare() throws Exception {
		try {
			isElementPresent(errMessage);
			expected = getText(errMessage);
			Assert.assertEquals(expected, HIFIConstants.MESSAGE_ERROR, "Error Message is not Matching");
		} catch (Exception e) {

			throw new Exception("FAILED GETING THE Message Error Message  " + "\n verifyMessageErrorAndCompare "
					+ e.getLocalizedMessage());
		}
		return expected;
	}


	/*
	 * @author Manjunatha
	 * This method will verify the Success Message and checks the forname is present in the Message
	 */
	public String verifySuccessmessage(String forname) throws Exception {
		try {

			// Gets the Total Success Message
			expected = getText(lblAlertSuccess);
			System.out.println(expected);
			StringTokenizer StringTokenizer = new StringTokenizer(expected, ",", true);
			String beforeComma = "", afterComma = "", lastPart = "";
			beforeComma = StringTokenizer.nextToken();
			System.out.println(beforeComma);
			afterComma = StringTokenizer.nextToken();
			System.out.println(afterComma);
			lastPart = (String) StringTokenizer.nextElement();
			System.out.println(lastPart);

			// Splited and comparing Message has Forname
			if (beforeComma.substring(7).equals(forname) && lastPart.contains(Message)) {
				System.out.println("Thanks " + forname
						+ " and we appreciate your feedback is displayed Properly in the Success message");
			} else {
				System.out.println("There is wrong in the Message");
			}

		} catch (Exception e) {

			throw new Exception(
					"FAILED Verifying THE Welcome  Message  " + "\n verifySuccessmessage " + e.getLocalizedMessage());
		}
		return expected;
	}

	/*
	 * public boolean isWelcomeErrormesageDisplayed() throws Exception { try {
	 * waitForAnElement(btnSubmit, 30); flag = isElementPresent(btnSubmit); } catch
	 * (Exception e) { throw new Exception("Submit Button is displayed::" +
	 * isWelcomeErrormesageDisplayed() + e.getLocalizedMessage()); } return flag; }
	 */

	public void clickOnSubmit() throws Exception {
		try {
			waitForAnElement(btnSubmit, 30);
			click(btnSubmit);
		} catch (Exception e) {
			throw new Exception("Submit Button is displayed::" + e.getLocalizedMessage());
		}
	}

	/*
	 * This method will Verify all the Elements on the contact page and It also
	 * verify the Error Messages.
	 * 
	 */
	public void verifyAllTheErrorMessage() {
		try {
			verifyAndCompareWelcomeText();
			clickOnSubmit();
			verifyWelcomeTextErrorMessageAndCompare();
			isFornameLabelDisplayed();
			isFornameTextBoxDisplayed();
			verifyForNameErrorAndCompare();
			isElementPresent(lblSurname);
			isElementPresent(txtsurname);
			isElementPresent(lblEmail);
			isElementDisplayedAndEnabled(txtEmail, 10);
			verifyEmailErrorAndCompare();
			isElementPresent(lblTelephone);
			isElementPresent(txtTelephone);
			isElementPresent(lblMessage);
			isElementDisplayedAndEnabled(txtMessage, 10);
			verifyMessageErrorAndCompare();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This method will Verify all the Elements on the contact page and It also
	 * Enters all the values and clicks on Submit and verifes the Success Message
	 * 
	 */
	public void VerifyTheSuccessMessage(String forme, String surname, String email, String phoneNumber,
			String message) {
		try {
			browserRefresh();
			verifyAndCompareWelcomeText();
			isFornameLabelDisplayed();
			isFornameTextBoxDisplayed();
			clearEnterText(txtForme, forme);
			isElementPresent(lblSurname);
			isElementPresent(txtsurname);
			clearEnterText(txtsurname, surname);
			isElementPresent(lblEmail);
			isElementDisplayedAndEnabled(txtEmail, 10);
			clearEnterText(txtEmail, email);
			isElementPresent(lblTelephone);
			isElementPresent(txtTelephone);
			clearEnterText(txtEmail, email);
			isElementPresent(lblTelephone);
			isElementPresent(txtTelephone);
			clearEnterText(txtMessage, phoneNumber);
			isElementPresent(lblMessage);
			isElementDisplayedAndEnabled(txtMessage, 10);
			clearEnterText(txtMessage, message);
			clickOnSubmit();
			isElementNotPresent(popupLoader);
			isElementPresent(lblAlertSuccess);
			verifySuccessmessage(forme);
			click(btnBack);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Element Locators

	private By lblForename = By.cssSelector("label[for='forename']");
	private By txtForme = By.id("forename");
	private By errForname = By.xpath("//span[@id='forename-err']");
	private By lblSurname = By.xpath("//label[contains(text(),'Surname')]");
	private By txtsurname = By.id("surname");
	private By lblEmail = By.xpath("//label[@for='email']");
	private By txtEmail = By.id("email");
	private By errEmail = By.xpath("//span[@id='email-err']");
	private By lblYourEmailMessage = By.xpath("//span[contains(text(),'Your email')]");
	private By lblSpamErroMessage = By.xpath("//span[contains(text(),'We')]");
	private By lblTelephone = By.xpath("//label[normalize-space()='Telephone']");
	private By txtTelephone = By.id("telephone");
	private By lbltelephoneMessage = By.xpath("//span[contains(text(),'Only')]");
	private By lblMessage = By.xpath("//label[@for='message']");
	private By txtMessage = By.id("message");
	private By errMessage = By.id("message-err");
	private By btnSubmit = By.xpath("//a[normalize-space()='Submit']");
	private By btn_logout_link = By.linkText("Logout");
	private By lblWelcomeMessage = By.xpath("//div[@class='alert alert-info ng-scope']");
	private By lblWelcome_ErrorMessage = By.xpath("//div[@class='alert alert-error ng-scope']");
	private By lblAlertSuccess = By.xpath("//div[@class='alert alert-success']");
	private By btnBack = By.cssSelector("a[class='btn']");
	private By popupLoader = By.xpath("//div[@class='popup modal hide ng-scope in']");

}
