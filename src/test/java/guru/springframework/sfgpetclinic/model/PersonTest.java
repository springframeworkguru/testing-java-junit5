package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals( "Joe", person.getFirstName()),
                () -> assertEquals( "Buck", person.getLastName())
                );
    }

    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1l, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals( "Joe", person.getFirstName(), "First Name Fail"),
                () -> assertEquals( "Buck", person.getLastName(), "Last Name Fail")
        );
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest(){
        //todo-impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }
}