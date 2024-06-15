package org.example.pages;

import org.example.base.SwagLabsBase;
import org.openqa.selenium.By;

public class Login extends SwagLabsBase {
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By loginfailmsg = By.xpath(".//h3[text()=\"Epic sadface: Username and password do not match any user in this service\"]");
    By loginfailmsg1 = By.xpath(".//h3[text()=\"Epic sadface: Username is required\"]");
    By logOut = By.id("logout_sidebar_link");
    By menuButton = By.id("react-burger-menu-btn");

    public void enterUsername(String uname){
        driver.findElement(username).sendKeys(uname);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public String verifyLoginPage() {
        return driver.getCurrentUrl();
    }
    public boolean verifyFailureLoginPage() {
        return driver.findElement(loginfailmsg).isDisplayed();
    }
    public boolean verifyEmptyIPFailureMsg() {
        return driver.findElement(loginfailmsg1).isDisplayed();
    }
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }
    public void ClickLogOut() {
        driver.findElement(logOut).click();
    }

}
