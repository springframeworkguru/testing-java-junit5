package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeteadTests implements ModelRepeatedTests {

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest(){
        //todo-impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
    @DisplayName("Course Assignment")
    void courseAssignment(){
        System.out.println("I did the assignment");
    }
}
