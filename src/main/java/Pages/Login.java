package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class is the Login class that contain constructor to initiate driver and  contain sign out method and login to website method 
 */
public class Login extends BasePage  {

	public Login(WebDriver browserobject) {
		super(browserobject);
		// TODO Auto-generated constructor stub
	}

	By signOutButton=By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout=']");
	By logIn_email= By.id("email");
	By logIn_passwrd=By.id("passwd");
	By login_Submit = By.id("SubmitLogin");
	
	
	/**
	 * method (SignOut) this method log out from the website
	 */
	
	public void SignOut() 
	{
		clickButton(browserobject.findElement(signOutButton));

	}
	/**
	 * method (loginTowebsite) login to website store
	 * * contain arguments the( email  and pass)  the user should enter them to login to website
	 */
	
	public void loginTowebsite(String email , String pass)
	{
		setTextElementTextwithoutenter(browserobject.findElement(logIn_email),email);
		setTextElementTextwithoutenter(browserobject.findElement(logIn_passwrd),pass);
		clickButton(browserobject.findElement(login_Submit));
		
		
	}
}
