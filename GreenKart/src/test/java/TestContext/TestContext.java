package TestContext;

import BrowserSetUp.SetBrowser;
import Configuration.Configuration;
import PageFactory.PageObjectFactory;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TestContext {

    private WebDriver driver;
    private PageObjectFactory page;
    public  SoftAssert assertion;
    private SetBrowser browser;
    public JSONObject jsonConfigData;
    public TestContext(){
        System.out.println("TestContext:::::::::::::::::");
        initializeConfiguration();
        initializeBrowser();
        initializePageObjectFactory();
        initializeConfiguration();
        assertion=new SoftAssert();
    }

    private void initializePageObjectFactory() {
        page=new PageObjectFactory(driver);
    }

    private void initializeBrowser(){
        browser=new SetBrowser();
        driver=browser.launchBrowser(jsonConfigData.getString("browser"));
        if(driver==null){
            System.out.println("Driver is null!!");
        }
    }

    public void openURL(String url){
        if(driver!=null){
            driver.get(url);
        }

    }
    public WebDriver getDriver(){return driver;}
    public PageObjectFactory getPageObject(){
        return page;
    }

    public void assertAll(){
        assertion.assertAll();
    }
    private void initializeConfiguration(){
        Configuration config=new Configuration();
        jsonConfigData=config.getJsonConfigData();

    }

    public void closeBrowser(){
        browser.close();
    }


}
