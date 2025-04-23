package tests;

import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest {
    private String checkoutHeader = "Checkout: Your Information";
    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
        new ProductsPage().userGoToCart();
    }

    @Test
    public void userGoToCheckout(){
        new CartPage()
                .userGoToCheckout()
                .checkUserOnTheCheckoutPage(checkoutHeader);
    }
}
