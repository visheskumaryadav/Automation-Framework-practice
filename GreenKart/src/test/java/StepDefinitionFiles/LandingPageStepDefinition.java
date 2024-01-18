package StepDefinitionFiles;

import PageObjects.LandingPage;
import TestContext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Random;

public class LandingPageStepDefinition {
    TestContext context;
    LandingPage landingPage;
    String productName;
    Random random=new Random();
    int randomProductIndex;
    public LandingPageStepDefinition( TestContext context){
        this.context=context;
        landingPage=context.getPageObject().getLandingPageObject();
    }

    @Then("user click on search input field")
    public void userClickOnSearchInputField() {
        landingPage.clickSearchBox();
        System.out.println("User clicked on searchbox");
        context.assertion.assertEquals(landingPage.getSearchBoxPlaceholder(),"Search for Vegetables and Fruits");
    }

    @When("user enter {string} in search input")
    public void userEnterInSearchInput(String searchInput) {
        landingPage.search(searchInput);
        System.out.println("User has entered " + searchInput);
    }

    @Then("that product should appear in result.")
    public void thatProductShouldAppearInResult() {
        List<String> searchedProducts=landingPage.getSearchResult();
        for(String product:searchedProducts){
            System.out.println(product);
        }
    }

    @Given("user is on landingPage")
    public void userIsOnLandingPage() {
        context.openURL(context.jsonConfigData.getString("url"));
        System.out.println("User is on LandingPage...");
        String favTabText=context.getDriver().getTitle();
        context.assertion.assertEquals(favTabText,"GreenKart - veg and fruits kart");
    }

    @When("user click on AddToCart button Once")
    public void userClickOnAddToCartButtonOnce() {
//        random=new Random();
       int  randomProductIndex1=random.nextInt(31);
        String actualResult=landingPage.addProduct(randomProductIndex1);
        context.assertion.assertEquals(actualResult,"✔ ADDED","AddToCart button is not clicked");
    }


    @When("user increase the product quantity by {int}")
    public void userIncreaseTheProductQuantityBy(int qty) {
        randomProductIndex=random.nextInt(31);
        int initialProductQty=landingPage.getQtyDisplayingForProduct(randomProductIndex);
        landingPage.increaseQty(randomProductIndex, qty);
        context.assertion.assertTrue(landingPage.getQtyDisplayingForProduct(randomProductIndex)>initialProductQty,
                "Product qty doesn't increased");
    }

    @Then("quantity should appear {int}")
    public void quantityShouldAppear(int qty) {
        context.assertion.assertEquals(landingPage.getQtyDisplayingForProduct(randomProductIndex),qty+1,"Product qty added incorrectly");
    }


    @And("user should able to decrease quantity to minimum")
    public void userShouldAbleToDecreaseQuantityToMinimum() {
     landingPage.decreaseQty(randomProductIndex);
        context.assertion.assertEquals(landingPage.getQtyDisplayingForProduct(randomProductIndex),1,"Product qty added incorrectly");

    }

    @When("all products appears")
    public void allProductsAppears() {
///
    }

    @Then("product images are not broken")
    public void productImagesAreNotBroken() {
        landingPage.isAnyProductImageBroken();
    }

    @Then("product details are same as jsonData")
    public void productDetailsAreSameAsJsonData() {
    }
}
