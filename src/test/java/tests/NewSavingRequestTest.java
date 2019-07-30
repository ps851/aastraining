package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        //ARRANGE / GIVEN
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String expectedSelectedFund = calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestment("1000");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("test1@mail.com");
        //precitat total income
        String calculatedIncome = calculatorPage.getTotalIncome();

        //
        //vytvorit novy saving
        calculatorPage.submitRequest();

        //ASSERT
        //overit ze sa total income zobrazi v requeste
        System.out.println(calculatorPage.getFirstSavingDetails()
                .findElement(By.cssSelector("p.fund-description")).getText());

        String calculatedIncomeXpath = driver.findElement
                (By.xpath("//ul[contains(@class, 'saving-list')]/li//div[contains (@class, 'amounts')]/p/span"))
                .getText();
        Assert.assertEquals(calculatedIncome, calculatedIncomeXpath);
    }



    @Test
    public void itShouldDisplayFundInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String expectedSelectedFund = calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestment("1000");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("test1@mail.com");
        calculatorPage.submitRequest();

        String selectedFund = driver.findElement(By.xpath("//p[contains(@class, 'fund-description')]")).getText();

        Assert.assertEquals(expectedSelectedFund, selectedFund);

    }
}
