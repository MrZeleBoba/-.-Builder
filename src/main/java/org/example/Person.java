package org.example;

import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String city;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean hasAddress() {

        return city != null;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public void setAddress(String city) {
        this.city = city;

    }

    public void happyBirthday() {
        if (hasAge())
            age++;

    }

    @Override

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }


    public String getCity() {
        return city;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder chield = new PersonBuilder();
        chield.setSurname(this.surname);
        chield.setAge(5);
        chield.setAddress(this.city);
        return chield;
    }
}
