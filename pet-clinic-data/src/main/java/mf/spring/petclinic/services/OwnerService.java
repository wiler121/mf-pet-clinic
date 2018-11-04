package mf.spring.petclinic.services;

import mf.spring.petclinic.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);;

}
