package WebTest2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;


public class WebExercise{
  static protected WebDriver driver ;

        @Test
    public void OrangeHrm() {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe ");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
            //user will input username and password provided by admin
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).sendKeys("admin123");
            try { Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        }

        @Test
        public void Matalan () {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe ");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.matalan.co.uk/");
            driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/ul/li[1]/a")).click();
            driver.findElement(By.id("account_form_email")).sendKeys("mani123@yahoo.com");
            driver.findElement(By.xpath("//button[@data-behavior='save_button']")).click();
            driver.findElement(By.name("account_form[meta_attributes[first_name][value]]")).sendKeys("mani");
            driver.findElement(By.id("account_form_meta_attributes[last_name][value]")).sendKeys("shah");
            driver.findElement(By.id("account_form_email_confirmation")).sendKeys("mani123@yahoo.com");
            driver.findElement(By.id("account_form_password")).sendKeys("12345mani");
            driver.findElement(By.id("account_form_password_confirmation")).sendKeys("12345mani");

        }
        @Test
    public void MockPlus () {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            driver.get("https://www.mockplus.com/");
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("mani12@test.com");
            driver.findElement(By.id("password")).sendKeys("123mani");
            driver.findElement(By.id("login")).click();
        }

        @Test
    public void Asda (){
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver =new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.get("https://groceries.asda.com/?cmpid=ppc-_-ghs-_--_-google-_-asda-_-dskwid-s43700013662392458_dc");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  driver.findElement(By.className("optanon-allow-all accept-cookies-button")).click();
            driver.findElement(By.linkText("Register")).click();
            //driver.findElement(By.className("primary full")).click();
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mani124@test.com");
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234mani");
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sm3 2ad");
            driver.findElement(By.className("checkmark")).click();
            driver.findElement(By.xpath("//button[@class='primary full']")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }
        @Test
    public void Ocado (){
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.get("https://www.ocado.com/webshop/startWebshop.do");
            driver.findElement(By.id("quickReg")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-submit-button")));
            Select select = new Select(driver.findElement(By.tagName("select")));
            select.selectByVisibleText("Miss");
            driver.findElement(By.id("firstName")).sendKeys("mani");
            driver.findElement(By.id("lastName")).sendKeys("shah");
            driver.findElement(By.id("login")).sendKeys("mani14@test.com");
            driver.findElement(By.id("password")).sendKeys("1234mani");
            driver.findElement(By.id("postcode")).sendKeys("sm3 2ad");
            driver.findElement(By.id("registration-submit-button")).click();
        }
}