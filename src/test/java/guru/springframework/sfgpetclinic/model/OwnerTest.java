package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: jalnor
    Date: 7/13/2021 7:32 AM
    Project: guru.springframework.sfgpetclinic.model
*/
class OwnerTest {

    Owner owner;
    @BeforeEach
    void setUp() {
        owner = new Owner(1l, "Joe", "Schmoe");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");
    }
    // Can run multiple tests in same method
    @Test
    void dependentAssertions() {
        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName()),
                        () -> assertEquals("Schmoe", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity()),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void isNew() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getPet() {
    }

    @Test
    void testGetPet() {
    }

    @Test
    void getAddress() {
    }

    @Test
    void setAddress() {
    }

    @Test
    void getCity() {
    }

    @Test
    void setCity() {
    }

    @Test
    void getTelephone() {
    }

    @Test
    void setTelephone() {
    }

    @Test
    void getPets() {
    }

    @Test
    void setPets() {
    }
}