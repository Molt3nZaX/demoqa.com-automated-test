package demoqa.forms;

import demoqa.elements.ButtonElement;
import demoqa.elements.TextBoxElement;
import demoqa.models.Person;
import org.openqa.selenium.By;

import static demoqa.utils.ParameterizedXpathUtils.getXpathInputById;

public class RegistrationForm extends BaseForm {
    private ButtonElement submitButton = new ButtonElement(By.xpath("//button[contains(text(), 'Submit')]"), "submitButton");
    private TextBoxElement firstName = new TextBoxElement(getXpathInputById("firstName"), "firstName");
    private TextBoxElement lastName = new TextBoxElement(getXpathInputById("lastName"), "lastName");
    private TextBoxElement email = new TextBoxElement(getXpathInputById("userEmail"), "email");
    private TextBoxElement age = new TextBoxElement(getXpathInputById("age"), "age");
    private TextBoxElement salary = new TextBoxElement(getXpathInputById("salary"), "salary");
    private TextBoxElement department = new TextBoxElement(getXpathInputById("department"), "department");

    public RegistrationForm() {
        super(By.xpath("//button[contains(text(), 'Submit')]"), "registrationForm");
    }

    public void fillFormByPeopleAndSubmit(Person person) {
        firstName.findElementAndSendKeys(person.getFirstName());
        lastName.findElementAndSendKeys(person.getLastName());
        email.findElementAndSendKeys(person.getEmail());
        age.findElementAndSendKeys(String.valueOf(person.getAge()));
        salary.findElementAndSendKeys(String.valueOf(person.getSalary()));
        department.findElementAndSendKeys(person.getDepartment());
        submitButton.click();
    }
}