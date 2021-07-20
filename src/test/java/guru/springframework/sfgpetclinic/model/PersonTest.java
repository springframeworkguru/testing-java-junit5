package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: jalnor
    Date: 7/12/2021 5:54 AM
    Project: guru.springframework.sfgpetclinic.model
*/
class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Shmoe");

        // then
        assertAll("Testing Properties are set...",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Shmoe", person.getLastName()));
    }

    @Test
    void groupedAssertionsMessages() {
        // given
        Person person = new Person(1L, "Joe", "Shmoe");

        // then
        assertAll("Testing Properties are set...",
                () -> assertEquals( "Joe", person.getFirstName(), "First name failed..."),
                () -> assertEquals( "Shmoe", person.getLastName(),"Last name failed..."));
    }
}