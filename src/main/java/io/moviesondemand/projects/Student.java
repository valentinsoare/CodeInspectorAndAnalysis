package io.moviesondemand.projects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String email;

    public Student() {}

    public Student(String firstName, String lastName, int age, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.email = email;
    }
}
