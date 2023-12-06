package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @FindBy(css = "div[class=products]>.product")
    List<WebElement> productList;

    final private String addToCart="./div[@class='product-action']/button";
    final private String increaseQty="./div[@class='stepper-input']/a[@class='increment']";
    final private String decreaseQty="./div[@class='stepper-input']/a[@class='decrement']";
    final private String qtyNum="./div[@class='stepper-input']/a[@class='quantity']";
    void setQty(WebElement product,int qty)  {

        for(int i=0;i<qty;i++){
            product.findElement(By.xpath(increaseQty)).click();
        }
    }
    void clickOnAddButton(WebElement product){
        product.findElement(By.xpath(addToCart)).click();
    }
    WebElement searchProduct(String productName){
        for(WebElement product:productList){
            String fetchedProductName=product.findElement(By.xpath("./h4")).getText();
            if(fetchedProductName.contains(productName)) {
               return product;
            }
        }
        return null;
    }
    void addProduct(String productName,int qty)  {
        if(searchProduct(productName)!=null){
            WebElement product=searchProduct(productName);
            setQty(product,qty);
            clickOnAddButton(product);
            System.out.println("product is add");
        }else{
            System.out.println("Product is N/A");
        }
    }


    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        HomePage h=new HomePage(driver);
        h.addProduct("Cauliflower",1);
    }
}
