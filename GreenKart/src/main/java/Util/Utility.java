package Util;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.network.Header;
import org.openqa.selenium.interactions.Actions;

import java.net.HttpURLConnection;
import java.net.URL;

public class Utility {

    public static void scrollFocus(WebDriver driver, WebElement element){
//         Point position=element.getLocation();
         Actions action=new Actions(driver);
         action.scrollToElement(element).build().perform();
    }

    public static void  checkUrl(String url){
        try {
            URL link = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)link.openConnection();
            connection.setRequestMethod("Head");
            int responseCode=connection.getResponseCode();
            System.out.println("URL:"+url + "\nCODE:" + responseCode);
//            if(responseCode==200){
//                return true;
//            }else
//                return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
//            return false;
        }
    }
}
