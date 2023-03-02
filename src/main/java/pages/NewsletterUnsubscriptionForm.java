package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NewsletterUnsubscriptionForm extends Form {
    private final ISettingsFile CONFIG_READER = new JsonSettingsFile("config.json");
    private final ITextBox emailAddressInputBox = AqualityServices.getElementFactory().getTextBox(By.className("form-control"), "Email Address Input Box");
    private final ITextBox unsubscriptionConfirmationTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//strong"), "Unsubscription Confirmation Text Box");
    private final IButton confirmUnsubscriptionButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Confirm Unsubscription Button" );

    public NewsletterUnsubscriptionForm() {
        super(By.cssSelector(".col-md-6.col-md-offset-3.text-center"),"Newsletter Unsubscription");
    }

    public boolean isNewsletterUnsubscriptionFormDisplayed(){
        return state().waitForDisplayed();
    }

    public void fillOutEmailAddressInputBox(){
        emailAddressInputBox.clearAndType(CONFIG_READER.getValue("/gmail/mail").toString());
    }

    public void clickConfirmUnsubscriptionButton(){
        confirmUnsubscriptionButton.click();
    }

    public boolean isUnsubscriptionConfirmationTextBoxDisplayed(){
        return unsubscriptionConfirmationTextBox.state().waitForDisplayed();
    }
}
