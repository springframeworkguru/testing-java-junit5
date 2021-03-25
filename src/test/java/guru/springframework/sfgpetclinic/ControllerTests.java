package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)// necessary for beforeAll, not for beforeEach
@Tag("Controllers")
public interface ControllerTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println("(0) Let's do something in the controller Interface");
    }
    @BeforeEach
    default void beforeEach(){
        System.out.println("(0.1) Let's do something in the controller Interface");
    }


}
