package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUser extends BasePage {

	
	/**
	 * This class is the createuser class that contain constructor to initiate driver and  contain register and create account methods 
	 */
	public CreateUser(WebDriver browserobject) {
		super(browserobject);

	}

	By loginButton=By.className("login");
	By createAccount=By.id("email_create");
	By radiobutton=By.id("id_gender2");
	By firstNme=By.id("customer_firstname");
	By lastName=By.id("customer_lastname");
	By passwrd=By.id("passwd");
	By emil=By.id("email");
	By days=By.id("days");
	By mnonths=By.id("months");
	By years=By.id("years");
	By company=By.id("company");
	By firstAdrees=By.id("address1");
	By secondAddress=By.id("address2");
	By cities=By.id("city");
	By states=By.id("id_state");
	By postCode=By.id("postcode");
	By countries=By.id("id_country");
	By othres=By.id("other");
	By homePhone=By.id("phone");
	By mobilePhone=By.id("phone_mobile");
	By aliass=By.id("alias");
	By submitButton=By.id("submitAccount");

	/**
	 * method (RegisterToSite) clock on login to go the page to create an account 
	 */
	public void RegisterToSite() 
	{
		clickButton(browserobject.findElement(loginButton));

	}

	/**
	 * method (createAccount) create account for a new user to enter website 
	 * * contain arguments the data of user that he should enter in account page
	 */
	public void createAccount(String account , String Firstname ,String Lastname , String passowrdd , String emailacc ,String companyy , String firstaddress , String secondAdress ,String citieS, String otherS , String aliaAs )
	{

	
		setTextElementText(browserobject.findElement(createAccount),account);



		WebDriverWait wait=new WebDriverWait(browserobject, 10);
		wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
		clickButton(browserobject.findElement(radiobutton));
		setTextElementTextwithoutenter(browserobject.findElement(firstNme),Firstname);
		setTextElementTextwithoutenter(browserobject.findElement(lastName),Lastname);
		setTextElementTextwithoutenter(browserobject.findElement(passwrd),passowrdd);
		browserobject.findElement(emil).clear();
		setTextElementTextwithoutenter(browserobject.findElement(emil),emailacc);
		Select dayss = new Select(browserobject.findElement(days));
		dayss.selectByValue("17");
		Select monthss = new Select(browserobject.findElement(mnonths));
		monthss.selectByValue("11");
		Select yearss = new Select(browserobject.findElement(years));
		yearss.selectByValue("1997");
		setTextElementTextwithoutenter(browserobject.findElement(company),companyy);
		setTextElementTextwithoutenter(browserobject.findElement(firstAdrees),firstaddress);
		setTextElementTextwithoutenter(browserobject.findElement(secondAddress),secondAdress);
		setTextElementTextwithoutenter(browserobject.findElement(cities),citieS);
		Select statee = new Select(browserobject.findElement(states));
		statee.selectByValue("43");
		setTextElementTextwithoutenter(browserobject.findElement(postCode),"41523");
		Select country = new Select(browserobject.findElement(countries));
		country.selectByValue("21");
		setTextElementTextwithoutenter(browserobject.findElement(othres),otherS);
		setTextElementTextwithoutenter(browserobject.findElement(homePhone),"224526482");
		setTextElementTextwithoutenter(browserobject.findElement(mobilePhone),"01060471410");
		setTextElementTextwithoutenter(browserobject.findElement(aliass),aliaAs);
		clickButton(browserobject.findElement(submitButton));


	}


}
