package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.*;

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
        System.out.println("1) First Before each");
    }


    @DisplayName("Verify Zero Owners")
    @Test
    public void ownersAreZero(){
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type - ")
    @Nested // nested test class
    class TestCreatePetTypes {

        @BeforeEach
        void setUp(){
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("2) Nested Before each");
        }

        @Test
        void testPetCount(){
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Tests - ")
        @Nested
        class SaveOwnersTests{

            @BeforeEach
            void setUp(){
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("3) Saved Owners Before Each");
            }

            @Test
            void saveOwner(){
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Save Owners Tests -")
            @Nested
            class FindOwnersTests{

                @DisplayName("Find Owner")
                @Test
                void findOwner(){
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner not Found")
                @Test
                void findOwnerNotFound(){
                    Owner foundOwner = ownerMapService.findById(2L);

                    assertThat(foundOwner).isNull();
                }
            }
        }
    }

    @DisplayName("Verify Still Zero")
    @Test
    public void ownersAreStillZero(){
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}