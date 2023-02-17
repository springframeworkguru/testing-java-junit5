package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Joe", "Buck");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName())
        );
    }

    @Test
    void groupedAssertionsMsgs() {
        // given
        Person person = new Person(1l, "Joe", "Buck");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(),  "First Name Failed"),
                () -> assertEquals("Buck", person.getLastName(),  "Last Name Failed")
        );
    }
}