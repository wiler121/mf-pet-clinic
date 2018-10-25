package mf.spring.petclinic.services;

import mf.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetSerive {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
