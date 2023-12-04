package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ConfigReader;
import com.utilities.PageUtils;

public class DataStructuresPage 
{
WebDriver rdriver;
PageUtils pageUtil=new PageUtils();
String homePage_url=ConfigReader.homePage();
Alert alert;
String alert_msg;

	public DataStructuresPage(WebDriver ldriver)
	{
		this.rdriver=ldriver;		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Time Complexity')]") WebElement time_Complixity;
	@FindBy(xpath="//a[contains(text(),'Try here>>>')]") WebElement try_Here;
	@FindBy(xpath="//div[@class='CodeMirror-scroll']") WebElement pyhthon_code_textEditer;
	@FindBy(xpath="//button[@type='button']") WebElement run_button;
//	@FindBy(xpath="") WebElement a;
//	@FindBy(xpath="") WebElement a;
//	@FindBy(xpath="") WebElement a;

	public String get_title()
	{
		String title=rdriver.getTitle();
		return title;
		
	}
	public String click_Time_Complexity()
	{
		pageUtil.scrolldown(rdriver);
		time_Complixity.click();
		String DataStructure_title=rdriver.getTitle();
		return DataStructure_title;
		
		
	}
	public String click_try_Here()
	{
		pageUtil.scrolldown(rdriver);
		try_Here.click();
		String try_Here_Title=rdriver.getTitle();
		return try_Here_Title;
		
	}
	public void send_Python_code(String pythonCode)
	{
		pyhthon_code_textEditer.sendKeys(pythonCode);
		
		
	}
	public void click_Run_Button()
	{
		pageUtil.explicit_wait(rdriver,run_button);
		run_button.click();
		rdriver.navigate().to(homePage_url);
		
	}
	public String handling_Alert() throws InterruptedException
	{
		pageUtil.explicit_wait(rdriver,run_button);
		run_button.click();
		
		String alertMsg=Is_AlertPresent();
		System.out.println("alert message is "+alertMsg);
		//rdriver.navigate().to(homePage_url);
		return alertMsg;
		
	}
	
	
	public String Is_AlertPresent() throws InterruptedException
	{
		boolean flag=true;
		try
		{
			Thread.sleep(2000);
		 alert=rdriver.switchTo().alert();
		 alert_msg=alert.getText();
		 alert.accept();
		
		
	}
		catch(NoAlertPresentException e)
		{
			
		e.printStackTrace();
		
		}
		return alert_msg;
		
		}
	public String click_Run_Button_with_inavalid() {
		pageUtil.explicit_wait(rdriver,run_button);
		run_button.click();
		alert=rdriver.switchTo().alert();
		 alert_msg=alert.getText();
		 alert.accept();
		return alert_msg;
	}
	
	
	

}
