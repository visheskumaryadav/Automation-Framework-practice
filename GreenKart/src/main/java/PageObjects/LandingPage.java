package PageObjects;

import Util.Utility;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import Util.WaitManager;
import java.util.stream.Collectors;

public class LandingPage {

    private WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".brand.greenLogo")
    private WebElement logo;
    @FindBy(css = "div[class='product']")
    private List<WebElement> products;

    @FindBy(css = "input.search-keyword")
    private WebElement searchBox;

    String productTextPath="./h4";
    String addToCartBtnPath="./div[@class='product-action']/button";
    final private String increaseQty="./div[@class='stepper-input']/a[@class='increment']";
    final private String decreaseQty="./div[@class='stepper-input']/a[@class='decrement']";
    final private String qtyNum="./div[@class='stepper-input']/input[@class='quantity']";
    final private String imgPath="./div[@class='product-image']/img";

    public void isAnyProductImageBroken(){
        for(WebElement product:products){
            String productImgUrl=product.findElement(By.xpath(imgPath)).getAttribute("src");
            Utility.checkUrl(productImgUrl);

        }
    }

    public int getQtyDisplayingForProduct(int randomProductIndex){
        Utility.scrollFocus(driver,products.get(randomProductIndex));
        return Integer.parseInt(products.get(randomProductIndex).findElement(By.xpath(qtyNum)).getAttribute("value").trim());
    }
    public void increaseQty(int randomProductIndex,int qty)  {
        Utility.scrollFocus(driver,products.get(randomProductIndex));
        for(int i=0;i<qty;i++){
            products.get(randomProductIndex).findElement(By.xpath(increaseQty)).click();
        }
    }
    public void decreaseQty(int randomProductIndex,int qty){
        Utility.scrollFocus(driver,products.get(randomProductIndex));
        for(int i=qty;i>0;i--){
            products.get(randomProductIndex).findElement(By.xpath(decreaseQty)).click();
        }
    }
    public void decreaseQty(int randomProductIndex){
        Utility.scrollFocus(driver,products.get(randomProductIndex));
        while(true){
            String qty=products.get(randomProductIndex).findElement(By.xpath(qtyNum)).getAttribute("value").trim();
            if(Integer.parseInt(qty.trim())==1){
                break;
            }
            products.get(randomProductIndex).findElement(By.xpath(decreaseQty)).click();
        }
    }
    boolean isAddToCartBtnClicked;
    private String getProductName(WebElement element){
        Utility.scrollFocus(driver,element);
             return element.findElement(By.xpath(productTextPath)).getText();
    }
    public void clickSearchBox(){
        searchBox.click();
    }
    public String getSearchBoxPlaceholder(){
        return searchBox.getAttribute("placeholder");
    }

    public List<String> getSearchResult(){
        return products.stream().map(this::getProductName).collect(Collectors.toList());
    }

    public void search(String searchInput) {
        searchBox.sendKeys(searchInput);
    }

    public void addProduct(int productQty,int randomProductIndex){

    }
    public String addProduct(int randomProductIndex){
        products.get(randomProductIndex).findElement(By.xpath(addToCartBtnPath)).click();
        WebElement btn=products.get(randomProductIndex).findElement(By.xpath(addToCartBtnPath));
        WaitManager.waitTillTextToBePresentInElement(driver,5000,btn);
        return  products.get(randomProductIndex).findElement(By.xpath(addToCartBtnPath)).getText();
    }

}
