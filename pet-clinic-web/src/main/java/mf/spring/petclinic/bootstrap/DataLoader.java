package mf.spring.petclinic.bootstrap;

import mf.spring.petclinic.model.*;
import mf.spring.petclinic.services.OwnerService;
import mf.spring.petclinic.services.PetTypeService;
import mf.spring.petclinic.services.SpecialitiesService;
import mf.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
//        PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType saveDogPetType = petTypeService.save(dog);
//
//        PetType cat = new PetType();
//        cat.setName("Cat");
//        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiologia");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Chirurg");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentysta");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFristName("Michal");
        owner1.setLastName("Flisz");
        owner1.setAddress("Nistepowo Wloscianskie 1");
        owner1.setCity("Pokrzywnica");
        owner1.setTelephone("111222333");

        Pet michalPet = new Pet();
        //michalPet.setPetType(saveDogPetType);
        michalPet.setOwner(owner1);
        michalPet.setBirthDate(LocalDate.now());
        michalPet.setName("WONSZ");
        owner1.getPets().add(michalPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFristName("Adi");
        owner2.setLastName("Lama");
        owner2.setAddress("13 pulku piechoty");
        owner2.setCity("Warszawa");
        owner2.setTelephone("222333444");

        Pet adiPet = new Pet();
        adiPet.setName("Catty");
        adiPet.setOwner(owner2);
        adiPet.setBirthDate(LocalDate.now());
        //adiPet.setPetType(saveCatPetType);
        owner2.getPets().add(adiPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFristName("Mariusz");
        vet1.setLastName("Robot");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFristName("Przemek");
        vet2.setLastName("Paz");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
