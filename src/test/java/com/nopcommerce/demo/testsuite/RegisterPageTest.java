package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }
    @Test(groups = {"sanity","regression", "smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterPageText("Register");

    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();
        registerPage.registerButtonClick();
        registerPage.verifyFirstNameErrorMessage("First name is required");
        registerPage.verifyLastNameErrorMessage("Last name is required");
        registerPage.verifyEmailErrorMessage("Email is required");
        registerPage.verifyPasswordErrorMessage("Password is required");
        registerPage.verifyConfirmPasswordErrorMessage("Password is required");
    }
    @Test(groups = {"regression"})
    public void verifyThatUsersShouldCreateAccountSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Female");
        registerPage.firstNameClick("Heena");
        registerPage.lastNameClick("Patel");
        registerPage.selectDateOfBirth("1","May","1999");
        registerPage.enterEmailId(("heena1@gmail.com"));
        registerPage.passwordClick("Heena321");
        registerPage.confirmPasswordClick("Heena321");
        registerPage.registerButtonClick();
        registerPage.verifyRegisterPageText(" Your registration is completed");
    }
}
