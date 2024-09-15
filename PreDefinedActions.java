package Actions;


import Base.BaseClass;
import com.google.common.io.Files;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PreDefinedActions extends BaseClass {//here we have extend base class to access the driver
    private static Logger log = Logger.getLogger(PreDefinedActions.class);// Logger is a class used to log events, get logger is a method to crete logger with name pass as para.


    public static void sendKeysMethod(WebElement element, String text)
    {

        element.sendKeys(text);

    }

    public static List<WebElement> getListOfWebElement(List<WebElement> elementList) {//used list for getting list of elements
        List<WebElement> webElementList = wait.until(visibilityOfAllElements(elementList));//wait method used
        return webElementList;
    }

    public static List<Double> getListOfWebElementInDouble(List<WebElement> elementList) {
        List<Double> elementListString = new ArrayList<>();
        for (WebElement element : elementList) {
            elementListString.add(Double.parseDouble(element.getText().replace("+","")// in list we have , + USD space remove it and now it is double format that's why look like this.
                    .replace(" ","")
                    .replace("USD","").replace(",","")));
        }
        return elementListString;
    }

    public static void scrollInToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void navigateBack()
    {
        driver.navigate().back();
    }

    public static void frameHandles(WebElement element, boolean isWaitRequired) {
        if (isWaitRequired == true) {
            wait.until(frameToBeAvailableAndSwitchToIt(element));
        } else {
            driver.switchTo().frame(element);
        }
    }
    public static String getText(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element)).getText();//it has wait so worked
    }

    public static void switchDefaultPage() {
        driver.switchTo().defaultContent();
    }

    public static void clearField(WebElement element, boolean isWaitRequired, String text) {
        element.clear();
        element.sendKeys(text);

    }

    public static void clickMethod(WebElement element, boolean isWaitRequired) {
        if (isWaitRequired == true) {
            wait.until(elementToBeClickable(element)).click();
        } else {
            element.click();
        }
    }
    public static void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;//it is a method to capture screenshots
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);//OutputType file defines the output type for required screenshot., getScrnshot method used to create image file.
        File file = new File("src/test/java/ScreenShot" + fileName + ".png");//move image file to new destination.
        try {
            Files.copy(screenshotFile, file); // copying file at a destination
        } catch (IOException e) {
            log.error("User not able to copy Screenshot file");
            throw new RuntimeException();
        }
    }
    public static void clickWithJS(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }


    public static void windowHandles() {
        String parentWindow = driver.getWindowHandle();
        Set<String> stringSet = driver.getWindowHandles();
        Iterator<String> I1 = stringSet.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parentWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
            /*This is a Java method named windowHandles() that performs window handling operations using the Selenium WebDriver library.

Here's what this code does:

The first line of the method gets the handle of the parent window using the getWindowHandle() method of the driver object. The window handle is a unique identifier that Selenium uses to identify browser windows.

The second line gets a set of all window handles using the getWindowHandles() method of the driver object. This set contains the handles of all windows that the WebDriver instance can see at the moment.

An iterator is created using the iterator() method of the Set interface, which is used to loop through the set of window handles.

The while loop starts iterating through the set of window handles.

The next() method of the iterator is called to get the next window handle in the set, which is assigned to the child_window variable.

The if statement checks if the child_window is not equal to the parentWindow. If it's not, it means that child_window is a different window from the parent window.

The driver.switchTo().window(child_window) method is called to switch the focus of the WebDriver instance to the child window with the handle child_window.

By switching the WebDriver instance to a different window, the automation script can interact with the elements of the child window, such as clicking on a link that opens in a new window, filling out a form, or any other actions.*/

        }
    }
}


