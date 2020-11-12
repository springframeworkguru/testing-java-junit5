package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} : [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 3"
    })
    void csvInputTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    @DisplayName("Enum File Test")
    @ParameterizedTest(name = "{displayName} : [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvInputFileTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} : [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(Arguments.of("FL", 5, 1), Arguments.of("OH", 2, 8), Arguments.of("MI", 3, 5));
    }
}