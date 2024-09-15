package PageObjects;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



import Actions.PreDefinedActions;
import Base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage extends BaseClass {


        public LoginPage()//create a constructor
        {
            PageFactory.initElements(driver, this);//initializing the driver and web-elements
        }
        @FindBy(xpath="//a[@type='button']")
        private WebElement GermanyHeading;

        public boolean verifyHeading()
        {
            return GermanyHeading.isDisplayed();
        }
        @FindBy(xpath= "//a[contains(text(),'New to Germany Is Calling?')]")
        private WebElement SignUpText;

        public String verifyHeading2()
        {
            return PreDefinedActions.getText(SignUpText);
        }

        @FindBy(xpath= "//a[normalize-space()='Forgot Password?']")
        private WebElement ForgotPassText;

        public String verifyHeading3()
        {
            return PreDefinedActions.getText(ForgotPassText);
        }




        @FindBy(id = "username")
        private WebElement Username;


        @FindBy(id = "password")
        private WebElement Password;

        @FindBy(xpath = "//button[@type='submit']")
        private WebElement SignIn;

        public void setLogin(String id, String pass) {

            PreDefinedActions.clickMethod(Username, true);
            PreDefinedActions.sendKeysMethod(Username, id);
            PreDefinedActions.clickMethod(Password, true);
            PreDefinedActions.sendKeysMethod(Password, pass);
            PreDefinedActions.clickMethod(SignIn, true);
        }
    }






