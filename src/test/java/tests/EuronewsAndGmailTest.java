package tests;

import aquality.selenium.browser.AqualityServices;
import model.Message;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import util.ApiRequests;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class EuronewsAndGmailTest extends BaseTest {

    @Test
    void test () throws InterruptedException {
        MainPage mainPage = new MainPage();
        PrivacyPolicy privacyPolicy = new PrivacyPolicy();
        NewsletterMenu newsletterMenu = new NewsletterMenu();
        SubscriptionPlanEmailForm subscriptionPlanEmailForm = new SubscriptionPlanEmailForm();
        SuccessfulSubscriptionConfirmationForm successfulSubscriptionConfirmationForm = new SuccessfulSubscriptionConfirmationForm();
        SubscriptionPreviewForm subscriptionPreviewForm = new SubscriptionPreviewForm();
        NewsletterUnsubscriptionForm newsletterUnsubscriptionForm = new NewsletterUnsubscriptionForm();
        PreAuthorizedSubscriptionForm preAuthorizedSubscriptionForm = new PreAuthorizedSubscriptionForm();

        ApiRequests.markAllMessagesAsRead();
        Assert.assertTrue(privacyPolicy.isPrivacyPolicyDisplayed(), "Privacy Policy has not been displayed!");
        privacyPolicy.clickContinueWithoutAgreeingButton();
        Assert.assertTrue(mainPage.isMainPageOpen(), "Main page has not been open!");
        mainPage.clickNewsletterButton();
        Assert.assertTrue(newsletterMenu.isNewsletterMenuOpen(), "Newsletter Menu has not been open!");
        newsletterMenu.selectRandomSubscriptionPlan();
        Assert.assertTrue(subscriptionPlanEmailForm.isSubscriptionPlanEmailFormDisplayed(), "Subscription Plan Email Form has not been open!");
        subscriptionPlanEmailForm.fillOutEmailTextBox();
        subscriptionPlanEmailForm.clickSubmitEmailFormButton();
        Assert.assertTrue(preAuthorizedSubscriptionForm.isPreAuthorizedSubscriptionFormDisplayed(), "Pre Authorized Subscription Form has not been displayed!");

        String latestMessageId = ApiRequests.extractLatestMessageId();
        Message msg = ApiRequests.getMessageById(latestMessageId);
        Assert.assertTrue(msg.getPayload().getHeaders().stream().filter(x -> x.getName().equals("Subject")&&x.getValue().startsWith("Euronews")).findFirst().isPresent(), "There is no message received to confirm subscription in Euronews Platfrom!");
        ApiRequests.markMessageAsRead(latestMessageId);
        String data = msg.getPayload().getParts().get(0).getBody().getData();
        String decodedData = new String(Base64.getUrlDecoder().decode(data));
        List<String> redirectURLs = Arrays.stream(decodedData.split("\"")).filter(x -> x.contains("https://redir.")).collect(Collectors.toList());

        AqualityServices.getBrowser().goTo(redirectURLs.get(0));

        Assert.assertTrue(successfulSubscriptionConfirmationForm.isSuccessfulSubscriptionConfirmationDisplayed(), "Successful Subscription confirmation has not been displayed!");
        successfulSubscriptionConfirmationForm.clickBackToTheSiteButton();
        Assert.assertTrue(mainPage.isMainPageOpen(), "Main page has not been open!");
        mainPage.clickNewsletterButton();
        Assert.assertTrue(newsletterMenu.isNewsletterMenuOpen(), "Newsletter Menu has not been open!");
        newsletterMenu.choosePreviouslySelectedSubscriptionPlanAndOpenSubscriptionPreview();
        Assert.assertTrue(subscriptionPreviewForm.isSubscriptionPreviewWindowDisplayed(), "Subscription Preview Form has not been displayed!");
        subscriptionPreviewForm.clickUnsubscribeButton();
        Assert.assertTrue(newsletterUnsubscriptionForm.isNewsletterUnsubscriptionFormDisplayed(), "Newsletter Unsubscription Form has not been displayed!");
        newsletterUnsubscriptionForm.fillOutEmailAddressInputBox();
        newsletterUnsubscriptionForm.clickConfirmUnsubscriptionButton();

        Assert.assertTrue(newsletterUnsubscriptionForm.isUnsubscriptionConfirmationTextBoxDisplayed(), "Unsubscription failed, confirmation has not been displayed!");
    }
}
