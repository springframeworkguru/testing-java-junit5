package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * Created by jt on 2018-10-28.
 */
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputer(TestInfo testInfo){
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
