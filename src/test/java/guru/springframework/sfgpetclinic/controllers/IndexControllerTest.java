package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
            assertThrows(ValueNotFoundException.class, () -> {
                indexController.oopsHandler();
            });
        }
}