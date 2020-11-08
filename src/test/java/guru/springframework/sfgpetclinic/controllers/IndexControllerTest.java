package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class IndexControllerTest implements ControllerTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test Proper View name is returned for index page")
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
        assertEquals("index", indexController.index(), () -> "Make me if you need to");

        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> { 
            indexController.oopsHandler();
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here prempt");
        });
    }

    @Test
    void TestAssumptionTrue(){
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void TestAssumptionTrueAssumptionIsTrue(){
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnMacWindows(){

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8(){

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred(){

    }
}