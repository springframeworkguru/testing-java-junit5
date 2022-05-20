package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.*;

class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp(){
        service = new OwnerSDJpaService(null, null, null);
    }

    @Test
    @Disabled("Disabled intil we learn how to mock objects")
    void findByLastName() {
        Owner foundOwner = service.findByLastName("Buck");
    }

    @Test
    @DisplayName("Should return all by last name")
    void findAllByLastNameLike() {
    }

    @Test
    @DisplayName("Should return all")
    void findAll() {
    }

    @Test
    @DisplayName("Should return one object by id")
    void findById() {
    }

    @Test
    @DisplayName("Should save an object")
    void save() {
    }

    @Test
    @DisplayName("Should delete an object")
    void delete() {
    }

    @Test
    @DisplayName("Should delete an object by id")
    void deleteById() {
    }
}