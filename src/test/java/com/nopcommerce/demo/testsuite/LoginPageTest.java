package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();  // creating Object. when my test run that time i will crate Object
        loginPage = new LoginPage(); // intilize element runtime first
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "regression", "smoke"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomText("Welcome,Please Sign In!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.randomEmailId();
        loginPage.enterPassword("Prime");
        loginPage.ClickOnLoginButton();
        loginPage.verifyErrorMessage("Login was unsucessful.Please correct the errors and try again");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.randomEmailId();
        loginPage.enterPassword("prime123");
        loginPage.ClickOnLoginButton();
        loginPage.verifyErrorMessage("Unsuccesful login");

    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.randomEmailId();
        loginPage.enterPassword("Prime123");
        loginPage.ClickOnLoginButton();
        loginPage.verifyErrorMessage("Unsuccesful login");
    }
}

