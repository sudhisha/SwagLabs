package org.example.testcases;

import org.example.pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    Login lp= new Login();
    @BeforeMethod
    public void setup(){
        lp.setUp();
    }
    @Test
    public void login_with_valid_inputs(){
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLoginButton();
        assertTrue(lp.verifyLoginPage().contains("inventory.html"));
    }
    @Test
    public void login_with_invalid_inputs(){
        lp.enterUsername("testing");
        lp.enterPassword("testing123");
        lp.clickLoginButton();
        assertTrue(lp.verifyFailureLoginPage());
    }
    @Test
    public void login_with_invalid_username(){
        lp.enterUsername("testing");
        lp.enterPassword("secret_sauce");
        lp.clickLoginButton();
        assertTrue(lp.verifyFailureLoginPage());
    }
    @Test
    public void login_with_invalid_password(){
        lp.enterUsername("standard_user");
        lp.enterPassword("testing123");
        lp.clickLoginButton();
        assertTrue(lp.verifyFailureLoginPage());
    }
    @Test
    public void login_with_empty_Inputs(){
        lp.enterUsername("");
        lp.enterPassword("");
        lp.clickLoginButton();
        assertTrue(lp.verifyEmptyIPFailureMsg());
    }
    @Test
    public void logOut(){
        login_with_valid_inputs();
        lp.clickMenu();
        lp.ClickLogOut();
        assertEquals(lp.verifyLoginPage(),"https://www.saucedemo.com/");
    }
    @AfterMethod
    public void teardown(){
        lp.tearDown();
    }
}
