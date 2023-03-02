package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SuccessfulSubscriptionConfirmationForm extends Form {

    private final IButton backToTheSiteButton = AqualityServices.getElementFactory().getButton(By.cssSelector(".c-link.c-link--btn.enw-btn__confirmation.u-float-end"), "Back to the site button");
    public SuccessfulSubscriptionConfirmationForm() {
        super(By.className("enw-block-confirmation__text"), "Successful Subscription Confirmation");
    }

    public boolean isSuccessfulSubscriptionConfirmationDisplayed(){
        return state().waitForDisplayed();
    }

    public void clickBackToTheSiteButton(){
        backToTheSiteButton.click();
    }
}
