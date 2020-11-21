package Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import Data.ExcelReader;
import Data.ExcelReaderLogin;
import Pages.CheckOutProcedure;
import Pages.CreateUser;
import Pages.SelectionPage;
import Pages.ValidationOrder;
import Pages.Login;


/**
 * This class is the OrderTest class extends from  BaseTest class it contain the  test scenerio and data provider 
 */
public class OrderTest extends BaseTest {
	CreateUser testCreateUser ;
	SelectionPage testSelection ;
	CheckOutProcedure testChekOut;
	ValidationOrder testVlidation ;
	String Model1;
	String Model2;
	Login signOut1;


	/**
	 *  userRegisterData method contain Data provider that get data from Excel Reader class
	 *  @return    Data in excel sheet in 2D array 
	 * 
	 */

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();

		return ER.getExcelData();
	}


	/**
	 * method  (createUserAccountTest) is the method that create account user
	 *  contain an  argument URL  , Data that will filled in account page
	 * @param  URL the url that will navigate to 
	 * @param  Data that will filled in account page
	 */
	@Test(dataProvider="ExcelData",priority=1)
	public void createUserAccountTest(String Url,String emial , String firstName ,String lastName , String paswword , String emailacc  ,String companyy , String firstadres , String secndadres ,String citieSS  , String otherSS ,  String aliaSS)
	{
		test = extent.startTest("Log Steps Statuts");
		browserobject.navigate().to(Url);
		test.log(LogStatus.PASS,"Browser is Opened now Successfully");
		testCreateUser = new CreateUser (browserobject);
		testCreateUser.RegisterToSite();
		test.log(LogStatus.PASS,"User Clicked on login button Successfully");
		testCreateUser.createAccount(emial , firstName , lastName ,  paswword ,  emailacc ,companyy , firstadres , secndadres , citieSS ,   otherSS , aliaSS);
		test.log(LogStatus.PASS,"The data found in excel sheet is typed successfully");
		

	}
	
	@DataProvider(name="ExcelDataLogin")
	public Object[][] userRegisterDataLogin() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReaderLogin ER1 = new ExcelReaderLogin();

		return ER1.getExcelData();
	}

	/**
	 * method  (SignOutFromwebsite) is the method that use can signout after registeration and the login again 
	 */
	@Test(dataProvider="ExcelDataLogin",priority=2)
	public void SignOutFromwebsite(String emaill, String passw)
	{
		signOut1= new Login(browserobject);
		signOut1.SignOut();
		signOut1.loginTowebsite(emaill , passw);
		
	}

	/**
	 * method  (SelectionOfCategoryTest) is the method that enable user to choose product
	 */
	@Test(priority=2)
	public void SelectionOfCategoryTest()
	{
		testSelection = new SelectionPage(browserobject);
		testVlidation = new ValidationOrder(browserobject);
		testSelection.selectiontOfGender();
		test.log(LogStatus.PASS,"Select gender Successfully");
		testSelection.selectiontOfCategory();
		test.log(LogStatus.PASS,"Selction of blouse category successfully");
		Model1= testVlidation.gettextOneforAssertion();
		test.log(LogStatus.PASS,"Get name of Model Successfully");
		testSelection.addProductToCart();
		test.log(LogStatus.PASS,"Add the product to Cart Successfully");

	}

	/**
	 * method  (checkOutTest) is the method that enable user to check out and pay for the  product 
	 */
	@Test(priority=3)
	public void checkOutTest()
	{
		testChekOut =  new CheckOutProcedure(browserobject);
		testChekOut.checkOutProcedure();
		test.log(LogStatus.PASS,"proccess of check out is done successfully ");
		testChekOut.paymentMethod();
		test.log(LogStatus.PASS,"payment method is done successfully");
		testChekOut.navigateToHistoryPage();
		test.log(LogStatus.PASS,"Navigation to history page succesfully");

	}

	/**
	 * method  (validationOrderTest) is the method that  validate that order found in history page
	 */
	@Test(priority=4)
	public void validationOrderTest()
	{
		testVlidation = new ValidationOrder(browserobject);
		testVlidation.preparingForValidation();
		test.log(LogStatus.PASS,"press on details button ucssesfully");
		Model2=testVlidation.gettextTwoforAssertion();
		Assert.assertEquals(Model1, Model2);
		test.log(LogStatus.PASS,"Validation of name of model that found in history page successfully");




	}

}
