package com.StartupHeroes.StepDefinitions;

import com.StartupHeroes.Utilities.BrowserUtils;
import com.StartupHeroes.Utilities.ConfigurationReader;
import com.StartupHeroes.Utilities.Driver;
import com.StartupHeroes.pages.BasePage;
import com.StartupHeroes.pages.CareerPage;
import com.StartupHeroes.pages.DashboardPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CareerPageStepDef extends BasePage {

    DashboardPage dashboardPage = new DashboardPage();
    CareerPage careerPage = new CareerPage();


    @Given("user navigates the {string} page")
    public void user_navigates_the_page(String module) {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(4);


      BrowserUtils.hover(careerPage.CareerModule);
      careerPage.CareerModule.click();

        BrowserUtils.waitFor(6);

    }

    @When("user clicks to {string} position")
    public void user_clicks_to_position(String JobName) {

      careerPage.ClickToPosition(JobName);


        BrowserUtils.waitFor(3);

    }
    @When("user clicks to apply position button")
    public void user_clicks_to_apply_position_button() {
        careerPage.ApplyPositionButton.click();
        BrowserUtils.waitFor(3);


    }
    @Then("user should see the {string} application form")
    public void user_should_see_the_application_form(String JobName) {
        Assert.assertEquals(JobName,careerPage.JobNameHeadline.getText());


    }
    @When("user enters information into boxes and not attach resume")
    public void user_enters_information_into_boxes_and_not_attach_resume() {
        Faker faker = new Faker();

        careerPage.FullNameBox.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(2);
        careerPage.EmailBox.sendKeys(faker.internet().emailAddress());
        BrowserUtils.waitFor(2);
        careerPage.PhoneBox.sendKeys(faker.phoneNumber().cellPhone());
        BrowserUtils.waitFor(2);

      BrowserUtils.clickWithJS(careerPage.ApplyButton);
        BrowserUtils.waitFor(3);

    }
    @Then("user should see {string} as a warning message")
    public void user_should_see_as_a_warning_message(String ExpectedMessage) {

        Assert.assertEquals(ExpectedMessage,careerPage.AlertMessage.getText());

        Driver.get().switchTo().defaultContent();

    }


}
