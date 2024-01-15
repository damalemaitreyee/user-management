package com.friendsbook.user.management.controller;

import com.friendsbook.user.management.DTO.UserRequest;
import com.friendsbook.user.management.DTO.UserResponse;
import com.friendsbook.user.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/friendsbook/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponse addUser(@RequestBody UserRequest user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody UserRequest user){
        return userService.updateUser(id,user);

    }
    @DeleteMapping("/{id}")
    public UserResponse deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);

    }


    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleException(RuntimeException e){
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "fail");
        response.put("message", e.getMessage());
        return response;
    }


}
