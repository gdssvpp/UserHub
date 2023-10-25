package gds.userhub.repository;

import gds.userhub.dao.obj.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
