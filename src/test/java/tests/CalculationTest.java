package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;

public class CalculationTest extends TestBase {

    @Test
    public void itShouldCalculateTotalIncome() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //1. vybrat fund, zadat sumu, roky, email
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestment("1000");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("test1@mail.com");
        //2. overit ze total income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText());
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //1. vybrat fund, zadat sumu, roky, email
        calculatorPage.selectFund("Tom & Jerry corp");
        calculatorPage.enterInvestment("2000");
        calculatorPage.enterYears("20");
        calculatorPage.enterEmail("test2@mail.com");
        //2. overit ze interest income nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
        Assert.assertFalse(calculatorPage.getTotalInterest().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalInterest().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //1. vybrat fund, zadat sumu, roky, email
        calculatorPage.selectFund("Batman's Cave Development");
        calculatorPage.enterInvestment("3000");
        calculatorPage.enterYears("30");
        calculatorPage.enterEmail("test3@mail.com");
        //2. overit ze Risk nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText());
        Assert.assertFalse(calculatorPage.getRisk().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        String[] arrayOfFunds ={"Batman's Cave Development", "Tom & Jerry corp", "Death Star real estate"};
        for (String arrayOfFund : arrayOfFunds) {
            calculatorPage.selectFund(arrayOfFund);
            calculatorPage.enterInvestment("3000");
            calculatorPage.enterYears("30");
            calculatorPage.enterEmail("test3@mail.com");
            Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
            Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
            Assert.assertFalse(calculatorPage.getTotalInterest().isEmpty());
            Assert.assertTrue(calculatorPage.getTotalInterest().contains("kr"));
            Assert.assertFalse(calculatorPage.getRisk().isEmpty());
        }

    }
}
