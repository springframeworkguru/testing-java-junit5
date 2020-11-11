package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {

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

        assertThat(owner.getCity(), is("Key West"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} : [{index}] {arguments}")
    @ValueSource(strings = {"Spring" , "Framework", "Guru"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} : [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType){
        System.out.println(ownerType);
    }
}