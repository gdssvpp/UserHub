package gds.userhub.dao.obj;

import gds.userhub.dao.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.crypto.bcrypt.BCrypt;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="user_email", unique = true)
    @NotEmpty(message="Field -> Email cannot be null.")
    private String email;

    @Column(name="password")
    @NotEmpty(message="Field -> Password cannot be null.")
    private String password;

    public void setPassword(String password) {
        String salt = BCrypt.gensalt(12);
        String hashedPassword = BCrypt.hashpw(password, salt);

        this.password = hashedPassword;
    }
}
