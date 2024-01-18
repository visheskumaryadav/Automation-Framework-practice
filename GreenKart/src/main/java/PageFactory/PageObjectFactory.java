package PageFactory;

import PageObjects.Cart;
import PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFactory {
    WebDriver driver;
    public PageObjectFactory(WebDriver driver){
        this.driver=driver;
    }

    public LandingPage getLandingPageObject(){
        return new LandingPage(driver);
    }
    public Cart getCartObject(){
        return new Cart(driver);
    }

}
