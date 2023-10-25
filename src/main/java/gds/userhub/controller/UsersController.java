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

import java.util.ArrayList;
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
    public ResponseEntity<List<UserDto>> findUsers(){
        List<Users> users = usersService.listAllUsers();
        List<UserDto> dtos = new ArrayList<>();
        for (Users userArray : users) {
            UserDto userDto = new UserDto(userArray.getFullName(), userArray.getEmail());
            dtos.add(userDto);
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public UserDto findUserById(@PathVariable long id) throws UsersException {

            Users user = usersService.findById(id);
            UserDto userDto = new UserDto(user.getFullName(), user.getEmail());

            return userDto;

    }
}
