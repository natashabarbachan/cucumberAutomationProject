package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MoviePage {

    WebDriver driver;

    @FindBy(css = "rt-button[slot='audienceScore']")
    public WebElement textAudienceGrade;

    public MoviePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMovieGrade(){
        return textAudienceGrade.getText();
    }
}
