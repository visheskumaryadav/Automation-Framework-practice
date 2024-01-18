package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cart {
    private WebDriver driver;
    public Cart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div.cart-info tr")
    List<WebElement> cartInfo;

    public int getAddedProductCount(){
        String result=cartInfo.get(0).getText().split(":")[1];
        return Integer.parseInt(result.trim());
    }
}
