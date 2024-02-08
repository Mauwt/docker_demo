package org.example.demo_api.application;

import org.example.demo_api.domain.User;
import org.example.demo_api.domain.UserService;
import org.example.demo_api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userList = userService.findAllUsers();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto user = userService.findUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto req){
        userService.saveUser(req);
        return ResponseEntity.ok("User created");
    }
}
