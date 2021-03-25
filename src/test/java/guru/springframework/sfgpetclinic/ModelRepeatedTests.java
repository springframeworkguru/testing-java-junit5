package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("RepeatedTests")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println("Running Test - "+testInfo.getDisplayName() + " - " + repetitionInfo.getTotalRepetitions());
    }
}
