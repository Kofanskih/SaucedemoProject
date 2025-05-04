package tests;

import com.saucedemo.utils.ConfigurateBrowserSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.saucedemo.utils.OwnerReadUrl.ownerRemoteUrl;
import static com.saucedemo.utils.OwnerReadUrl.readMainUrl;

public class BaseTest {

    @BeforeSuite
    public void baseTest(){
        System.out.println(readMainUrl());
        System.out.println(ownerRemoteUrl());
    }

    @BeforeClass
    void preConditionClass(){
        new ConfigurateBrowserSettings().setUpRemote();
    }
}
