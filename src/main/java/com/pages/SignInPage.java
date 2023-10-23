package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;

public class SignInPage {
private WebDriver driver=DriverFactory.getDriver();
private HomePage homePage=new HomePage(driver);
	public SignInPage(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(ldriver,this);
			
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]") private WebElement sign_In;
	@FindBy(xpath="//a[contains(text(),' Register ')]") private WebElement right_corner_register_;
	@FindBy(xpath="//input[@name='username']") private WebElement user_Name;
	@FindBy(xpath="//input[@name='password']") private WebElement user_Password;
	@FindBy(xpath="//input[@value='Login']") private WebElement login_button;
	@FindBy(xpath="//a[contains(text(),'Register!')]")private  WebElement center_Register_Button;
	@FindBy(xpath="//div[@role='alert']")private  WebElement invalid_Alert_msg;
	@FindBy(xpath="//a[contains(text(),'NumpyNinja')]")private  WebElement left_corner_numpy_Ninja;
	@FindBy(xpath="//a[contains(text(),'Data Structures')]")private  WebElement dataStructure_DropDown;
	@FindBy(xpath="//div[@role='alert']")private WebElement success_Alert_msg;
	@FindBy(xpath="//a[contains(text(),'Sign out')]")private  WebElement sign_Out;
	@FindBy(xpath="//div[@role='alert']")private  WebElement logout_Alert_msg;
	
	
	
	public void click_Sign_In()
	{
		sign_In.click();
		
	}
	public String click_Login_with_Empty_Fields()
	{
		login_button.click();
		String error=user_Name.getAttribute("validationMessage");
		return error;
		
		
	}
	public String click_Login_with_invalid_credentils(String uname,String pwd)
	{
		user_Name.sendKeys(uname);
		user_Password.sendKeys(pwd);
		login_button.click();
		String error1=invalid_Alert_msg.getText();
		return error1;
	}
	public String click_Login_with_Valid_Credentils(String uname,String pwd)
	{
		user_Name.sendKeys(uname);
		user_Password.sendKeys(pwd);
		login_button.click();
		String success=success_Alert_msg.getText();
		return success;
		
	}
	public void click_Logout()
	{
		sign_Out.click();
		
	}
	public String click_Successfull_Logout()
	{
		sign_Out.click();
		String logout_Msg=logout_Alert_msg.getText();
		return logout_Msg;
		
	}
	public String click_login_with_UserName_only(String uname)
	{
		user_Name.sendKeys(uname);
		String error=user_Password.getAttribute("validationMessage");
		return error;
		
	}
	public String click_login_with_password_Only(String pwd)
	{
		
		user_Password.sendKeys(pwd);
		String error=user_Name.getAttribute("validationMessage");
		return error;
	}

}
