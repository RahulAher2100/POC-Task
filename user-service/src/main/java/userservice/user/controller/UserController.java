package userservice.user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.user.entity.User;
import userservice.user.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User>add(@RequestBody User user){

        log.info("Inside add method of UserController :{}", user);

        User usr=this.userService.add(user);

        return new ResponseEntity<User>(usr, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User>getUser(@PathVariable("userId") Long userId){

        log.info("Inside get method of UserController :{}", userId);

       User user=this.userService.getUser(userId);

        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


}
