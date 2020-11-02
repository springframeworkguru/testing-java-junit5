package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> {
            assertAll("Person properties",
                    () -> assertEquals( "Joe", owner.getFirstName()),
                    () -> assertEquals( "Buck", owner.getLastName()));
                },
                () -> {
            assertAll("Owner properties",
                    () -> assertEquals( "Key West", owner.getCity()),
                    () -> assertEquals( "1231231234", owner.getTelephone()));
                });
    }

}