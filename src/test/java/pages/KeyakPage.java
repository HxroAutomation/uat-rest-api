package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;


public class KeyakPage extends Page {

    public KeyakPage(){
        setUrl("https://www.kayak.com/flights");
    }

    @FindBy(xpath = "(//input[@name='origin'])[1]")
    private WebElement inputFrom;
    @FindBy(xpath = "(//input[@name='origin'])[2]")
    private WebElement inputTo;
    @FindBy(xpath = "")
    private WebElement dateDeparture;
    @FindBy(xpath = "")
    private WebElement dateReturn;
    @FindBy(xpath = "")
    private WebElement searchButton;



    public void inputCity(){
        inputFrom.sendKeys("Dallas");
        assertThat(inputFrom.toString()).isEqualTo("Dallas");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
