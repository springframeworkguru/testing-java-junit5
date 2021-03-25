package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("Models") <- now gets the tag from interface
class PersonTest implements ModelTests {

    @Test
    public void groupedAssertions(){
        // given
        Person person = new Person(1L, "Joe", "Buck");
        // when

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName())
        );
    }
    @Test
    public void groupedAssertionsFail(){
        // given
        Person person = new Person(1L, "Joe", "Buck");
        // when

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertNotEquals("Buck2", person.getLastName())
        );
    }



}