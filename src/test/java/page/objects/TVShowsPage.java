package page.objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class TVShowsPage {

    WebDriver driver;

    @FindBy(css = "h1[data-qa='discovery-header-title']")
    public WebElement tvShowTitle;
    @FindBy(css = "[data-qa=\"discovery-filter-audience\"] span")
    public WebElement audienceFilter;
    @FindBy(css = "[data-qa=\"option-upright\"] select-checkbox")
    public WebElement freshOption;
    @FindBy(css = "[data-qa=\"option-spilled\"] select-checkbox")
    public WebElement rottenOption;
    @FindBy(css = "[data-filter=\"audience\"] [data-qa=\"apply-btn\"]")
    public WebElement audienceScoreApplyButton;
    @FindBy(css = "[data-qa=\"discovery-media-list-item-caption\"] score-pairs-deprecated")
    public WebElement discoveryMediaListItem;
    @FindBy(css = "bubbles-overflow-container where-to-watch-bubble[image]")
    public List<WebElement> streamingImageList;

    public TVShowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTvShowTitle() {
        return tvShowTitle.getText();
    }

    public void audienceFilterClick(){
        audienceFilter.click();
    }

    public void freshOptionClick(){
        freshOption.click();
    }

    public void rottenOptionClick(){
        rottenOption.click();
    }

    public void audienceScoreApplyButtonClick(){
        audienceScoreApplyButton.click();
    }

    public String getPercentage() { //
        SearchContext shadowRoot = discoveryMediaListItem.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("score-icon-audience-deprecated[percentage]"));
        return shadowContent.getAttribute("percentage");
    }

    public void streamingClick(String streamingName) { //

        for (WebElement item : streamingImageList) {
            if (Objects.equals(item.getAttribute("image"), streamingName)){
                item.click();
                break;
            }
        }
    }
}
