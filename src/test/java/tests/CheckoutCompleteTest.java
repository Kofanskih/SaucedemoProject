package tests;

import com.saucedemo.pageModels.UserCheckoutPageModel;
import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.*;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutCompleteTest {
    private String productsHeader = "Products";

    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUpRemote();
    }

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
        new ProductsPage().userGoToCart();
        new CartPage()
                .userGoToCheckout()
                .fillCheckoutInfo(new UserCheckoutPageModel()
                        .fullUserData())
                .userFinishOrder();
    }

    @Test
    public void userClickBackHomeButton(){
        new CheckoutCompletePage()
                .userClickBackHomeButton()
                .checkHeaderOnProductsPage(productsHeader);

    }
}
