package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchElement;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closeWidget() {
        String frameId = "LAVCTV";
        getDriver().switchTo().frame(frameId);
        String widgetXpath = "//div[@id=\"widget\"]/div/div/div[3]";
        getDriver().findElement(By.xpath(widgetXpath)).click();
        getDriver().switchTo().defaultContent();
    }

    public PairExchangePage clickOnQuote(String quote) {
        WebElement quoteElement = getDriver().findElement(By.xpath("//h6[contains(.,'/" + quote + "')]"));
        waitForCondition(ExpectedConditions.visibilityOf(quoteElement), timeout);
        closeWidget();
        quoteElement.click();
        waitForCondition(ExpectedConditions.titleContains(quote), timeout);
        return new PairExchangePage(getDriver());
    }

    public void search(String quote) {
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("javascript:window.scrollBy(0,1000)");
        searchElement.sendKeys(quote);
        searchElement.sendKeys(Keys.ENTER);
    }

}
