package com.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ConfigReader;
import com.utilities.PageUtils;

public class ArraysPage {
	WebDriver driver;
	PageUtils pageUtil=new PageUtils();
	String homePage_url=ConfigReader.homePage();
	Alert alert;
	String alert_msg;
	String result;
		
	public ArraysPage(WebDriver ldriver) {
		this.driver=ldriver;		
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(xpath="//body/div[2]/ul[1]")private WebElement arrayInPython;
	@FindBy(xpath="//a[contains(text(),'Try here>>>')]")private WebElement tryHereButton;
	@FindBy(xpath="//div[@class='CodeMirror-sizer']")private WebElement codeInputEditor;
	@FindBy(xpath="//button[text()='Run']")private WebElement run_Button;
	@FindBy(id = "output")private WebElement outputbox;
	@FindBy(xpath="//a[text()='Practice Questions']")private WebElement practiceQuestions;
	@FindBys(@FindBy(xpath="//body/div/a")) List <WebElement> pra_Q_Options;
	@FindBys(@FindBy(xpath="//body/div[2]/ul"))List <WebElement> arrayOptions;
	@FindBy(xpath="//div[@class='CodeMirror-sizer']")private WebElement practice_editor;
	@FindBy(xpath="//input[@type='submit']")private WebElement submitt_Button;

	public void click_arrayInPython() 
	{  
		pageUtil.scrolldown(driver);
	pageUtil.explicit_wait(driver, arrayInPython);
	arrayInPython.click();
	}
	public void arrymenu_click(String option)
	{
		pageUtil.menu_click(driver, arrayOptions, option);
		}

	public void practicemenu_click(String option)
	{pageUtil.menu_click(driver, pra_Q_Options, option);}


	public void tryedit_click()
	{	
		//pageUtil.scrolldown(driver);
	pageUtil.scrolldown(driver);
	tryHereButton.click();
	} 

	public void practice_click()
	{	pageUtil.explicit_wait(driver, practiceQuestions);
	practiceQuestions.click();
	}
	public void enter_code(String code) 
	{	
		WebElement e=driver.switchTo().activeElement();
		pageUtil.entercode(driver, e, code);
		}
	public void click_run() 
	{	
		pageUtil.mouse_action(driver, run_Button);
		pageUtil.explicit_wait(driver,run_Button);
		run_Button.click();
	}
	public void click_submit()
	{
		pageUtil.mouse_action(driver, submitt_Button);
		submitt_Button.click();
	}
	public String present_result()
	{
	result=	outputbox.getText();
	return result;
	}
	public String present_invalidmsg()
	{
		result= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return result; 
	}
	public String get_Title() {
		String title=driver.getTitle();
		return title;
		
	}
	}
	
	

