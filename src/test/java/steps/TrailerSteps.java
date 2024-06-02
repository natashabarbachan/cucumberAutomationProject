package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.SearchPage;
import page.objects.TVShowsPage;
import page.objects.TrailerPage;

public class TrailerSteps {

    DriverFactory driver = new DriverFactory();
    WebDriver driverChrome;
    TrailerPage trailerPage;
    String url;

    @Before("@Trailer")
    public void startingTest() {
        url = "https://www.rottentomatoes.com/tv/greys_anatomy";
        driverChrome = driver.getChromeDriver(url);
        trailerPage = new TrailerPage(driverChrome);
    }

    @Given("the user is on \"Grey's Anatomy\" page details")
    public void verifyGreysAnatomyPageDetails() {
        Assert.assertEquals(trailerPage.getPageTitle(), "Grey's Anatomy");
    }

    @When("the user clicks on Trailer button")
    public void clicksOnTrailerButton() throws InterruptedException {
        Thread.sleep(4000);
        trailerPage.clickOnTrailer();
    }

    @Then("the trailer is displayed")
    public void verifyTrailerIsDisplayed() throws InterruptedException  {
        trailerPage.getVideoOverlay();
        Thread.sleep(10000);
    }

    @After("@Trailer")
    public void finishingTest() {
        driverChrome.close();
    }
}
