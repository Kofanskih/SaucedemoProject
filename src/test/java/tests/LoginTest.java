package tests;

import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    private String productsHeader = "Products";
    private String incorrectLoginWarningMessage = "Epic sadface: Username and password do not match any user in this service";
    private String lockedLoginWarningMessage = "Epic sadface: Sorry, this user has been locked out.";

    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUpRemote("http://143.198.129.173");
    }

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
    }


    @Test
    @Issue("AUTH-123")
    @Severity(SeverityLevel.CRITICAL)
    void userLogin(){
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
        new ProductsPage().checkHeaderOnProductsPage(productsHeader);

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
