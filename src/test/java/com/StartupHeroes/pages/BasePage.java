package com.StartupHeroes.pages;

import com.StartupHeroes.Utilities.BrowserUtils;
import com.StartupHeroes.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



    public abstract class BasePage {
        public BasePage(){
            PageFactory.initElements(Driver.get(),this);
        }

        public void navigateToModule(String module) {

            WebElement iframe =Driver.get().findElement(By.cssSelector("body>iframe"));
            Driver.get().switchTo().frame(iframe);
            String moduleLocator = "//ul[@class='site-nav-wrap']//a[@class='nav-link'][normalize-space()='" + module + "']";
            WebElement Module = Driver.get().findElement(By.xpath(moduleLocator));
            BrowserUtils.hover(Module);
            Module.click();


 Driver.get().switchTo().defaultContent();
            BrowserUtils.waitFor(3);

        }

        @FindBy(xpath = "//a[@class='h2 mb-0']")
        public WebElement MainPageTitle;


    }



