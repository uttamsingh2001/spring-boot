package com.crossasyst.mappingdemo.controller;

import com.crossasyst.mappingdemo.entity.PersonEntity;
import com.crossasyst.mappingdemo.model.AddressRequest;
import com.crossasyst.mappingdemo.model.PersonRequest;
import com.crossasyst.mappingdemo.model.PersonResponse;
import com.crossasyst.mappingdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping(value = "/persons",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest)
    {
        PersonResponse personResponse = personService.createPerson(personRequest);

        if(personResponse!=null)
        {
            return  new ResponseEntity<>(personResponse,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(personResponse,HttpStatus.NO_CONTENT);
        }


    }

  /*  @GetMapping(value = "/persons",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonRequest>> getAllPersons()
    {
        List<PersonRequest> personRequests = personService.getAllPersons();
        return  new ResponseEntity<>(personRequests,HttpStatus.OK);

    }*/


    @PutMapping(value = "/persons/{id}",consumes =MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<PersonResponse> updateEmployee(@PathVariable Long id ,@RequestBody PersonRequest personRequest ){

        PersonResponse  personResponse=personService.updatePerson(id,personRequest);
        return  new ResponseEntity<>(personResponse,HttpStatus.OK);
    }


    @GetMapping(value = "/persons/{personId}")
    public ResponseEntity<PersonRequest> getByPersonId(@PathVariable Long personId) {
        PersonRequest personRequest = personService.getById(personId);
        return new ResponseEntity<>(personRequest, HttpStatus.OK);
    }


    @DeleteMapping(value = "/persons/{personId}")
    public void deleteById(@PathVariable Long personId){
        personService.deleteById(personId);
    }

}
