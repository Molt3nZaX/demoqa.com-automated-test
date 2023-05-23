package demoqa.models;

import lombok.Data;

@Data
public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;
    private final int salary;
    private final String department;
}