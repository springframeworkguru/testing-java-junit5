package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController controller;
    Model model;
    VetService service;
    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        service = new VetMapService(specialtyService);
                controller = new VetController(service);
        model = new ModelImpl();

        Vet vet1 = new Vet(10l, "Mac", "Kem", null);
        Vet vet2 = new Vet(11l, "Radzio", "Bluszcz", null);

        service.save(vet1);
        service.save(vet2);
    }

    @Test
    void listVets() {
        String str = controller.listVets(model);

        assertEquals("vets/index", str);

        Set vets = (Set)((ModelImpl)model).getMap().get("vets");

        assertEquals(vets.size(),2);
    }
}