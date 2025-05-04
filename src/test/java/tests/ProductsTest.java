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

public class ProductsTest extends BaseTest {
    private String countOne = "1";
    private SelenideElement descendingSort = $("[value=\"za\"]");
    private String descendingOption = "Name (Z to A)";
    private SelenideElement ascendingSort = $("[value=\"az\"]");
    private String ascendingOption = "Name (A to Z)";
    private SelenideElement priceLowToHighSort = $("[value=\"lohi\"]");
    private String priceLowToHighOption = "Price (low to high)";
    private SelenideElement priceHighToLowSort = $("[value=\"hilo\"]");
    private String priceHighToLowOption = "Price (high to low)";


    @BeforeMethod
    void preconditionMethod(){
        new BasePage().open();
        new LoginPage()
                .fillLoginDataWithUserModel(new UserLoginPageModel().userLogin());
    }

    @Test
    void userAddItemToCart(){
        new ProductsPage()
                .userAddFirstItemToCart()
                .checkCountOfItemInTheCart(countOne);
    }

    @Test
    void userRemoveAddedItemFromCartOnTheProductsPage(){
        new ProductsPage()
                //.userAddFirstItemToCart()
                .userRemoveOneAddedItemFromCartOnTheProductPage()
                .checkEmptyCountCartBadge();
    }

    @Test
    void userSelectDescendingSorting(){
        new ProductsPage()
                .sortItemsBySelectedOption(descendingSort)
                .checkSortingOption(descendingOption);
    }

    @Test
    void userSelectAscendingSorting(){
        new ProductsPage()
                .sortItemsBySelectedOption(ascendingSort)
                .checkSortingOption(ascendingOption);
    }

    @Test
    void userSelectPriceFromLowToHighSorting(){
        new ProductsPage()
                .sortItemsBySelectedOption(priceLowToHighSort)
                .checkSortingOption(priceLowToHighOption);
    }

    @Test
    void userSelectPriceFromHighToLowSorting(){
        new ProductsPage()
                .sortItemsBySelectedOption(priceHighToLowSort)
                .checkSortingOption(priceHighToLowOption);
    }
}
