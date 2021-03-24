package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {


    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test proper View name is return for index page")
    void index() {
        assertEquals("index", this.indexController.index(), "Wrong view returned");
        assertThat(this.indexController.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            this.indexController.oupsHandler();
        });
    }

    @Disabled("Demo of Timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // runs in a single thread
            Thread.sleep(2000);
            System.out.println("I Got Here");
        });
    }

    @Disabled("Demo of Preemptive Timeout")
    @Test
    void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            // runs in a separate thread
            Thread.sleep(2000);
            System.out.println("I sure not get here");
        });
    }

    @Disabled("Display Purposes only")
    @Test
    void testAssumptionTrue() {
        // Assume doesn't have to be true; if assumption is false, this is not make the test fail
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("VARIABLE")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    public void runOnMac() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    public void runOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    public void runOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_9)
    @Test
    public void runOnJava9() {
    }

    @EnabledOnJre(JRE.JAVA_10)
    @Test
    public void runOnJava10() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    public void runOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "HOME",matches = "ERR")
    @Test
    void testIfHomeIsErr(){}

}