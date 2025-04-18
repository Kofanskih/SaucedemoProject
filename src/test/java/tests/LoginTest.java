package tests;

import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    private String productsHeader = "Products";
    private String incorrectLoginWarningMessage = "Epic sadface: Username and password do not match any user in this service";
    private String lockedLoginWarningMessage = "Epic sadface: Sorry, this user has been locked out.";


    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }

    @Test
    void userLogin(){
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
        new ProductsPage().userShouldHaveCartLinkOnProductsPage(productsHeader);

    }

    @Test
    void userIncorrectLogin(){
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().incorrectUserLogin());
        new LoginPage()
                .checkWarningMessage(incorrectLoginWarningMessage);

    }

    @Test
    void userLockedLogin(){
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().lockedUserLogin());
        new LoginPage()
                .checkWarningMessage(lockedLoginWarningMessage);

    }
}
