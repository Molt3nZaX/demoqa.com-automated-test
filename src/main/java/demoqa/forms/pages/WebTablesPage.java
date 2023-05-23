package demoqa.forms.pages;

import demoqa.elements.ButtonElement;
import demoqa.forms.BaseForm;
import demoqa.models.Person;
import demoqa.utils.ConditionalWaitUtils;
import demoqa.utils.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static demoqa.utils.ParameterizedXpathUtils.getXpathButtonById;

public class WebTablesPage extends BaseForm {
    private final ButtonElement addButton = new ButtonElement(getXpathButtonById("addNewRecordButton"), "addButton");
    private final ButtonElement deleteButton = new ButtonElement(By.xpath("//span[contains(@id,'delete')]"), "deleteButton");

    public WebTablesPage() {
        super(By.xpath("//div[contains(@class,'tables')]"), "webTablesPage");
    }

    public void clickAddButton() {
        addButton.click();
    }

    public List<Person> getPersonListFromJson(String path) {
        List<Person> personList = new ArrayList<>();
        List<Person> personsData = JsonUtils.readListFromJson(path, Person.class);

        for (Person personData : personsData) {
            String firstName = personData.getFirstName();
            String lastName = personData.getLastName();
            int age = personData.getAge();
            String email = personData.getEmail();
            int salary = personData.getSalary();
            String department = personData.getDepartment();
            personList.add(new Person(null, firstName, lastName, email, age, salary, department));
        }
        return personList;
    }

    public List<Person> getActualPersonListFromTable() {
        List<WebElement> webElementList = ConditionalWaitUtils.waitForPresenceOfAllElementsLocatedBy(By.xpath("//div[@class='rt-tr-group']"));
        List<Person> actualPersonList = new ArrayList<>();

        for (WebElement webElement : webElementList) {
            List<WebElement> currentPeopleList = webElement.findElements(By.xpath(".//div[@class='rt-td']"));
            if (!currentPeopleList.get(0).getText().trim().isEmpty()) {
                String firstName = getFirstName(currentPeopleList);
                String lastName = getLastName(currentPeopleList);
                int age = getAge(currentPeopleList);
                String email = getEmail(currentPeopleList);
                int salary = getSalary(currentPeopleList);
                String department = getDepartment(currentPeopleList);
                actualPersonList.add(new Person(null, firstName, lastName, email, age, salary, department));
            }
        }
        return actualPersonList;
    }

    public void deleteLastRow() {
        List<WebElement> deleteButtonsList = deleteButton.findElements();
        deleteButtonsList.get(deleteButtonsList.size() - 1).click();
    }

    private String getFirstName(List<WebElement> currentPeopleList) {
        return currentPeopleList.get(0).getText();
    }

    private String getLastName(List<WebElement> currentPeopleList) {
        return currentPeopleList.get(1).getText();
    }

    private int getAge(List<WebElement> currentPeopleList) {
        return Integer.parseInt(currentPeopleList.get(2).getText());
    }

    private String getEmail(List<WebElement> currentPeopleList) {
        return currentPeopleList.get(3).getText();
    }

    private int getSalary(List<WebElement> currentPeopleList) {
        return Integer.parseInt(currentPeopleList.get(4).getText());
    }

    private String getDepartment(List<WebElement> currentPeopleList) {
        return currentPeopleList.get(5).getText();
    }
}


