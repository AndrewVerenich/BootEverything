package com.andver.firstApp.domain;

public class PersonBuilder {

    private String personName;
    private Integer personAge;

    public PersonBuilder() {
        setDefaults();
    }

    public PersonBuilder setName(String name) {
        this.personName = name;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        this.personAge = age;
        return this;
    }

    public Person build() {
        Person person = new Person(personName, personAge);
        setDefaults();
        return person;
    }

    private void setDefaults() {
        this.personName = "Stranger";
        this.personAge = 0;
    }
}
