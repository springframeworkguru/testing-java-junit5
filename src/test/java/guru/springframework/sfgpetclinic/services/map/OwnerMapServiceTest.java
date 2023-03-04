package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("OwnerMapServiceTest- BeforeEach");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();

        System.out.println("2-ownersAreZero");
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("Nested BeforeEach");
        }

        @DisplayName("Test Pet Count")
        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
            System.out.println("3-testPetCount");
        }

        @DisplayName("Save Owners Tests - ")
        @Nested
        class SaveOwnersTests {

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));

                System.out.println("Nested Nested BeforeEach");
            }

            @DisplayName("Save Owner")
            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();

                System.out.println("4-saveOwner");
            }

            @DisplayName("Save Owners Tests - ")
            @Nested
            class FindOwnersTests {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();

                    System.out.println("5-findOwner");
                }

                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound() {

                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();

                    System.out.println("6-findOwnerNotFound");
                }
            }
        }

        @DisplayName("Test Pet Count")
        @Test
        void testOrderPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
            System.out.println("######################");
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();

        System.out.println("1-ownersAreStillZero");
    }

    @DisplayName("Verify Order Still Zero Owners")
    @Test
    void ownersAreAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();

        System.out.println("=================");
    }
}