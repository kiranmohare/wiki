package testcase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.AdvancedSearchPage;
import pageobject.WikiHomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WikiAdvancedSearchTest {
    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    WikiHomePage wikiHomePage;
    AdvancedSearchPage advancedSearchPage;

    @Parameters("Browser")
    @BeforeTest
    public void setUp(String Browser){
        if(Browser.equalsIgnoreCase("chrome")){
            System.setProperty("WebDriver.chrome.driver", projectPath +"\\src\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else{
            System.setProperty("WebDriver.gecko.driver", projectPath +"\\src\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

//        System.setProperty("WebDriver.chrome.driver", projectPath +"\\src\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/");
    }

    @Test(priority = 1, description = "Test Article search in Advanced SearchBar with a Text to check the result page")
    public void testArticleInWikiAdvancedSearchBar() {
        wikiHomePage = new WikiHomePage(driver);
        advancedSearchPage = new AdvancedSearchPage(driver);
        String searchText = "OneFootball";

        wikiHomePage.clickAdvancedSearchBox();
        Assert.assertEquals(advancedSearchPage.isAdvancedSearchContainerDisplayed(), true);
        advancedSearchPage.typeTextInAdvancedSearchBar(searchText);
        advancedSearchPage.clickAdvancedSearchBtn();
        Assert.assertEquals(advancedSearchPage.isAdvancedSearchResultContainerDisplayed(), true);
        Assert.assertEquals(advancedSearchPage.getSearchResultText(), "There is a page named \""+searchText+"\" on Wikipedia");
    }

    @Test(priority = 2, description = "Test Article search with Advanced SearchBar by selecting multiple options on Advanced search dropdown")
    public void testWikiAdvancedSearchWithPageText() throws InterruptedException {
        wikiHomePage = new WikiHomePage(driver);
        advancedSearchPage = new AdvancedSearchPage(driver);
        String searchText = "Epl";
        wikiHomePage.clickAdvancedSearchBox();
        advancedSearchPage.typeTextInAdvancedSearchBar(searchText);
        advancedSearchPage.clickAdvancedSearchBtn();
        String textWithoutAdvancedSearch = advancedSearchPage.getFirstShowedTextInResult();
        Thread.sleep(1000);
        advancedSearchPage.clickAdvancedSearchDropdownBtn();
        advancedSearchPage.typeTheseWordsTextInAdvancedSearch("Chelsea");
        advancedSearchPage.typeNotTheseWordsTextInAdvancedSearch("Arsenal");
        advancedSearchPage.clickAdvancedSearchBtn();
        String textWithAdvancedSearch = advancedSearchPage.getFirstShowedTextInResult();
        Assert.assertEquals(advancedSearchPage.isAdvancedSearchResultContainerDisplayed(), true);

        // Checking if the search results have changed after selecting different options from AdvancedSearch dropdown
        if(textWithoutAdvancedSearch != textWithAdvancedSearch){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3, description = "Test Article search with  Advanced SearchBar with SearchIn dropdown options")
    public void testSearchInFunctionInWikiSearch() throws InterruptedException {
        wikiHomePage = new WikiHomePage(driver);
        advancedSearchPage = new AdvancedSearchPage(driver);
        String searchText = "english";
        wikiHomePage.clickAdvancedSearchBox();
        advancedSearchPage.typeTextInAdvancedSearchBar(searchText);
        advancedSearchPage.clickAdvancedSearchBtn();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
//                .executeScript("return document.readyState")));
        Thread.sleep(1000);
        advancedSearchPage.clickSearchInDropdownBtn();
        Assert.assertTrue(advancedSearchPage.isDefaultBoxCheckedInSearchInOption());
        String defaultSearchCheckboxText = advancedSearchPage.getDefaultSearchInResultString();
        System.out.println("default text" +defaultSearchCheckboxText);
        advancedSearchPage.clickAllCheckBox();
        String allSearchInCheckboxText = advancedSearchPage.getAllSearchInResultString();

        // Checking if the search results have changed after selecting different options from SearchIn dropdown
        if(!defaultSearchCheckboxText.equals(allSearchInCheckboxText)){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
        advancedSearchPage.clickAllCheckBox();
        advancedSearchPage.clickDefaultBoxInSearchOption();
        Assert.assertEquals(defaultSearchCheckboxText, "(Article)");
    }

    @Test(priority = 4, description = "Test if Main page link navigates back to Welcome Page from Advanced page search")
    public void testMainPageLink(){
        wikiHomePage = new WikiHomePage(driver);
        wikiHomePage.clickAdvancedSearchBox();
        wikiHomePage.clickMainPageLink();
        Assert.assertEquals(wikiHomePage.getHomePageTitle(), "Welcome to Wikipedia");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
