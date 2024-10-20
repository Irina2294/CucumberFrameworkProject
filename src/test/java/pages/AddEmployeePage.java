package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    //create object repository
    //keep all the elements of this screen here

    @FindBy(id="firstName")
    public WebElement firstnameLocator;

    @FindBy(id="middleName")
    public WebElement middlenameLocator;

    @FindBy(id="lastName")
    public WebElement lastnameLocator;
    @FindBy(id="employeeId")
    public WebElement employeeIDLocator;

    @FindBy(id="btnSave")
    public WebElement saveButton;
    @FindBy(xpath="//span[@class='validation-error']")
    public WebElement addEmployeeError;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }





}
