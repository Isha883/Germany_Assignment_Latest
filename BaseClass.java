package Base;
import ConstantPath.ConstantPaths;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

    public class BaseClass {
        private static Properties pro;// it is a class

        public static WebDriver driver;
        protected static WebDriverWait wait;//is a class
       /* @BeforeSuite
        public void propReading() throws IOException {
            try {
                File file = new File(ConstantPaths.PROP_PATH);
                FileInputStream fileInputStream = new FileInputStream(file);//it is a class of java.io.package to read data from files.
                pro = new Properties();
                pro.load(fileInputStream);
            } catch (Exception e) {
                System.out.println("Properties file not found");
            }
        }
*/
        /*
This code is reading data from a properties file in Java using the FileInputStream and Properties classes.

First, a File object is created with the path of the properties file, which is stored in a constant value named "PROP_PATH" in the class "ConstantPaths".

Then, a new FileInputStream object is created, passing the File object as a parameter. The FileInputStream is a class from the java.io package, which allows reading data from files.

Next, a new Properties object is created, which will hold the key-value pairs from the properties file.

Finally, the Properties object's load() method is called, passing the FileInputStream object as a parameter. This method reads the properties file data from the input stream and loads it into the Properties object.

If any exception occurs while performing these operations, the catch block will be executed and "Properties file not found" message will be printed in the console.*/
/*
        @BeforeSuite
        public static void initializeBrowser()
        {
            switch (pro.getProperty("browserName").toUpperCase()) {
                case "CHROME":
                    driver = new ChromeDriver();
                    // ChromeOptions options = new ChromeOptions();
                    break;
                case "FIREFOX":
                    driver = new FirefoxDriver();
                    break;

                case "SAFARI":
                    driver = new SafariDriver();
                default:
                    System.out.println("Illegal browser name");
                    break;
            }
            driver.manage().window().maximize();
            driver.get(pro.getProperty("urlName"));
            wait= new WebDriverWait(driver, Duration.ofSeconds(20));

        }
        */



        @BeforeSuite
        public static void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F");
        }

            /*This code is initializing a web browser instance based on a property value that is read from a properties file.

The code is annotated with "@BeforeClass", which is a JUnit annotation that indicates that the method should be executed before the first test method in the class. It is often used for setup tasks that are common across multiple test methods.

The "switch" statement is used to check the value of the "browserName" property retrieved from the "pro" Properties object. The value is converted to uppercase using the "toUpperCase()" method to make it case-insensitive.

If the value matches "CHROME", a new instance of the ChromeDriver class is created and assigned to the "driver" variable. Additionally, a new ChromeOptions object is created and assigned to the "options" variable.

If the value matches "FIREFOX", a new instance of the FirefoxDriver class is created and assigned to the "driver" variable.

If the value matches "SAFARI", a new instance of the SafariDriver class is created and assigned to the "driver" variable.

If the value does not match any of the expected values, the code prints the message "Illegal browser name" to the console.

Overall, this code is responsible for initializing a web browser instance based on a property value, which can be used by subsequent test methods to interact with the browser.*/

    }



