package org.example;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String city;

    public String getName() {
        return name;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException(
                    "Возраст должен быть от 0 до 100"
            );
        }
        this.age = age;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PersonBuilder setAddress(String city) {

        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException(
                    "Имя и Фамилия должны быть указаны"
            );
        }
        Person person = age != -1 ? new Person(name, surname, age) : new Person(name, surname);
        if (city != null) {
            person.setAddress(city);
        }
        return person;
    }

}
