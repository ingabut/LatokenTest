package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class LatokenTest extends BaseTest {
    private String token = "STORJ";
    private String quote = "USDT";
    private String dialogHeader = "Login or Sign Up";

    /**
     * - Open the latoken.com page
     *
     * - Find in the table of STORJ/USDT pairs
     *
     * - Click on this line and go to the terminal
     *
     * - Check that the spread in the betting window is > 0.
     *
     * - Click on login to trader button on buy/sell panel
     *
     * - Check that the authorization dialog box is open.
     */
    @Test(description = "Check if spread >0 and the auth dialog is open")
    public void testSpread() {
        homePage.search(token);
        var pairExchangePage = homePage.clickOnQuote(quote);
        String buyPrice = pairExchangePage.getBuyPrice();
        String sellPrice = pairExchangePage.getSellPrice();
        assertTrue(Float.parseFloat(sellPrice) > Float.parseFloat(buyPrice));
        String title = pairExchangePage.clickTradeButton();
        assertEquals(title, dialogHeader);
    }
}
