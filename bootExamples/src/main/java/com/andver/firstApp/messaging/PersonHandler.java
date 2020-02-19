package com.andver.firstApp.messaging;

import com.andver.firstApp.domain.Person;

public class PersonHandler {

    public void handleMessage(Person person) {
        System.out.println(person);
    }
}
