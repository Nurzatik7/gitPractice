package org.digital.pages;

import org.digital.driver.Driver;
import org.digital.helper.ElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    ElementActions elementActions = new ElementActions();
}

