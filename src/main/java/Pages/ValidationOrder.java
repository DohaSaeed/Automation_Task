package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is the ValidationOrder class that contain constructor to initiate driver and  contain gettextOneforAssertion , preparingForValidation  and gettextTwoforAssertion methods
 */
public class ValidationOrder extends BasePage {

	public ValidationOrder(WebDriver browserobject) {
		super(browserobject);
		// TODO Auto-generated constructor stub
	}

	By MoreButton=By.linkText("More");
	By gettext1=By.cssSelector("span.editable");
	By addIcon = By.cssSelector("span.footable-toggle");
	By detailButton = By.linkText("Details");
	By getText2 = By.xpath("//table/tbody/tr/td[1]/label");
	String text1;
	String text2;

	/**
	 * method (gettextOneforAssertion) get the name of the model
	 */
	public String gettextOneforAssertion()
	{
		WebDriverWait wait19=new WebDriverWait(browserobject, 12);
		wait19.until(ExpectedConditions.elementToBeClickable(MoreButton));
		clickButton(browserobject.findElement(MoreButton));
		WebElement obj= browserobject.findElement(gettext1);
		text1=obj.getText();
		System.out.println(obj.getText());
		browserobject.navigate().back();
		return text1;

	}


	/**
	 * method (preparingForValidation) click on add button and details button
	 */
	public void preparingForValidation()
	{
		WebDriverWait wait87=new WebDriverWait(browserobject, 10);
		wait87.until(ExpectedConditions.elementToBeClickable(addIcon));
		clickButton(browserobject.findElement(addIcon));
		clickButton(browserobject.findElement(detailButton));


	}

	/**
	 * method (gettextTwoforAssertion) get name of the model from the history page
	 */
	public String gettextTwoforAssertion()
	{


		WebDriverWait wait6=new WebDriverWait(browserobject, 12);
		wait6.until(ExpectedConditions.elementToBeClickable(getText2));
		WebElement obj2= browserobject.findElement(getText2);
		text2=obj2.getText();
		System.out.println(obj2.getText());  
		return text2;

	}

}
