package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdvancedSearchPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='content']")
    WebElement advancedSearchContainer;

    @FindBy(xpath = "//input[@id='ooui-php-1']")
    WebElement advancedSearchBar;

    @FindBy(xpath = "//button[@type='submit']//span[@class='oo-ui-labelElement-label']")
    WebElement advancedSearchBtn;

    @FindBy(xpath = "//*[@id=\"powersearch\"]/div[4]/div[1]/span/a/span[3]")
    WebElement advancedSearchDropdownBtn;

    @FindBy(xpath = "//*[@id=\"powersearch\"]/div[4]/div[2]/span/a/span[3]")
    WebElement searchInDropdownBtn;

    @FindBy(xpath = "//*[@id=\"ooui-31\"]")
    WebElement theseWordsTextBox;

    @FindBy(xpath = "//*[@id=\"ooui-33\"]")
    WebElement exactlyThisTextBox;

    @FindBy(xpath = "//*[@id=\"ooui-35\"]")
    WebElement notTheseWordsTextBox;

    @FindBy(xpath = "//*[@id=\"ooui-37\"]")
    WebElement oneOfTheseWordsTextBox;

    @FindBy(xpath = "//*[@id=\"ooui-39\"]")
    WebElement pageTitleContainsTextBox;

    @FindBy(xpath = "//*[@id=\"ooui-41\"]")
    WebElement subPagesOfThisPageTextBox;

    @FindBy(xpath = "//*[@id=\"advancedSearchField-deepcategory\"]/div[1]/div")
    WebElement pagesCategoriesTextBox;

    @FindBy(xpath = "//*[@id=\"advancedSearchField-hastemplate\"]/div[1]/div")
    WebElement hasTemplateTextBox;

    @FindBy(xpath = "//*[@id=\"advancedSearchField-filetype\"]/div/span/span[3]")
    WebElement fileTypeDropdownBtn;

    @FindBy(xpath = "//*[@id=\"advancedSearchField-sort\"]/div/span/span[3]")
    WebElement sortingOrderDropdownBtn;

    @FindBy(xpath = "//*[@id=\"ooui-64\"]")
    WebElement relevanceSortingOrder;

    @FindBy(xpath = "//*[@id=\"ooui-75\"]/span[3]")
    WebElement editDateSortingOrder;

    @FindBy(xpath = "//*[@id=\"ooui-76\"]/span[3]")
    WebElement createDateSortingOrder;

    @FindBy(xpath = "//*[@value='defaultNamespaces']")
    WebElement defaultCheckBox;

    @FindBy(xpath = "//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[2]/div/div/label[2]/span[1]")
    WebElement discussionCheckBox;

    @FindBy(xpath = "//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[2]/div/div/label[3]/span[1]/input")
    WebElement generalHelpCheckBox;

    @FindBy(xpath = "//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[2]/div/div/label[4]/span[1]/input")
    WebElement allCheckBox;

    @FindBy(xpath = "//*[@id=\"powersearch\"]/div[4]/div[2]/span/a/span[2]/div/div/span[1]/span")
    WebElement searchInDefaultSelection;

    @FindBy(xpath = "//*[@id=\"powersearch\"]/div[4]/div[2]/span/a/span[2]/div/div/span[2]/a")
    WebElement searchInDefaultSelectionCloseBtn;

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[3]/p[1]/b")
    WebElement advancedSearchResult;

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[3]/ul")
    WebElement advancedSearchResultContainer;

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[3]/ul/li[1]/div[1]/a")
    WebElement firstTextFromSearch;

    @FindBy(xpath = "//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[3]/div[1]/div/div/div[1]/span[1]")
    WebElement defaultSearchInText;

    @FindBy(xpath = "//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[3]/div[1]/div/div/div[2]/span[1]")
    WebElement allSearchInText;

    public AdvancedSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAdvancedSearchContainerDisplayed(){
        return advancedSearchContainer.isDisplayed();
    }

    public void typeTextInAdvancedSearchBar(String text){
        advancedSearchBar.click();
        advancedSearchBar.sendKeys(text);
    }

    public void clickAdvancedSearchBtn(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", advancedSearchBtn);
        advancedSearchBtn.click();
    }

    public void clickAdvancedSearchDropdownBtn(){
        advancedSearchDropdownBtn.click();
    }

    public void clickSearchInDropdownBtn(){
        searchInDropdownBtn.click();
    }

    public void typeTheseWordsTextInAdvancedSearch(String text){
        theseWordsTextBox.click();
        theseWordsTextBox.sendKeys(text);
    }

    public void typeExactlyThisTextInAdvancedSearch(String text){
        exactlyThisTextBox.click();
        exactlyThisTextBox.sendKeys(text);
    }

    public void typeNotTheseWordsTextInAdvancedSearch(String text){
        notTheseWordsTextBox.click();
        notTheseWordsTextBox.sendKeys(text);
    }

    public void typeOneOfTheseWordsTextInAdvancedSearch(String text){
        oneOfTheseWordsTextBox.click();
        oneOfTheseWordsTextBox.sendKeys(text);
    }

    public void typePageTitleContainsTextInStructure(String text){
        pageTitleContainsTextBox.click();
        pageTitleContainsTextBox.sendKeys(text);
    }

    public void typeSubPagesOfThisPageTextInStructure(String text){
        subPagesOfThisPageTextBox.click();
        subPagesOfThisPageTextBox.sendKeys(text);
    }

    public void clickSortingOrderDropdownBtn(){
        sortingOrderDropdownBtn.click();
    }

    public void clickRelevanceSortingOrder(){
        relevanceSortingOrder.click();
    }

    public void clickEditDateSortingOrder(){
        editDateSortingOrder.click();
    }

    public void clickCreateDateSortingOrder(){
        createDateSortingOrder.click();
    }

    public boolean isDefaultBoxCheckedInSearchInOption(){
        return defaultCheckBox.isSelected();
    }

    public void clickDefaultBoxInSearchOption(){
        defaultCheckBox.click();
    }

    public void clickDiscussionCheckBox(){
        if(!discussionCheckBox.isSelected()){
            discussionCheckBox.click();
        }
    }

    public void clickGeneralHelpCheckBox(){
        if(!generalHelpCheckBox.isSelected()){
            generalHelpCheckBox.click();
        }
    }

    public void clickAllCheckBox(){
        if(!allCheckBox.isSelected()){
            allCheckBox.click();
        }
    }

    public String getSearchResultText(){
        return advancedSearchResult.getText();
    }

    public boolean isAdvancedSearchResultContainerDisplayed(){
        return advancedSearchResultContainer.isDisplayed();
    }

    public String getFirstShowedTextInResult(){
        return firstTextFromSearch.getText();
    }

    public String getDefaultSearchInResultString(){
        return defaultSearchInText.getText();
    }

    public String getAllSearchInResultString(){
        return allSearchInText.getText();
    }
}
