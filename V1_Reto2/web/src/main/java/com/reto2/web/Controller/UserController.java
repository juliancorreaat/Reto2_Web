package com.reto2.web.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto2.web.Model.User;
import com.reto2.web.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    //@ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/id/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.CREATED)
    public User Update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.No_CONTENT)
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable String email){
        return userService.emailExists(email);
    }

    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable String email, @PathVariable String password){
        return userService.authUser(email, password);
    }
}
