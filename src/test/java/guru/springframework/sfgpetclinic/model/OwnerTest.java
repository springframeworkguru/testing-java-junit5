package guru.springframework.sfgpetclinic.model;


import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@Tag("Models") <- now gets the tag from interface
public class OwnerTest implements ModelTests {

    @Test
    public void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("0123456789");
        assertAll("Properties test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Buck", owner.getLastName(), "Last name did not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                        () -> assertEquals("0123456789", owner.getTelephone(), "Phone number did not match")
                ));
    }


    @DisplayName("Value Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} ")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val ){
        System.out.println(val);
    }

    @DisplayName("Enum Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} ")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType){
        System.out.println(ownerType);

    }
    @DisplayName("CSV Input Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} ")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 1"
    })
    void csvInputTest(String stateName, int val1, int val2){
        System.out.println(stateName+":"+val1+":"+val2);
    }

    @DisplayName("CSV from File Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} ")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2){
        System.out.println(stateName+":"+val1+":"+val2);
    }

    @DisplayName("Method Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} ")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2){
        System.out.println(stateName+":"+val1+":"+val2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 3),
                Arguments.of("MI", 4, 6));
    }

    @DisplayName("Custom Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} ")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderClass(String stateName, int val1, int val2){
        System.out.println(stateName+":"+val1+":"+val2);
    }


}
