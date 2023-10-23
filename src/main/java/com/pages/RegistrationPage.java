package com.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

public class RegistrationPage {
	
	private WebDriver rdriver=DriverFactory.getDriver();
	String error="";
	String registration_Url=ConfigReader.registerPage();
	
	
	public RegistrationPage(WebDriver ldriver)
	{
		this.rdriver=ldriver;
		PageFactory.initElements(ldriver,this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Register')]") WebElement rightCorner_Register;
	@FindBy(xpath="//input[@name='username']") WebElement userName;
	@FindBy(xpath="//input[@name='password1']") WebElement password;
	@FindBy(xpath="//input[@name='password2']") WebElement confirmPassword;
	@FindBy(xpath="//input[@value='Register']") WebElement register_Button;
	@FindBy(xpath="//a[contains(text(),'Login')]") WebElement rightCorner_Login;
	@FindBy(xpath="//div[contains(@class,'alert ')]") WebElement pwd_mismatch_errorMsg;
	
	public String  clickRight_CornerRegister()
	{
		rightCorner_Register.click();
		String register_url=rdriver.getCurrentUrl();
		return register_url;
		
	}
	public String clicRight_corner_Login()
	{
		rightCorner_Login.click();
		String login_url=rdriver.getCurrentUrl();
		return login_url;
		
	}
	public String clickRegister_Button()
	{
		register_Button.click();
		return error=userName.getAttribute("validationMessage");
		
	}
	public String clickRegister_Button_AfterPassword()
	{
		register_Button.click();
		return error=password.getAttribute("validationMessage");
	}
	public String clickRegister_Button_After_Confirm_Password()
	{
		register_Button.click();
		return error=confirmPassword.getAttribute("validationMessage");
	}
	public void getRegistration_url()
	{
		rdriver.get(registration_Url);
	}
	public String printError_message()
	{
		 
		System.out.println("error message is "+error);
		return error;
		
	}
	
	public String click_Register_Button_with_UserName(String name)
	{
		userName.sendKeys(name);
		return clickRegister_Button();
		
	}
	public String click_Register_Button_with_Password(String pass)
	{
		password.sendKeys(pass);
		return clickRegister_Button_AfterPassword();
	}
	public String click_Register_Button_with_confirmPwd(String confirmPass)
	{
		confirmPassword.sendKeys(confirmPass);
		return clickRegister_Button();
		
	}
	public String login_Details(String name,String pwd)
	{
		userName.sendKeys(name);
		password.sendKeys(pwd);
		return clickRegister_Button();
		
	}
	public String register_InValid_Credentilas(String uname,String pwd,String confirmPwd)
	{
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		register_Button.click();
		if(pwd_mismatch_errorMsg.isDisplayed())
		{
			error=pwd_mismatch_errorMsg.getText();
		}
		return error;
		
	}
	public SignInPage register_with_Valid_Credentilas(String uname,String pwd,String confirmPwd)
	{
		String s = RandomStringUtils.randomAlphanumeric(5); 
		userName.sendKeys(s+"@Numpyninja");		
		
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		register_Button.click();	
		if(pwd_mismatch_errorMsg.isDisplayed())
		{
			error=pwd_mismatch_errorMsg.getText();
			System.out.println(error);
		}	
		
		
		return new SignInPage(rdriver);
		
		
		
		
	}
	
	
	

}
