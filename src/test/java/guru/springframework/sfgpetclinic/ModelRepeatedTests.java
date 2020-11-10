package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("modelsRepeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println("Before Each - " + testInfo.getDisplayName() + " - " + repetitionInfo.getCurrentRepetition() + " | " + repetitionInfo.getTotalRepetitions());
    }
}
