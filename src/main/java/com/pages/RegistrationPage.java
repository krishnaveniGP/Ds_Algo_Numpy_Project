package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver rdriver;
	public RegistrationPage(WebDriver ldriver)
	{
		this.rdriver=ldriver;
		PageFactory.initElements(ldriver,this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Register')]") WebElement Registration;
	@FindBy(xpath="//input[@name='username']") WebElement userName;
	@FindBy(xpath="//input[@name='password1']") WebElement password;
	@FindBy(xpath="//input[@name='password2']") WebElement confirmPassword;
	@FindBy(xpath="//input[@value='Register']") WebElement Register;
	@FindBy(xpath="//a[contains(text(),'Login')]") WebElement login;
	
	public void clickRegistarion()
	{
		Registration.click();
		
	}
	public void getRegistrationTitle()
	{
		Registration.getText();
	}
	public void sendUserName(String name)
	{
		userName.sendKeys(name);
		
	}
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void confirmPassword(String confirmPass)
	{
		confirmPassword.sendKeys(confirmPass);
		
	}
	public void registerCredentilas(String uname,String pwd,String confirmPwd)
	{
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		
	}
	public void clickRegister()
	{
		Register.click();
	}
	public void clickLogin()
	{
		login.click();
	}

}
