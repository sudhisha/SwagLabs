package org.example.pages;

import org.example.base.SwagLabsBase;
import org.openqa.selenium.By;

public class HomePage extends SwagLabsBase {
    By products = By.xpath(".//span[text()=\"Products\"]");
    By cartbadge = By.xpath(".//span[@class=\"shopping_cart_badge\"]");
    By menu = By.id("react-burger-menu-btn");
    By addToCart1 = By.id("add-to-cart-sauce-labs-backpack");
    By removeButtonName = By.id("remove-sauce-labs-backpack");
    By cartLink = By.xpath(".//a[@class=\"shopping_cart_link\"]");
    By cartqty = By.xpath("(.//div[@class=\"cart_quantity\"])[1]");
    By cartprdname = By.xpath("(.//div[@class=\"inventory_item_name\"])[1]");
    By cartpdesc = By.xpath("(.//div[@class=\"inventory_item_desc\"])[1]");
    By cartprice = By.xpath("(.//div[@class=\"inventory_item_price\"])[1]");
    public boolean productsVisibility(){
        return driver.findElement(products).isDisplayed();
    }
    public boolean menuVisibility(){
        return driver.findElement(menu).isDisplayed();
    }
    public void clickCart(){
        driver.findElement(addToCart1).click();
    }
    public String verify_buttonName(){
        return driver.findElement(removeButtonName).getText();
    }
    public String verify_cartBadge(){
        return driver.findElement(cartbadge).getText();
    }
    public void click_cartLink(){
        driver.findElement(cartLink).click();
    }
    public boolean verify_prd_qty(){
        return driver.findElement(cartqty).isDisplayed();
    }
    public boolean verify_prd_name(){
        return driver.findElement(cartprdname).isDisplayed();
    }
    public boolean verify_prd_desc(){
        return driver.findElement(cartpdesc).isDisplayed();
    }
    public boolean verify_prd_price(){
        return driver.findElement(cartprice).isDisplayed();
    }
    public String verifyCartPage() {
        return driver.getCurrentUrl();
    }
    public void clickMenu(){
        driver.findElement(menu).click();
    }
    public String verifycurrentURL() {
        return driver.getCurrentUrl();
    }
}
