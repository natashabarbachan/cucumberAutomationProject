package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.TVShowsPage;

public class FilterSteps {

    DriverFactory driver = new DriverFactory();
    WebDriver driverChrome;
    TVShowsPage tvShowsPage;
    String url;

    @Before("@Filter")
    public void startingTestFilter() {
        url = "https://www.rottentomatoes.com/browse/tv_series_browse/sort:popular";
        driverChrome = driver.getChromeDriver(url);
        tvShowsPage = new TVShowsPage(driverChrome);
    }

    @Given("the user is on TV Shows tab")
    public void userIsOnTVShowsTab() {
        String expectedTitle = "Best TV Shows (June 2024)";
        Assert.assertEquals(tvShowsPage.getTvShowTitle(), expectedTitle);
    }

    @When("the user selects Audience Score filter")
    public void theUserSelectsAudienceScoreFilter() {
        tvShowsPage.audienceFilterClick();
    }

    @When("the user selects Fresh option")
    public void theUserSelectsFreshOption() {
        tvShowsPage.freshOptionClick();
    }

    @When("the user selects Rotten option")
    public void theUserSelectsRottenOption() {
        tvShowsPage.rottenOptionClick();
    }

    @When("the user clicks on Apply button")
    public void theUserClickOnApplyButton() throws InterruptedException {
        tvShowsPage.audienceScoreApplyButtonClick();

        System.out.println("Waiting for 5 seconds...");
        Thread.sleep(5000);
        System.out.println("Continuing after waiting");
    }

    @When("the user selects {string} option")
    public void theUserSelectsStreamingOption(String streaming) throws InterruptedException {
        tvShowsPage.streamingClick(streaming);
        Thread.sleep(3000);
    }

    @Then("percentage should be greater than or equal to {int} percent")
    public void percentageValueShouldBeGreaterThanOrEqualTo(int expectedValue) {
        int currentValue = Integer.parseInt(tvShowsPage.getPercentage());

//        System.out.println(currentValue);
        Assert.assertTrue("Percentage is greater than or equal to" + expectedValue + "%", currentValue >= expectedValue);
    }

    @Then("percentage should be less than {int} percent")
    public void percentageValueShouldBeLess(int expectedValue) {
        int currentValue = Integer.parseInt(tvShowsPage.getPercentage());

//        System.out.println(currentValue);
        Assert.assertTrue("Percentage is less than " + expectedValue + "%", currentValue < expectedValue);
    }

    @Then("the {string} should be displayed")
    public void theTitleShouldBeDisplayed(String streaming) {
        String expectedTitle = "Best TV Shows on " + streaming + " (June 2024)";
        String currentTitle = tvShowsPage.getTvShowTitle();

        Assert.assertEquals(expectedTitle, currentTitle);
    }

    @After("@Filter")
    public void finishingTest() {
        driverChrome.close();
    }
}