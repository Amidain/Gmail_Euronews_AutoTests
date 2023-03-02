package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.TextBox;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class NewsletterMenu extends Form {

    private final ITextBox newsletterSubscriptionPlanContainer = AqualityServices.getElementFactory().getTextBox(By.id("newsletters-form"), "Newsletter Subscription Plan Container");
    private ITextBox chosenSubscriptionPlan = null;
    public NewsletterMenu() {
        super(By.xpath("//span[text()='Our newsletters']"), "Newsletter Menu");
    }

    public boolean isNewsletterMenuOpen(){
        return state().waitForDisplayed();
    }

    public void selectRandomSubscriptionPlan(){
        List<TextBox> subscriptionPlans = newsletterSubscriptionPlanContainer.findChildElements(By.cssSelector(".bg-white.shadow-lg"), ElementType.TEXTBOX);
        Random random = new Random();
        int subscriptionPlanNumber = random.nextInt(subscriptionPlans.size() - 1);
        subscriptionPlans.get(subscriptionPlanNumber).findChildElement(By.cssSelector(".block.w-full.btn-tertiary.unchecked-label.cursor-pointer"), ElementType.TEXTBOX).click();;
        chosenSubscriptionPlan = subscriptionPlans.get(subscriptionPlanNumber);
    }

    public void choosePreviouslySelectedSubscriptionPlanAndOpenSubscriptionPreview(){
        chosenSubscriptionPlan.getJsActions().scrollIntoView();
        chosenSubscriptionPlan.findChildElement(By.cssSelector(".block.w-full.btn-tertiary.unchecked-label.cursor-pointer"), ElementType.TEXTBOX).click();
        IButton seePreviewButton = chosenSubscriptionPlan.findChildElement(By.cssSelector(".text-primary.mt-3.inline-block"), ElementType.BUTTON);
        seePreviewButton.click();
    }
}
