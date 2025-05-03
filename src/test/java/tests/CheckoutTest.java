package tests;

import com.saucedemo.pageModels.UserCheckoutPageModel;
import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.*;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest {
    private String checkoutHeader = "Checkout: Your Information";
    private String cartHeader = "Your Cart";
    private String warningFirstName = "Error: First Name is required";
    private String warningLastName = "Error: Last Name is required";
    private String warningPostalCode = "Error: Postal Code is required";


    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUpRemote("http://143.198.129.173");
    }

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
        new ProductsPage().userGoToCart().userGoToCheckout();
    }

    @Test
    public void userGoToCheckout(){
        new CheckoutPage()
                .checkUserOnTheCheckoutPage(checkoutHeader);
    }

    @Test
    public void userCancelCheckout(){
        new CheckoutPage()
                .userCancelCheckout()
                .checkUserOnTheCart(cartHeader);
    }

    @Test
    public void userLeftEmptyFields(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel().userEmptyData());
        new CheckoutPage()
                .checkWarningMessageAfterFillIncorrectData(warningFirstName);

    }

    @Test
    public void userLeftFirstNameEmpty(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel().userDataWithoutFirstName());
        new CheckoutPage()
                .checkWarningMessageAfterFillIncorrectData(warningFirstName);

    }

    @Test
    public void userLeftLastNameEmpty(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel().userDataWithoutLastName());
        new CheckoutPage()
                .checkWarningMessageAfterFillIncorrectData(warningLastName);

    }
    @Test
    public void userLeftPostalCodeEmpty(){
        new CheckoutPage()
                .fillCheckoutInfo(new UserCheckoutPageModel().userDataWithoutPostalCode());
        new CheckoutPage()
                .checkWarningMessageAfterFillIncorrectData(warningPostalCode);

    }




}
