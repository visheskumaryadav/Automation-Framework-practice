package BrowserSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import java.util.Set;
/*
 SetBowser class used for launching the browsers
 */
public class SetBrowser {

    WebDriver driver;
    public  WebDriver launchBrowser(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
        }else{
            System.out.println("Invalid browser");
        }
        return driver;
    }

    public void close(){
        driver.quit();
    }
}
