package cucumberTests.stepdefs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.com.entities.Users;

import java.util.Locale;
import java.util.NoSuchElementException;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.logInPage;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.BasketPage.*;
import static io.github.com.pages.LogInPage.loginForm;
import static io.github.com.pages.LoginPageFrame.acceptCookiesButton;
import static io.github.com.pages.RegistrationPage.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStepdefs {

    @And("^input random email in email field$")
    public void iInputRandomNameIn() {
        String email = Users.randomEmail();
        //Allure.addAttachment("Email: ", email);
        emailField.sendKeys(email);
        //input(Users.randomEmail()).input(value);
    }

    @And("^choose Title$")
    public void chooseTitle() throws InterruptedException {
        Thread.sleep(2000);
        int rndNumber = randomNumber(selectTitleButton.size());
        selectTitleButton.get(rndNumber).click();
    }

    @And("^choose Profession$")
    public void chooseProfession() {
        int rndNumber = randomNumber(selectProfessionButton.size());
        selectProfessionButton.get(rndNumber).click();
    }

    @And("^selects Address$")
    public void selectsAddress() throws InterruptedException {
        Thread.sleep(2000);
        int rndNumber = randomNumber(selectAddressButton.size());
        selectAddressButton.get(rndNumber).click();
    }

    @And("^User checks if the Delivery button is selected for the first product$")
    public void userChecksIfTheDeliveryButtonIsSelectedForTheProduct() {
        assertTrue(selectedDeliverButton.isEnabled());
    }

    @And("^User checks if the Click And Collect button is selected for the second product$")
    public void userChecksIfTheClickAndCollectButtonIsSelectedForTheSecondProduct() {
        assertTrue(selectedClickAndCollectButton.isEnabled());
    }

    @And("^User checks Sub Total Field$")
    public void userChecksSubTotalField() {
        double firstPrice = Double.parseDouble(totalPriceField1.getText().replace("£", ""));
        double secondPrice = Double.parseDouble(totalPriceField2.getText().replace("£", ""));
        String res_st = String.format(Locale.US, "%.2f", firstPrice+secondPrice);

        assertEquals(Double.parseDouble(subTotalField.getText().replace("£", "")),
                Double.parseDouble(res_st), 0.00);
    }

    @And("^User checks if the Total Field is the same as the Sub Total Field$")
    public void userChecksIfTheTotalFieldIsTheSameAsTheSubTotalField() {
        assertEquals(Double.parseDouble(totalField.getText().replace("£", "")),
                Double.parseDouble(subTotalField.getText().replace("£", "")), 0.00);
    }

    @And("^input random email$")
    public void inputRandomEmail() {
        String email = randomEmail();
        //Allure.addAttachment("Email: ", email);
        emailField.sendKeys(email);
    }

    @Given("^I should be logged in$")
    public void iShouldBeLogin() {
        String url = WebPage.getUrl();
        if (!url.contains("https://www.screwfix.com/")
                || url.contains("issue")) {
            logInPage.open();
        }
            loginForm.submit(DEFAULT_USER);
        }

}