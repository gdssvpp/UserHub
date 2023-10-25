package gds.userhub.service;

import gds.userhub.dao.obj.Users;
import gds.userhub.exceptions.UsersException;
import gds.userhub.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UsersRepository usersRepository;

    public void saveUser(Users user){
        this.usersRepository.save(user);
    }
    public Users createUser(Users users) {
        this.saveUser(users);
        return users;
    }

    public List<Users> listAllUsers(){
       return usersRepository.findAll();
    }

    public Users findById(Long id) throws UsersException {
        Optional<Users> userOptional = usersRepository.findById(id);
        return userOptional.orElseThrow(UsersException::new);
    }
}
