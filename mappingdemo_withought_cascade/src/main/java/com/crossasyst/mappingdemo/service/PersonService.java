package com.crossasyst.mappingdemo.service;

import com.crossasyst.mappingdemo.entity.AddressEntity;
import com.crossasyst.mappingdemo.entity.PersonEntity;
import com.crossasyst.mappingdemo.model.AddressRequest;
import com.crossasyst.mappingdemo.model.PersonRequest;
import com.crossasyst.mappingdemo.model.PersonResponse;
import com.crossasyst.mappingdemo.repository.AddressRepository;
import com.crossasyst.mappingdemo.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PersonService {

    private  final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository= addressRepository;
    }


    public PersonResponse createPerson(PersonRequest personRequest)
    {

        PersonResponse personResponse= new PersonResponse();

        PersonEntity personEntity= new PersonEntity();
        personEntity.setFirstName(personRequest.getFirstName());
        personEntity.setLastName(personRequest.getLastName());



         AddressEntity addressEntity = new AddressEntity();

         addressEntity.setAddress1(personRequest.getAddress().getAddress1());
         addressEntity.setAddress2(personRequest.getAddress().getAddress2());
         addressEntity.setCity(personRequest.getAddress().getCity());
         addressEntity.setState(personRequest.getAddress().getState());
         addressEntity.setZipcode(personRequest.getAddress().getZipcode());


        personEntity.setAddress(addressEntity);
        addressRepository.save(addressEntity);
        personRepository.save(personEntity);
        personResponse.setId(personEntity.getId());

        return personResponse;

    }

    public PersonResponse updatePerson(Long id, PersonRequest personRequest) {

        PersonResponse personResponse= new PersonResponse();

        Optional<PersonEntity> personEntity= personRepository.findById(id);
        personEntity.get().setFirstName(personRequest.getFirstName());
        personEntity.get().setLastName(personRequest.getLastName());
        personEntity.get().setId(id);

        Optional<AddressEntity> addressEntity = addressRepository.findById(personEntity.get().getAddress().getAddressId());


        addressEntity.get().setAddress1(personRequest.getAddress().getAddress1());
        addressEntity.get().setAddress2(personRequest.getAddress().getAddress2());
        addressEntity.get().setCity(personRequest.getAddress().getCity());
        addressEntity.get().setState(personRequest.getAddress().getState());
        addressEntity.get().setZipcode(personRequest.getAddress().getZipcode());




        personEntity.get().setAddress(addressEntity.get());

        personResponse.setId(personEntity.get().getId());
        addressEntity.get().setAddressId(addressEntity.get().getAddressId());   //Key
        log.info("Address is"+addressEntity.get().getAddressId());

        addressRepository.save(addressEntity.get());
        personRepository.save(personEntity.get());




        return personResponse;

    }


    public PersonRequest getById(Long personId) {
        AddressRequest addressRequest = new AddressRequest();
        PersonRequest personRequest1 = new PersonRequest();
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        Optional<AddressEntity> addressEntity = addressRepository.findById(personEntity.get().getAddress().getAddressId());
        if (personEntity.isPresent() && addressEntity.isPresent()) {

            log.info("person " + personEntity.get().getId() + " is found into the database...............");
            addressRequest.setAddress1(addressEntity.get().getAddress1());
            addressRequest.setAddress2(addressEntity.get().getAddress2());
            addressRequest.setCity(addressEntity.get().getCity());
            addressRequest.setState(addressEntity.get().getState());
            addressRequest.setZipcode(addressEntity.get().getZipcode());
            personRequest1.setFirstName(personEntity.get().getFirstName());
            personRequest1.setLastName(personEntity.get().getLastName());
            personRequest1.setAddress(addressRequest);
        } else {
            log.info("person " + personEntity.get().getId() + " is not found into the database...............");
        }
        return personRequest1;
    }



    public void deleteById(Long personId) {
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
       if (personEntity.isPresent())
       {
           personRepository.deleteById(personId);
           addressRepository.deleteById(personEntity.get().getAddress().getAddressId());

       }
       else{
           log.info("Person not found with id:"+personId);
       }
    }

  /*  public List<PersonRequest> getAllPersons() {
        List<PersonEntity> personEntities = personRepository.findAll();
        PersonRequest personRequest=new PersonRequest();
        personRequest.setFirstName(en);
    }*/
}
