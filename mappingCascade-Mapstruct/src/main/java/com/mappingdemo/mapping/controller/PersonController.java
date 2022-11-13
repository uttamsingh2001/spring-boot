package com.mappingdemo.mapping.controller;


import com.mappingdemo.mapping.mapper.PersonMapper;
import com.mappingdemo.mapping.model.PersonRequest;
import com.mappingdemo.mapping.model.PersonResponse;
import com.mappingdemo.mapping.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest) {
        PersonResponse personResponse = personService.createPerson(personRequest);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{personId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRequest> getPersonById(@PathVariable Long personId)
    {
        PersonRequest personRequest= personService.getPersonById(personId);
        return new ResponseEntity<>(personRequest, HttpStatus.OK);
    }

    @GetMapping(value = "/persons" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonRequest>> getAllPersons()
    {
        List<PersonRequest> personRequest = personService.getAllPersons();
        return new ResponseEntity<>(personRequest , HttpStatus.OK);
    }

    @DeleteMapping(value = "/persons/{personId}")
    public  void DeleteById(@PathVariable Long personId )
    {
        personService.DeleteById(personId);
    }

    @PutMapping(value = "/persons/{personId}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRequest> updatePerson(@PathVariable Long personId , @RequestBody PersonRequest personRequest)
    {
        PersonRequest personRequest1= personService.updatePerson(personId, personRequest);
        return new ResponseEntity<>(personRequest1, HttpStatus.OK);
    }










//    @GetMapping(value = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PersonRequest> getPersonById(@PathVariable Long personId) {
//        PersonRequest personRequest = personService.getPersonById(personId);
//        return new ResponseEntity<>(personRequest, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/persons/{personId}")
//    public void deleteById(@PathVariable Long personId) {
//        personService.deleteById(personId);
//    }
//
//    @PutMapping(path = "/persons/{personId}")
//    public PersonRequest updatePerson(@PathVariable Long personId, @RequestBody PersonRequest personRequest) {
//        PersonRequest personRequest1 = personService.updatePerson(personId, personRequest);
//        return personRequest1;
//    }
//
//    @GetMapping(path = "/persons" , produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<PersonRequest>> getAllPerson(){
//        List<PersonRequest> allPerson = personService.getAllPerson();
//        return new ResponseEntity<>(allPerson,HttpStatus.OK) ;
//    }


}



