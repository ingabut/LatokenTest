package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PairExchangePage extends AbstractPage {
    @FindBy(xpath = "(//div[@data-tid='field__order_book_dragger_price']/../preceding-sibling::div/div)[last()]/div[2]/div[1]/span/span")
    private WebElement sellPrice;

    @FindBy(xpath="//div[@data-tid='field__order_book_line_buy_0_price']/span/span")
    private WebElement buyPrice;
    //By buyPriceBy = By.xpath("//div[@data-tid='field__order_book_line_buy_0_price']/span/span");

    @FindBy(xpath = "//button[@data-tid='btn__bs_login']")
    private WebElement tradeButton;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement authDialog;

    @FindBy(xpath = "//*[contains(text(), 'Login or Sign Up')]")
    private WebElement authDialogTitle;

    public PairExchangePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSellPrice() {
        return sellPrice.getText();
    }

    public String getBuyPrice() {
        waitForCondition(ExpectedConditions.visibilityOf(buyPrice), timeout);
        return buyPrice.getText();
    }

    public String clickTradeButton() {
        tradeButton.click();
        waitForCondition(ExpectedConditions.visibilityOf(authDialog), timeout);
        return authDialogTitle.getText();
    }
}
