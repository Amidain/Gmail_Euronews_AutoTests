package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final IButton newslettersButton = AqualityServices.getElementFactory().getButton(By.className("u-margin-start-1"), "Newsletter Button");

    public MainPage() {
        super(By.xpath("//meta[@name='app-context' and @content='home']"), "Main Page");
    }

    public boolean isMainPageOpen(){
        return state().waitForEnabled();
    }

    public void clickNewsletterButton(){
        newslettersButton.click();
    }
}
