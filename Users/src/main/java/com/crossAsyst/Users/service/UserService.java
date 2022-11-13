package com.crossAsyst.Users.service;

import com.crossAsyst.Users.entity.UserRequest;
import com.crossAsyst.Users.entity.UserResponse;
import com.crossAsyst.Users.model.User;
import com.crossAsyst.Users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {


    private final UserRepo userRepo ;

    private List<User> userList = new ArrayList<>() ;


    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserResponse create(UserRequest userRequest){


        AtomicLong atomicLong = new AtomicLong();


        User user = new User() ;
        Random random = new Random() ;
        user.setId(random.nextLong(10));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        userList.add(user) ;
//        userRepo.save(user);

//
//
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
//        userResponse.setFirstName(user.getLastName());

        return userResponse ;
//        return  null ;

    }
    public Optional<User> getUser(Long id){

        Optional<User> getAll = userList.stream().filter(e -> e.getId() == id).findFirst();
        System.out.println(getAll);
        return  getAll ;


    }

    public List<User> getAll(){
        return userList ;
    }

    public UserResponse update(User user){
        UserResponse userResponse = new UserResponse() ;
        userList.stream().map(user1 ->{
            if(user.getId() == user1.getId()){
                user1.setId(user.getId());
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                userResponse.setId(user1.getId());
            }
            return true ;
        }).findFirst() ;
        return userResponse ;

    }
}
