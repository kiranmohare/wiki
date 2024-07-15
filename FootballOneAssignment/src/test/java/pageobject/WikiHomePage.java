package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@class='vector-search-box-input']")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id='searchButton']")
    WebElement advancedSearchBtn;

    @FindBy(xpath = "//*[@id='Welcome_to_Wikipedia']")
    WebElement homePageTitle;

    @FindBy(xpath = "//*[contains(text(),'Main page')]")
    WebElement mainPageLink;

    public WikiHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // To type text from wiki homepage searchBar
    public void clickAndTypeTextInSearchBox(String text){
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    // To click on advanced search box button
    public void clickAdvancedSearchBox(){
        advancedSearchBtn.click();
    }

    // Check if searchBox in homepage displayed
    public boolean isSearchBoxDisplayed(){
        return searchBox.isDisplayed();
    }

    // Get home page Title
    public String getHomePageTitle(){
        String title = homePageTitle.getText();
        return title;
    }

    // To click on MainPage link
    public void clickMainPageLink(){
        mainPageLink.click();
    }
}
