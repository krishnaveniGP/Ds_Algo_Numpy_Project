package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.ConfigReader;



public class HomePage {
	private WebDriver driver;
	 String str2;
	 WebDriverWait wait;
	 String homePageurl=ConfigReader.homePage();
	public HomePage(WebDriver rdriver)
	{
		this.driver=rdriver;		
		PageFactory.initElements(rdriver, this);
	}	
			 
	
			
			@FindBy(xpath="//div[@class='alert alert-primary']")private WebElement error_msg;
			@FindBy(xpath="//a[contains(text(),'Data Structures')]")private WebElement menuDropdown;
			
			@FindBy(xpath="//div/h5/../a")private WebElement getStarted_btn;
			@FindBy(xpath="//a[text()='Sign in']")private WebElement signIn;
			@FindBy(xpath="//a[text()=' Register ']")private WebElement register;
			@FindBy(xpath = "//div[contains(@class,'alert ')]")private WebElement signInAlert;
			@FindBy(xpath = "//div/h5[contains(text(),'Array')]/../a")private WebElement arrayGetStart;
			@FindBy(xpath="//a[@href='linked-list']") private WebElement linked_Get_StartBtn;
			@FindBy(xpath = "//h5[text()='Stack']/..//a")private WebElement stack_Get_Start;
			@FindBy(xpath = "//h5[text()='Tree']/..//a")private WebElement tree_Get_Start;
			@FindBy(xpath="//a[contains(text(),'Sign out')]")private WebElement signOut;
			@FindBy(xpath="//div[@role='alert']") WebElement logout_Alert_msg;
			@FindBy(xpath = "//h5[text()='Data Structures-Introduction']/..//a")private WebElement datatructure_Start;			
			@FindBy(xpath = "//h5[text()='Queue']/..//a")private WebElement Queue_Start;
			@FindBy(xpath = "//h5[text()='Graph']/..//a")private WebElement Graph_Start;
			public void clickDropDownMenu()
			{
				
				menuDropdown.click();
				
			}
			public DataStructuresPage click_data_Structure_GetStarted()
			{
				datatructure_Start.click();
				return new DataStructuresPage(driver);
				
				
			}
			public QueuePage click_Queue_start()
			{
				
				Queue_Start.click();
				return new QueuePage(driver);
			}
			public GraphPage click_Graph_start()
			{
				
				Queue_Start.click();
				return new GraphPage(driver);
			}
			
			
			
			public ArraysPage click_array_getstart()
			 {
				//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
				arrayGetStart.click();
				return new ArraysPage(driver);}
			
			
			
			 public StackPage click_Stack_getstart()
			 {
				//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
				 stack_Get_Start.click();
				return new StackPage(driver); 
			 }
			 public TreePage click_Tree_getstart()
			 {
				//new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(arraygetstart));
				 tree_Get_Start.click();
				return new TreePage(driver); 
			 }
			public void homepage() {
				driver.get(homePageurl);		
			}	
			
			public LinkedListPage click_Linked_getStart() throws InterruptedException
			{    Thread.sleep(3000);
			linked_Get_StartBtn.click();
				return new LinkedListPage(driver);		
			}
			
			
		   public void dropDownList(String string) throws InterruptedException
		   { 
			 Thread.sleep(3000);	
			 menuDropdown.click();
			 List<WebElement> dataOptions=driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
			for (WebElement dataoption : dataOptions) 
			{
			if(dataoption.getText().contains(string))
			{	
				dataoption.click();
				String error=error_msg.getText();
				break;		
			}
		    }		
		   }		
		   
		   public void getStartBtn_click()
		   {
			   List<WebElement> getStartList=driver.findElements(By.xpath("//div/h5/../a"));
			  // System.out.println(getStartList.size());
			   for(WebElement getList:getStartList)
			   {
				   getList.click();
				   String error=error_msg.getText();
				   break;		
			   }	   
		   }
		   
		   public String getErr_msg()
			{
				String error=error_msg.getText();
				return error;
			}	
			
			public SignInPage signin_Btn()
			{
				signIn.click();
				return new SignInPage(driver);
			}
			
			public RegistrationPage clickRegisterButton() throws InterruptedException
			{   Thread.sleep(3000);
				register.click();		
				return new RegistrationPage(driver);
			}

			public void menuDropDown() {
				menuDropdown.click();
			}
			public void getStart_Btn_After_SignIn_click(String option)throws InterruptedException
			{	  
			
			// new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(optlst));
			
			 
			 String message=signInAlert.getText();
			 if(message.equalsIgnoreCase("You are logged in"))
			 {
				 WebElement optlst= driver.findElement(By.xpath("//h5[text()='"+option+"']/../a")); 
				 new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(optlst));
				 optlst.click();
			 }
			
			 
		   }
			public String logged_In_message()
			{
				String logMsg=signInAlert.getText();
				
				return logMsg;
				
			}
			public String click_Log_Out()
			{
				signOut.click();
				String logout_Msg=logout_Alert_msg.getText();
				return logout_Msg;
				
				
			}
			public String getTitle() {
				String title=driver.getTitle();
				return title;
			}
		}
	


