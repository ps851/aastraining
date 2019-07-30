package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestment("1000");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("test1@mail.com");
        //precitat total income
        String calculatedIncome = calculatorPage.getTotalIncome();
        //vytvorit novy savin
        calculatorPage.submitRequest();
        //overit ze sa total income zobrazi v requeste
        String calculatedIncome2 = driver.findElement
                (By.xpath("//ul[contains(@class, 'saving-list')]/li//div[contains (@class, 'amounts')]/p/span"))
                .getText();
        Assert.assertEquals(calculatedIncome, calculatedIncome2);

        Assert.assertEquals(
                calculatedIncome,
                driver.findElement(By.cssSelector("ul.saving-list > li div.amounts > p > span")).getText());

    }

    @Test
    public void itShouldDisplayFundInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestment("1000");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("test1@mail.com");
        calculatorPage.submitRequest();

        String selectedFund = driver.findElement(By.xpath("//p[contains(@class, 'fund-description')]")).getText();

        Assert.assertEquals("Death Star real estate", selectedFund);

    }
}
