package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class PomLogin extends BaseClass{
	//object repository 
	@FindBy(id = "txtUsername")
	WebElement Username;
	@FindBy(id = "txtPassword")
	WebElement Password;
	@FindBy(id = "btnLogin") WebElement loginbt;
	//Initiate Page elements
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	public void typeusername(String name) {
		Username.sendKeys(name);
		
	}
	public void typepassword(String psw) {
		Password.sendKeys(psw);
	}
	public void clickbt() {
		loginbt.click();
	}
	public String verify() {
		return driver.getTitle();
	}

}
