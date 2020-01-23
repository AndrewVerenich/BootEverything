package com.andver.firstApp.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonBuilderTest {

    @Test
    public void builderTest(){
        PersonBuilder builder = new PersonBuilder();
        Person person =builder.setName("Name").setAge(5).build();
        assertNotNull(person);
    }

}