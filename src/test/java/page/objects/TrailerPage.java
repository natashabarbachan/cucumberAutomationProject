package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrailerPage {

    WebDriver driver;

    @FindBy(css = "[slot=\"titleIntro\"] span")
    public WebElement pageTitle;
    @FindBy(css = "[slot=\"trailerBtn\"]")
    public WebElement trailerButton;
    @FindBy(css = "[id=\"video-overlay-player\"].jw-state-playing")
    public WebElement videoOverlay;

    public TrailerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void clickOnTrailer() {
        trailerButton.click();
    }

    public void getVideoOverlay() {
        videoOverlay.isDisplayed();
    }
}
