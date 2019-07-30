package tests;

import base.TestBase;
import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailValidationTest extends TestBase {

    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() throws FileNotFoundException {
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        for (String invalidEmail : readInvalidEmails()) {
            //zadam zly email
            calculatorPage.enterEmail(invalidEmail);
            //overenie ze class obsahuje error ked sa zada zly email
            Assert.assertTrue(
                    driver.findElement(By.xpath("//div[input[@id='emailInput']]"))
                            .getAttribute("class")
                            .contains("error")
            );
        }



    }

    private List<String> readInvalidEmails() throws FileNotFoundException {
        //nacitam file
        FileReader invalidEmailsTxt = new FileReader(new File("src/test/resources/invalid_emails.txt"));
        //vytvorim prazdny list do ktoreho budem ukladat riadky
        List<String> invalidEmailList = new ArrayList<>();
        //prechadzam cez riadky textaku a zozbieram ich do listu
        //do vytvoreneho listu priradim vsetky riadky ktore som nasiel
        invalidEmailList = new BufferedReader(invalidEmailsTxt).lines().collect(Collectors.toList());
        //vratim list
        return invalidEmailList;
    }
}