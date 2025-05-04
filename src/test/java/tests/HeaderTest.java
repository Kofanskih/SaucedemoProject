package tests;

import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.HeaderPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest{
    private String booleanFalse = "false";
    private String booleanTrue = "true";
    private String headerSaucelabs = "Build apps users love with AI-driven insights";
    private String loginLogo = "Swag Labs";

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
    }

    @Test
    public void sideBarIsOpen(){
        new HeaderPage()
                .openSideBar()
                .checkSideBarIsDisplayed(booleanFalse);
    }

    @Test
    public void transitionToAboutPage(){
        new HeaderPage()
                .openSideBar()
                .openAboutLink()
                .checkTransitionToAboutPage(headerSaucelabs);
    }

    @Test
    public void userLogout(){
        new HeaderPage()
                .openSideBar()
                .userLogout()
                .checkUserLogout(loginLogo);
    }
}
