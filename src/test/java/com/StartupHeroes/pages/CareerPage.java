package com.StartupHeroes.pages;

import com.StartupHeroes.Utilities.BrowserUtils;
import com.StartupHeroes.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{
    @FindBy(css = ".d-lg-block.d-none.js-clone-nav.main-menu.mr-auto.site-menu > li:nth-of-type(3) > .nav-link")
    public WebElement CareerModule;

    @FindBy(css = "#jobs-banner-img > a>button")
    public WebElement ViewOpeningsModule;


    @FindBy(css = "button[class='btn btn-lg btn-outline-light']")
    public WebElement ApplyPositionButton;

    @FindBy(xpath = "//input[@id='field67921']")
    public WebElement FullNameBox;

    @FindBy(id = "field67922")
    public WebElement EmailBox;

    @FindBy(xpath = "//input[@id='field67923']")
    public WebElement PhoneBox;

    @FindBy(xpath = "//div[@class='mt-3']/button")
    public WebElement ApplyButton;

    @FindBy(xpath = "//small[@class='text-danger']")
    public WebElement AlertMessage;

    @FindBy(css = ".mt-5.font-weight-light.display-4")
    public WebElement JobNameHeadline;


    public void ClickToPosition(String position) {

       WebElement iframe =Driver.get().findElement(By.cssSelector("body>iframe"));
       Driver.get().switchTo().frame(iframe);

          ViewOpeningsModule.click();
          BrowserUtils.waitFor(2);

        String moduleLocator = "//a[@class='text-secondary']/h5[normalize-space()='" + position + "']";
        WebElement Position = Driver.get().findElement(By.xpath(moduleLocator));

        BrowserUtils.hover(Position);

        Position.click();

        BrowserUtils.waitFor(3);

    }



}
