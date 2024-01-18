package StepDefinitionFiles;

import PageObjects.Cart;
import TestContext.TestContext;
import io.cucumber.java.en.Then;

public class CartStepDefinition {

    private TestContext context;
    private Cart cart;
    public CartStepDefinition( TestContext context){
        this.context=context;
        cart=context.getPageObject().getCartObject();
    }

    @Then("product is added to Cart")
    public void productIsAddedToCart() {
        cart.getAddedProductCount();
    }

    @Then("product count should be {int}")
    public void productCountShouldBe(int qty) {
        context.assertion.assertEquals(cart.getAddedProductCount(),qty,"Qty mismatched");
    }
}
