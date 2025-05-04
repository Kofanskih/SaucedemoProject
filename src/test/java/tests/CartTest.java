package tests;

import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    private String cartHeader = "Your Cart";
    private String productsHeader = "Products";


    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
    }

    @Test
    public void userGoToTheCart(){
        new ProductsPage()
                .userGoToCart()
                .checkUserOnTheCart(cartHeader);
    }

    @Test
    public void userRemoveItemFromCart(){
        new ProductsPage()
                .userAddFirstItemToCart()
                .userGoToCart()
                .userRemoveFirstItemFromCart()
                .checkRemovedItem();
    }

    @Test
    public void userGoToContinueShoppingFromCartPage(){
        new ProductsPage()
                .userGoToCart()
                .userGoToContinueShopping()
                .checkHeaderOnProductsPage(productsHeader);
    }
}
