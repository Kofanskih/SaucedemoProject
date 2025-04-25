package tests;

import com.saucedemo.pageModels.UserCheckoutPageModel;
import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.*;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutOverviewTest {
    private String checkoutOverviewHeader = "Checkout: Overview";
    private String productsHeader = "Products";
    private String thankYouHeader = "Thank you for your order!";

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
        new CartPage()
                .userGoToCheckout();
    }

    @Test
    public void userGoToCheckoutOverview(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel()
                        .fullUserData())
                .checkUserGoToCheckoutOverview(checkoutOverviewHeader);
    }

    @Test
    public void userCancelCheckoutOverview(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel()
                        .fullUserData())
                .userClickCancelButton()
                .checkHeaderOnProductsPage(productsHeader);
    }

    @Test
    public void userFinishCheckout(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel()
                        .fullUserData())
                .userFinishOrder()
                .checkUserCompleteCheckout(thankYouHeader);
    }
}
