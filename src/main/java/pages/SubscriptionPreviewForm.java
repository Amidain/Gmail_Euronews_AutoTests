package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.TextBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SubscriptionPreviewForm extends Form {
    private final ITextBox unsubscribeButton = AqualityServices.getElementFactory().getTextBox(By.xpath("//a[contains(@href, 'https://services.ownpage.fr/unsubscribe/')]"), "Unsubscribe Button");
    private final ITextBox previewForm = AqualityServices.getElementFactory().getTextBox(By.cssSelector(".jquery-modal.blocker.current"), "Preview Form");

    public SubscriptionPreviewForm() {
        super(By.cssSelector(".jquery-modal.blocker.current"), "Subscription Preview Form");
    }

    public boolean isSubscriptionPreviewWindowDisplayed(){
        return state().waitForDisplayed();
    }

    public void clickUnsubscribeButton(){
        TextBox iframe = previewForm.findChildElement(By.className("iframe-preview"), ElementType.TEXTBOX);
        AqualityServices.getBrowser().getDriver().switchTo().frame(iframe.getElement());
        unsubscribeButton.getJsActions().scrollIntoView();
        AqualityServices.getBrowser().goTo(unsubscribeButton.getAttribute("href"));
    }
}
