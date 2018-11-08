package mf.spring.petclinic.bootstrap;

import mf.spring.petclinic.model.Owner;
import mf.spring.petclinic.model.Vet;
import mf.spring.petclinic.services.OwnerService;
import mf.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFristName("Michal");
        owner1.setLastName("Flisz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFristName("Adi");
        owner2.setLastName("Lama");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFristName("Mariusz");
        vet1.setLastName("Robot");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFristName("Przemek");
        vet2.setLastName("Paz");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
