package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SubscriptionPlanEmailForm extends Form {
    private final ISettingsFile CONFIG_READER = new JsonSettingsFile("config.json");
    private final ITextBox emailTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@class='w-full' and @type='email']"), "Email Text Box");
    private final IButton submitEmailFormButton = AqualityServices.getElementFactory().getButton(By.xpath("//input[contains(@class,'btn-primary') and @type='submit']"), "Submit Email Form Button");

    public SubscriptionPlanEmailForm() {
        super(By.id("register-newsletters-form"), "Subscription Plan Email Form");
    }

    public boolean isSubscriptionPlanEmailFormDisplayed(){
        return state().waitForDisplayed();
    }

    public void fillOutEmailTextBox() {
        emailTextBox.sendKeys(CONFIG_READER.getValue("/gmail/mail").toString());
    }

    public void clickSubmitEmailFormButton(){
        submitEmailFormButton.clickAndWait();
    }
}
