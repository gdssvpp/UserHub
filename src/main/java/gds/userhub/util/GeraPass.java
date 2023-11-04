package gds.userhub.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class GeraPass {
    public static void main(String[] args) {
        String password = "diamondgogo";

        // Gere um salt aleatório
        String salt = BCrypt.gensalt();

        // Hash da senha com o salt
        String hashedPassword = BCrypt.hashpw(password, salt);

        // Armazene o hashedPassword no banco de dados
        System.out.println("Senha hash (com salt): " + hashedPassword);
    }
}
