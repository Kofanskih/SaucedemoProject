package tests;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.pageModels.UserLoginPageModel;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ProductsTest {
    private String countOne = "1";
    private String countZero = "0";

    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
    }

    @Test
    void userAddItemToCart(){
        new ProductsPage()
                .userAddOneItemToCart()
                .checkCountOfItemInTheCart(countOne);
    }

    @Test
    void userRemoveAddedItemFromCartOnTheProductsPage(){
        new ProductsPage()
                .userAddOneItemToCart()
                .userRemoveOneAddedItemFromCartOnTheProductPage()
                .checkEmptyCountCartBadge();
    }
}
