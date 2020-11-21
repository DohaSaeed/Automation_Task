package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class is the CheckOutProcedure class that contain constructor to initiate driver and  contain checkOutProcedure ,paymentMethod and navigateToHistoryPage
 *  method that make the user check out  and chhse payment method and go to histort page
 */
public class CheckOutProcedure extends BasePage {

	public CheckOutProcedure(WebDriver browserobject) {
		super(browserobject);
		// TODO Auto-generated constructor stub
		jse = (JavascriptExecutor) browserobject; 
	}

	By chekingOut1=By.linkText("Proceed to checkout");
	By chekingOut2=By.linkText("Proceed to checkout");
	By chekingOut3=By.linkText("Proceed to checkout");
	By chekingOut4=By.cssSelector("button.button.btn.btn-default.button-medium");
	By checkButton=By.id("cgv");
	By chekingOut5=By.cssSelector("button.button.btn.btn-default.standard-checkout.button-medium");
	By paymentmethod=By.cssSelector("a.bankwire");
	By confirmedOreder=By.cssSelector("button.button.btn.btn-default.button-medium");
	By backButton=By.linkText("Back to orders");



	/**
	 * method (checkOutProcedure) this method to check out to pay for the product and check out
	 */

	public void checkOutProcedure()
	{

		WebDriverWait wait3=new WebDriverWait(browserobject, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(chekingOut1));
		clickButton(browserobject.findElement(chekingOut1));
		clickButton(browserobject.findElement(chekingOut2));
		scrollToBottom();
		WebDriverWait wait4=new WebDriverWait(browserobject, 12);
		wait4.until(ExpectedConditions.elementToBeClickable(chekingOut4));
		clickButton(browserobject.findElement(chekingOut4));
		clickButton(browserobject.findElement(checkButton));
		scrollToBottom();
		clickButton(browserobject.findElement(chekingOut5));





	}
	/**
	 * method (paymentMethod) this method is to choose pament method any pay for the product
	 */

	public void paymentMethod()
	{

		WebDriverWait wait5=new WebDriverWait(browserobject, 10);
		wait5.until(ExpectedConditions.elementToBeClickable(paymentmethod));
		scrollToBottom();
		clickButton(browserobject.findElement(paymentmethod));
		clickButton(browserobject.findElement(confirmedOreder));

	}

	/**
	 * method (navigateToHistoryPage) this method is to navigate to historypage
	 */

	public void navigateToHistoryPage()
	{
		scrollToBottom();
		clickButton(browserobject.findElement(backButton));

	}



}
