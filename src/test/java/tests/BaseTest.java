package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private final ISettingsFile CONFIG_READER = new JsonSettingsFile("config.json");
    private final String EURONEWS_URL = CONFIG_READER.getValue("/euronews-url").toString();

    @BeforeMethod
    protected void beforeMethod(){
        RestAssured.registerParser("text/html", Parser.JSON);
        AqualityServices.getBrowser().goTo(EURONEWS_URL);
        AqualityServices.getBrowser().waitForPageToLoad();
        AqualityServices.getBrowser().maximize();
    }

    @AfterMethod
    protected void  afterTest(){
        if (AqualityServices.isBrowserStarted()){
            AqualityServices.getBrowser().quit();
        }
    }
}

