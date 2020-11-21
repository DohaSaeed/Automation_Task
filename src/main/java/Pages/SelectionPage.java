package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class is the selection class that contain constructor to initiate driver and  contain selectiontOfGender ,selectiontOfCategory  and addProductToCartmethods
 * that help user to choose product
 */
public class SelectionPage extends BasePage {

	public SelectionPage(WebDriver browserobject) {
		super(browserobject);
		jse = (JavascriptExecutor) browserobject; 
	}
	By womenCategory=By.linkText("Women");
	By tops=By.className("img");
	By blouseCategory=By.linkText("Blouses");
	By addingCart=By.linkText("Add to cart");

	/**
	 * method (selectiontOfGender)make user choose women or men category
	 */
	public void selectiontOfGender()
	{
		scrollToUp();
		WebDriverWait wait2=new WebDriverWait(browserobject, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(womenCategory));
		clickButton(browserobject.findElement(womenCategory));


	}

	/**
	 * method (selectiontOfCategory)make user after choosing women category choose blouse which is sub category
	 */
	public void selectiontOfCategory()
	{
		scrollToBottom();
		WebDriverWait wait148=new WebDriverWait(browserobject, 10);
		wait148.until(ExpectedConditions.elementToBeClickable(tops));
		clickButton(browserobject.findElement(tops));
		scrollToBottom();
		WebDriverWait wait147=new WebDriverWait(browserobject, 10);
		wait147.until(ExpectedConditions.elementToBeClickable(blouseCategory));
		clickButton(browserobject.findElement(blouseCategory));
	}

	/**
	 * method (addProductToCart)make user add the product to the cart 
	 */

	public void addProductToCart()
	{
		scrollToBottom();
		clickButton(browserobject.findElement(addingCart));

	}

}
