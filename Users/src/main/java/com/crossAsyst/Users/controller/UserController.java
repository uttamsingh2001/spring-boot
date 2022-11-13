package com.crossAsyst.Users.controller;

import com.crossAsyst.Users.entity.UserRequest;
import com.crossAsyst.Users.entity.UserResponse;
import com.crossAsyst.Users.model.User;
import com.crossAsyst.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService ;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("")
    public ResponseEntity<?>createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id) {
//        User user = new User();
//        user.setId(id);

        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK) ;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateUser(@RequestBody User user , @PathVariable Long id){
        User user1 = new User() ;
        user1.setId(id);
        user1.setLastName(user.getLastName());
        user1.setFirstName(user.getFirstName());


        return new ResponseEntity<>(userService.update(user1),HttpStatus.OK);
    }
}
