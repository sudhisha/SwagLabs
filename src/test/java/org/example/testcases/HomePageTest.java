package org.example.testcases;

import org.example.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTest {
    HomePage hp;
    LoginTest lt;
    @BeforeMethod
    public void setup(){
        hp = new HomePage();
        lt = new LoginTest();
        hp.setUp();
        lt.login_with_valid_inputs();
    }
    @Test
    public void verify_ProductsList_Visibility(){
        assertTrue(hp.productsVisibility());
    }
    @Test
    public void verify_MenuButton_Visibility(){
        assertTrue(hp.menuVisibility());
    }
    @Test
    public void add_firstProduct_toCart(){
        hp.clickCart();
        assertEquals(hp.verify_buttonName(),"Remove");
        assertEquals(hp.verify_cartBadge(),"1");
        hp.click_cartLink();
        assertTrue(hp.verifyCartPage().contains("cart.html"));
        assertTrue(hp.verify_prd_qty());
        assertTrue(hp.verify_prd_name());
        assertTrue(hp.verify_prd_desc());
        assertTrue(hp.verify_prd_price());
    }
    @Test
    public void remove_Product_from_HomePage(){
        hp.clickCart();
        assertEquals(hp.verify_buttonName(),"Remove");
        assertEquals(hp.verify_cartBadge(),"1");
        hp.click_removebutton();
        assertEquals(hp.verify_addtocart_buttonName(),"Add to cart");
        assertFalse(hp.display_cartBadge());
    }
    @Test
    public void verify_AboutPage(){
        hp.clickMenu();
        hp.clickAbout();
        assertEquals(hp.verifycurrentURL(),"https://saucelabs.com/");
    }
    @Test
    public void verify_Filter_DropDown_visibility(){
        assertTrue(hp.verifyFilterDpDn());
    }
    @Test
    public void Filter_Products_Name_AtoZ(){
        verify_Filter_DropDown_visibility();
        hp.clickFilter();
        hp.selectNameAtoZ("az");
        assertTrue(hp.verify_prdNames_Order(1));
    }
    @Test
    public void Filter_Products_Name_ZtoA(){
        verify_Filter_DropDown_visibility();
        hp.clickFilter();
        hp.selectNameAtoZ("za");
        assertTrue(hp.verify_prdNames_Order(2));
    }
    @Test
    public void Filter_Products_Price_LowtoHigh(){
        verify_Filter_DropDown_visibility();
        hp.clickFilter();
        hp.selectNameAtoZ("lohi");
        assertTrue(hp.verify_prdPrices_Order(3));
    }
    @Test
    public void Filter_Products_Price_HightoLow(){
        verify_Filter_DropDown_visibility();
        hp.clickFilter();
        hp.selectNameAtoZ("hilo");
        assertTrue(hp.verify_prdPrices_Order(4));
    }
    @AfterMethod
    public void teardown(){
        hp.tearDown();
    }
}
