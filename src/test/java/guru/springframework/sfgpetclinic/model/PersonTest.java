package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe", "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }
}