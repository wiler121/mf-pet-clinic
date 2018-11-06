package mf.spring.petclinic.bootstrap;

import mf.spring.petclinic.model.Owner;
import mf.spring.petclinic.model.Vet;
import mf.spring.petclinic.services.OwnerService;
import mf.spring.petclinic.services.VetService;
import mf.spring.petclinic.services.map.OwnerServiceMap;
import mf.spring.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFristName("Michal");
        owner1.setLastName("Flisz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFristName("Adi");
        owner2.setLastName("Lama");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFristName("Mariusz");
        vet1.setLastName("Robot");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFristName("Przemek");
        vet2.setLastName("Paz");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
