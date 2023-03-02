package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PreAuthorizedSubscriptionForm extends Form {

    public PreAuthorizedSubscriptionForm() {
        super(By.id("additional-data-modal"), "Pre-Authorization Subscription Form");
    }

    public boolean isPreAuthorizedSubscriptionFormDisplayed(){
        return state().waitForDisplayed();
    }
}
