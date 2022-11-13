package com.EcartOneToMany.Ecart.services;

//import com.EcartOneToMany.Ecart.model.User;
/*import com.EcartOneToMany.Ecart.repositories.UserRepository;*/
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
/*
@Service
@Log4j2
public class UserService {*/
/*

    @Autowired
    private UserRepository userRepository;
*/

    //Schedule a job to add object in DB(Every 5 seconds)

/*
    @Scheduled(fixedRate = 5000)
    public void addToDbJOb()
    {
//        User user = new User();
//        user.setName("User "+new Random().nextInt(8872));
//        userRepository.save(user);
        log.info("Add service call in "+new Date().toString());
        log.info("Hello World..");

    }

   */
/* @Scheduled(cron="0/15 * * * * *")
    public void fetchDbJob()
    {
        List<User> users= userRepository.findAll();
        log.info("Fetch service call in "+new Date().toString());

        log.info("No of records fetched: "+users.size());

    }*//*

}
*/
