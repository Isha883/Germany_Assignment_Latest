package TestScripts;
import Base.BaseClass;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestVerify extends BaseClass {
    LoginPage page;


    @Test(description = "Let's test enter valid email and password, click on sign in button of login page ", priority = 1)
    public void TC_001() {
        page = new LoginPage();
        page.setLogin("ishakeshri123@gmail.com", "Admin@123#");
        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.germanyiscalling.com/cv/upload/");
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileIcon")));
        assert (profileIcon.isDisplayed());
    }

    @Test(description = "Let's test BLANK EMAIL AND PASSWORD and click on sign in button of login page ", priority = 1)
    public void TC_003() {
        page = new LoginPage();
        page.setLogin(" ", " ");
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        String ExpectedText = errorMsg.getText();
        String ActualText = "Email: This field is required.\n" +
                "Password: This field is required.";
        Assert.assertEquals(ExpectedText, ActualText);

    }

    @Test(description = "Let's test passing invalid email and invalid password on login page ", priority = 1)
    public void TC_004() {
        page = new LoginPage();
        page.setLogin("ishakeshri123@gmail.com", "Admin@1");
        WebElement errorMsg = driver.findElement(By.xpath("//li[text()='Please enter a correct username and password. Note that both fields may be case-sensitive.']"));
        String ExpectedText = errorMsg.getText();
        String ActualText = "Please enter a correct username and password. Note that both fields may be case-sensitive.";
        Assert.assertEquals(ExpectedText, ActualText);

    }

    @Test(description = "Let's test passing valid email and blank password login page ", priority = 1)
    public void TC_005() {
        page = new LoginPage();
        page.setLogin("kesharimanoj344@gmail.com", " ");
        WebElement errorMsg = driver.findElement(By.xpath("//li[normalize-space()='Password: This field is required.']"));
        String ExpectedText = errorMsg.getText();
        String ActualText = "Password: This field is required.";
        Assert.assertEquals(ExpectedText, ActualText);
    }

    @Test(description = "Let's test passing blank email and valid password login page ", priority = 1)
    public void TC_006() {
        page = new LoginPage();
        page.setLogin(" ", "123456");
        WebElement errorMsg = driver.findElement(By.xpath("//li[normalize-space()='Email: This field is required.']"));
        String ExpectedText = errorMsg.getText();
        String ActualText = "Email: This field is required.";
        junit.framework.Assert.assertEquals(ExpectedText, ActualText);
    }

    @Test(description = "Let's test passing valid email and invalid password login page ", priority = 1)
    public void TC_007() {
        page = new LoginPage();
        page.setLogin("ishakeshri123@gmail.com", "89ty");
        WebElement errorMsg = driver.findElement(By.xpath("//li[text()='Please enter a correct username and password. Note that both fields may be case-sensitive.']"));
        String ExpectedText = errorMsg.getText();
        String ActualText = "Please enter a correct username and password. Note that both fields may be case-sensitive.";
        Assert.assertEquals(ExpectedText, ActualText);

    }

    @Test(description = "Let's test passing invalid email and valid password login page ", priority = 1)
    public void TC_008() {
        page.setLogin("ik123@gmail.com", "Admin@123#");
        WebElement errorMsg = driver.findElement(By.xpath("//li[text()='Please enter a correct username and password. Note that both fields may be case-sensitive.']"));
        String ExpectedText = errorMsg.getText();
        String ActualText = "Please enter a correct username and password. Note that both fields may be case-sensitive.";
        Assert.assertEquals(ExpectedText, ActualText);
    }

    @Test(description = "Let's test sign up button is  displayed or not on login page ", priority = 1)

    public void TC_009() {
        page = new LoginPage();
        page.verifyHeading2();
        Assert.assertEquals(page.verifyHeading2(), "New to Germany Is Calling? Sign Up");
    }

    @Test(description = "Let's test heading is displayed or not on login page ", priority = 1)
    public void TC_010() {
        page = new LoginPage();
        page.verifyHeading();
        Assert.assertTrue(page.verifyHeading(), "Not enabled");
    }

    @Test(description = "Let's test forgot password text  is displayed or not on login page ", priority = 1)
    public void TC_011() {
        page = new LoginPage();
        page.verifyHeading3();
        Assert.assertEquals(page.verifyHeading3(), "Forgot Password?");
    }
}











