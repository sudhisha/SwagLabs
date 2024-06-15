package org.example.pages;

import org.example.base.SwagLabsBase;
import org.openqa.selenium.By;

public class Cart extends SwagLabsBase {
    By removeButtonName = By.id("remove-sauce-labs-backpack");
    By continueButton = By.name("continue-shopping");
    By checkOutButton = By.name("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By addToCart1 = By.id("add-to-cart-sauce-labs-backpack");
    By cartLink = By.xpath(".//a[@class=\"shopping_cart_link\"]");
    By cartqty = By.xpath("(.//div[@class=\"cart_quantity\"])[1]");
    By cartprdname = By.xpath("(.//div[@class=\"inventory_item_name\"])[1]");
    By cartpdesc = By.xpath("(.//div[@class=\"inventory_item_desc\"])[1]");
    By cartprice = By.xpath("(.//div[@class=\"inventory_item_price\"])[1]");
    By cartbadge = By.xpath(".//span[@class=\"shopping_cart_badge\"]");
    By chkoutovrvw = By.xpath(".//span[text()=\"Checkout: Overview\"]");
    By paymentInfo = By.xpath("(.//div[@class=\"summary_info_label\"])[1]");
    By shippingInfo = By.xpath("(.//div[@class=\"summary_info_label\"])[2]");
    By priceTotal = By.xpath("(.//div[@class=\"summary_info_label\"])[3]");
    By finishButton = By.id("finish");
    By cancelButton = By.id("cancel");
    By thankyoumsg = By.xpath(".//h2[text()=\"Thank you for your order!\"]");
    By backHome = By.id("back-to-products");

    public void click_remove_cart(){
        driver.findElement(removeButtonName).click();
    }
    public String verifyContinueShopping() {
        driver.findElement(continueButton).click();
        return driver.getCurrentUrl();
    }
    public void click_CheckOut() {
        driver.findElement(checkOutButton).click();
    }
    public String verifyCheckOutPage() {
        return driver.getCurrentUrl();
    }
    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }
    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }
    public void enterZip(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }
    public void clickContinue() {
        driver.findElement(continueBtn).click();
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
    public String verifyCartPage() {
        return driver.getCurrentUrl();
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
    public boolean verifyCheckOutOverviewHeading() {
        return driver.findElement(chkoutovrvw).isDisplayed();
    }
    public boolean verifyPaymentInfo() {
        return driver.findElement(paymentInfo).isDisplayed();
    }
    public boolean verifyShippingInfo() {
        return driver.findElement(shippingInfo).isDisplayed();
    }
    public boolean verifyPriceTotal() {
        return driver.findElement(priceTotal).isDisplayed();
    }
    public void click_Finish() {
        driver.findElement(finishButton).click();
    }
    public void click_Cancel() {
        driver.findElement(cancelButton).click();
    }
    public boolean verifyThankYouMsg() {
        return driver.findElement(thankyoumsg).isDisplayed();
    }
    public void click_BackHome() {
        driver.findElement(backHome).click();
    }
}
