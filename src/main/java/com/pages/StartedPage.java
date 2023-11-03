package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverFactory;

public class StartedPage {
	
	 WebDriver driver=DriverFactory.getDriver();
	 HomePage hpage=new HomePage(driver);

	   public StartedPage(WebDriver rdriver)
	     {
		     this.driver=rdriver;
		     PageFactory.initElements(rdriver,this);
	     }

	@FindBy(xpath="//button[contains(text(),'Get Started')]") WebElement getStarted;
	//@FindBy(xpath="//title") WebElement title;
	
	
	
	
	public HomePage clickGetStarted()
	{
		
		getStarted.click();
		return new HomePage(driver);
		
	}
	
	
	public String getTitle()
	{
		String actul_title=driver.getTitle();
		
		
		//String actul_title=hpage.getTitle();
		return actul_title;
		
	}

}
