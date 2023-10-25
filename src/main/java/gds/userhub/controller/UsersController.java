package gds.userhub.controller;

import gds.userhub.dao.dto.UserDto;
import gds.userhub.dao.obj.Users;
import gds.userhub.exceptions.UsersException;
import gds.userhub.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UsersController {

    private UserService usersService;

    @PostMapping(value = "/create")
    public ResponseEntity<Users> postUsers(@RequestBody @Validated Users users) {

            Users newUser = usersService.createUser(users);

            return new ResponseEntity<>(newUser, HttpStatus.CREATED);


    }

    @GetMapping(value = "/listusers")
    public ResponseEntity<List<Users>> findUsers(){
        List<Users> users = usersService.listAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Users findUserById(@PathVariable long id) throws UsersException {
            return usersService.findById(id);

    }
}
