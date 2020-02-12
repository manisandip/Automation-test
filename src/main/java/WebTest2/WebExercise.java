package WebTest2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static javafx.scene.input.KeyCode.*;


public class WebExercise {
    static protected WebDriver driver;

    @Before
    //creating method for browser to open using chrome
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

     @After
     //method created for closing the browser
    public void CloseBrowser(){
      driver.quit();
    }
    //method created for wait for clickable with two parameters
    public void WaitForClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
     //method created for Enter text with two parameters
    public void EnterText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
        WaitForClickable(by, 60);
    }

    //method created for click on element
    public void ClickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    //method created for get text from element
    public String GetTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //method created for wait for element is present with two parameters
    public void WaitForElementIsPresent(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //method created for wait for visibility with two parameters
    public void waitForvisibility(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    //method created for timestamp in  email
    public String timestamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddmmhhmmss");
        Date date = new Date();
        return (dateFormat.format(date));
    }

    //method for drop down by value with two parameters
    public void SelectFromDropDownByValue(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    //method for drop down by visible text with two parameters
    public void SelectDropDownByVisileText(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //method for drop down by index with two parameters
    public void SelectFromDropDownByIndex(By by, int index)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    @Test
    public void userShouldAbleToRegisterSuccessfully()
        {
            //type url
            driver.get("https://demo.nopcommerce.com/ ");
            //click on register
            ClickOnElement(By.linkText("Register"));
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Enter first name
             EnterText(By.id("FirstName"), "Manisha");
            //Enter password
            EnterText(By.id("LastName"), "Sharma");
            //select dropdown for date of birth
            SelectFromDropDownByValue(By.name("DateOfBirthDay"), "20");
            //select dropdown for month of birth
            SelectFromDropDownByIndex(By.name("DateOfBirthMonth"), 7);
            //select dropdown for year of birth
            SelectDropDownByVisileText(By.name("DateOfBirthYear"), "1993");
            //Enter email address
            EnterText(By.id("Email"), "mani12+" + timestamp() + "@test1.com");
            //Enter password
            EnterText(By.id("Password"), "12345678");
            //Enter confirm password
            EnterText(By.id("ConfirmPassword"),"12345678");
            //click on register button
            ClickOnElement(By.id("register-button"));
            GetTextFromElement(By.className("result"));
            //Expected message by client

            String Expected = "My registration successfully";
            //Actual message appeared on the screen
            String Actual = driver.findElement(By.className("result")).getText();
            //compare the difference in( actual & expected ) and print message( pass or fail )
            Assert.assertEquals("fail", Expected, Actual);
        }

        @Test
        public void OrangeHrm ()
        {
            //Type url
            driver.get("https://opensource-demo.orangehrmlive.com/");
            //user will input username and password provided by admin
            EnterText(By.id("txtUsername"), "Admin");
            EnterText(By.id("txtPassword"), "admin123");
            //click on login button
            ClickOnElement(By.xpath("//input[@type=\"submit\"]"));
            //welcome message will appear on the top right corner
            GetTextFromElement(By.id("welcome"));
            WaitForElementIsPresent(By.cssSelector("a.panelTrigger"), 70);
            //Message expected by the client

            String Expected = "welcome";
            //Actual Message that appeared on the screen
            String Actual = GetTextFromElement(By.cssSelector("a.panelTrigger"));
            //Compare the difference in (expected & Actual )
            Assert.assertEquals("Fail", Expected, Actual);
        }

        @Test
        public void Matalan ()
        {
            //Type url
            driver.get("https://www.matalan.co.uk/");
            //click on My account
            ClickOnElement(By.xpath("/html/body/div[3]/div/div[1]/ul/li[1]/a"));
            //Enter email address
            EnterText(By.id("account_form_email"), "mani123+" + timestamp() + "@yahoo.com");
            //click on continue securely
            ClickOnElement(By.xpath("//button[@data-behavior='save_button']"));
            //Enter first name
            EnterText(By.name("account_form[meta_attributes[first_name][value]]"), "mani");
            //Enter surname
            EnterText(By.id("account_form_meta_attributes[last_name][value]"), "shah");
            //Enter confirm email address
            EnterText(By.id("account_form_email_confirmation"), "mani123@yahoo.com");
            //Enter password
            EnterText(By.id("account_form_password"), "1234mani");
            //Enter confirm password
            EnterText(By.id("account_form_password_confirmation"), "1234mani");
            //this message should appear on the page
            ClickOnElement(By.className("o-dialog__header"));
            //Expected message by the client

            String Expected = "Registration";
            //Actual message displayed on the page
            String Actual = GetTextFromElement(By.className("o-dialog__header"));
            //compare the difference in actual and expected
            Assert.assertEquals("Fail", Expected, Actual);

        }
        @Test
        public void MockPlus () {
            driver.get("https://www.mockplus.com/");
            //WebDriverWait wait = new WebDriverWait(driver, 30);
            ClickOnElement(By.className("user-btn"));
            //Enter email address
            EnterText(By.id("email"), "test+" + timestamp() + "@test.com");
            //Enter password
            EnterText(By.id("password"), "test123");
            //Enter confirm password
            EnterText(By.id("cofPassword"), "test123");
            //click on the box
            ClickOnElement(By.id("agree"));
            //registered successfully
            ClickOnElement(By.id("register"));

            String expected = "Welcome to Mockplus";
            //Will give you the output result
            String actual = GetTextFromElement(By.className("logo"));
            Assert.assertEquals("Failed", expected, actual);
        }

        @Test
        public void Asda ()
        {   //Type url
            driver.get("https://groceries.asda.com/?cmpid=ppc-_-ghs-_--_-google-_-asda-_-dskwid-s43700013662392458_dc");
            //Click on register
            ClickOnElement(By.linkText("Register"));
            //Enter Email address
            EnterText(By.xpath("//input[@type='email']"), "mani10@test.com");
            //Enter Password
            EnterText(By.xpath("//input[@type='password']"), "asha1234");
            //Enter postcode
            EnterText(By.xpath("//input[@type='text']"), "sm3 2ad");
            //click on the box to accept terms and condition
            ClickOnElement(By.className("checkmark"));
            //Click on the register button
            ClickOnElement(By.xpath("//button[@class='primary full']"));
            ClickOnElement(By.xpath("//button[@type='submit']"));
            ClickOnElement(By.id("need-help"));
            //ClickOnElement(By.className("welcome-message__welcome-text"));
            //Expected message to be displayed on the screen

            String Expected = "Registration completed";
            //Actual message on the screen
            String Actual = GetTextFromElement(By.id("need-help"));
            //compare actual vs Expected
            Assert.assertEquals("Fail", Expected, Actual);
        }
        @Test
        public void Ocado ()
        {
            //Type url
            driver.get("https://www.ocado.com/webshop/startWebshop.do");
            //Click on register button
            ClickOnElement(By.id("quickReg"));
            //WebDriverWait wait = new WebDriverWait(driver,10);
            //wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-submit-button")));
            WaitForClickable(By.id("registration-submit-button"), 60);
            //method used for drop down
            Select select = new Select(driver.findElement(By.tagName("select")));
            //select miss from dropdown box
            select.selectByVisibleText("Miss");
            //Enter firstname
            EnterText(By.id("firstName"), "mani");
            //Enter lastname
            EnterText(By.id("lastName"), "shah");
            //Enter email address
            EnterText(By.id("login"), "mani145+" + timestamp() + "@test.com");
            //Enter password
            EnterText(By.id("password"), "12345mani");
            //Enter postcode
            EnterText(By.id("postcode"), "sm3 2ad");
            //Click on register
            ClickOnElement(By.id("registration-submit-button"));
            //Expected message from  the client

            String Expected = "check";
            //Actual message displayed on the page
            String Actual = "button continue disabled";
            //compare the difference in Expected and Actual
            Assert.assertEquals("Fail", Expected, Actual);
        }
    }
