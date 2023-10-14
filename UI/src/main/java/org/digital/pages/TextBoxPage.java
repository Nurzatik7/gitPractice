package org.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage{

    @FindBy(id = "userName")
    public WebElement fullNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    public TextBoxPage fillUpTheFullName(String fullName){
        elementActions.writeText(fullNameInput, fullName);
        return this;
    }
    public TextBoxPage fillUpTheEmail(String email){
        elementActions.writeText(userEmailInput, email);
        return this;
    }
}
