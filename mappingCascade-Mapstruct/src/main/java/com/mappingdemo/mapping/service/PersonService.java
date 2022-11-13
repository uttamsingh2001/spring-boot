package com.mappingdemo.mapping.service;

import com.mappingdemo.mapping.entity.AddressEntity;
import com.mappingdemo.mapping.entity.PersonEntity;
import com.mappingdemo.mapping.mapper.PersonMapper;
import com.mappingdemo.mapping.model.PersonRequest;
import com.mappingdemo.mapping.model.PersonResponse;

import com.mappingdemo.mapping.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonResponse createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = personMapper.ModelToEntity(personRequest);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getPersonId());
        return personResponse;
    }

    public PersonRequest getPersonById(Long personId) {

        PersonEntity personEntity = personRepository.getOne(personId);
        PersonRequest personRequest = personMapper.EntityToModel(personEntity);

        return personRequest;
    }

    public List<PersonRequest> getAllPersons() {
        List<PersonEntity> personEntity = personRepository.findAll();
        List<PersonRequest> personRequest = personMapper.ModelToEntities(personEntity);
        return personRequest;
    }

    public void DeleteById(Long personId) {
        personRepository.deleteById(personId);
    }

    public PersonRequest updatePerson(Long personId, PersonRequest personRequest) {


        PersonEntity personEntity1=personRepository.findById(personId).get();
        PersonEntity personEntity = personMapper.ModelToEntity(personRequest);

        personEntity.getAddress().setAddressId(personEntity1.getAddress().getAddressId());
        personEntity.setPersonId(personId);
        personRepository.save(personEntity);
        return personMapper.EntityToModel(personEntity);

    }

}
