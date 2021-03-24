package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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