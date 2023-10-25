package gds.userhub.service;

import gds.userhub.dao.dto.UserDto;
import gds.userhub.dao.obj.Users;
import gds.userhub.exceptions.MissingFieldsException;
import gds.userhub.exceptions.UsersException;
import gds.userhub.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UsersRepository usersRepository;

    public Users createUser(UserDto userDto) {
        Users newUser = new Users(userDto);
        this.saveUser(newUser);
        return newUser;
    }
    public void saveUser(Users user){
        this.usersRepository.save(user);
    }

    public List<Users> listAllUsers(){
       return usersRepository.findAll();
    }

    public Users findById(Long id) throws UsersException {
        Optional<Users> userOptional = usersRepository.findById(id);
        return userOptional.orElseThrow(UsersException::new);
    }
}
