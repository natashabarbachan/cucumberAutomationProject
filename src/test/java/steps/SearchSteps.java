package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.MoviePage;
import page.objects.SearchPage;
import page.objects.TVShowsPage;
import java.time.Duration;

public class SearchSteps {

    DriverFactory driver = new DriverFactory();
    WebDriver driverChrome;
    SearchPage searchPage;
    TVShowsPage tvShowsPage;
    String url;

    @Before("@Search")
    public void startingTestSearch() {
        url = "https://www.rottentomatoes.com";
        driverChrome = driver.getChromeDriver(url);
        searchPage = new SearchPage(driverChrome);
    }

    @Given("the user access the movies tab")
    public void theUserAccessTheMoviesTab() {
        searchPage.accessMoviesTab();
    }

    @When("the user search for {string}")
    public void theUserSearchFor(String movie) {
        searchPage.searchMovie(movie);
    }

    @Then("public grade should be {string}")
    public void publicGradeShouldBePresented(String grade) {
        System.out.println(searchPage.getMovieYear());
        System.out.println(searchPage.getMovieTitle());
        MoviePage moviePage = new MoviePage(driverChrome);
        Assert.assertEquals(grade, moviePage.getMovieGrade());
    }

    @After("@Search")
    public void finishingTest() {
        driverChrome.close();
    }
}