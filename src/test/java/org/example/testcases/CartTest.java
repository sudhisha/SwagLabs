package org.example.testcases;

import org.example.pages.Cart;
import org.example.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest {
    Cart cp;
    LoginTest lt;
    HomePageTest ht;
    @BeforeMethod
    public void setup(){
        cp = new Cart();
        lt = new LoginTest();
        ht = new HomePageTest();
        cp.setUp();
        lt.login_with_valid_inputs();
    }
    public void add_firstProduct_toCart(){
        cp.clickCart();
        assertEquals(cp.verify_buttonName(),"Remove");
        assertEquals(cp.verify_cartBadge(),"1");
        cp.click_cartLink();
        assertTrue(cp.verifyCartPage().contains("cart.html"));
        assertTrue(cp.verify_prd_qty());
        assertTrue(cp.verify_prd_name());
        assertTrue(cp.verify_prd_desc());
        assertTrue(cp.verify_prd_price());
    }
    @Test
    public void remove_Product_from_Cart(){
        add_firstProduct_toCart();
        cp.click_remove_cart();
    }
    @Test
    public void verify_continue_shopping_in_Cart(){
        add_firstProduct_toCart();
        assertTrue(cp.verifyContinueShopping().contains("inventory.html"));
    }
    public void checkOut() {
        add_firstProduct_toCart();
        cp.click_CheckOut();
        assertTrue(cp.verifyCheckOutPage().contains("checkout-step-one.html"));
        cp.enterFirstName("Sudhi");
        cp.enterLastName("P");
        cp.enterZip("786456");
        cp.clickContinue();
        assertTrue(cp.verifyCheckOutPage().contains("checkout-step-two.html"));
        assertTrue(cp.verifyCheckOutOverviewHeading());
        assertTrue(cp.verifyPaymentInfo());
        assertTrue(cp.verifyShippingInfo());
        assertTrue(cp.verifyPriceTotal());
    }
    @Test
    public void verify_checkOut_FinishButton(){
        checkOut();
        cp.click_Finish();
        assertTrue(cp.verifyCheckOutPage().contains("checkout-complete.html"));
        assertTrue(cp.verifyThankYouMsg());
        cp.click_BackHome();
        assertTrue(cp.verifyCheckOutPage().contains("inventory.html"));
    }
    @Test
    public void verify_checkOut_cancelButton(){
        checkOut();
        cp.click_Cancel();
        assertTrue(cp.verifyCheckOutPage().contains("inventory.html"));
    }
    @AfterMethod
    public void teardown(){
        cp.tearDown();
    }
}
