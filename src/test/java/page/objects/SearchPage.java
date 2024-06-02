package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    @FindBy(linkText = "MOVIES")
    public WebElement tabMovies;
    @FindBy(linkText = "TV SHOWS")
    public WebElement tabTVShows;
    @FindBy(css = ".navbar input")
    public WebElement inputSearch;
    @FindBy(css = "search-page-result[type='movie'] search-page-media-row")
    public List<WebElement> listResults;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void accessMoviesTab(){
        tabMovies.click();
    }

    public void accessTVShowsTab(){
        tabTVShows.click();
    }

    public void searchMovie(String movie){
        inputSearch.sendKeys(movie);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public String getMovieYear(){
        return listResults.get(0).getAttribute("releaseyear");
    }

    public String getMovieTitle(){
        String movieTitle = listResults.get(0).findElement(By.cssSelector("a[data-qa='info-name']")).getText();
        listResults.get(0).findElement(By.cssSelector("a[data-qa='info-name']")).click();
        return movieTitle;
    }
}
