package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PrivacyPolicy extends Form {
    private final IButton continueWithoutAgreeingButton = AqualityServices.getElementFactory().getButton(By.className("didomi-continue-without-agreeing"), "Continue Without Agreeing Button");

    public PrivacyPolicy() {
        super(By.className("didomi-popup-view"),"Privacy Policy");
    }

    public boolean isPrivacyPolicyDisplayed (){
        return state().waitForDisplayed();
    }

    public void clickContinueWithoutAgreeingButton(){
        continueWithoutAgreeingButton.click();
    }
}
