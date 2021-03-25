package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("Models")
public interface ModelTests {


    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo){
        System.out.println("Running Test - "+testInfo.getDisplayName());
    }
}
