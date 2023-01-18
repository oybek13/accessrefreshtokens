package ok.team.accreftoken;

import ok.team.accreftoken.domain.Role;
import ok.team.accreftoken.domain.User;
import ok.team.accreftoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AccreftokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccreftokenApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
          userService.saveRole(new Role(null, "ROLE_USER"));
          userService.saveRole(new Role(null, "ROLE_MANAGER"));
          userService.saveRole(new Role(null, "ROLE_ADMIN"));
          userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null, "Oybek Karimjanov", "oybek", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Fazliddin Nishanov", "fazliddin", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Azamat Abdusalomov", "azamat", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Jamshid Erkinov", "jamshid", "1234", new ArrayList<>()));

          userService.addRoleToUser("oybek", "ROLE_USER");
          userService.addRoleToUser("oybek", "ROLE_SUPER_ADMIN");
          userService.addRoleToUser("fazliddin", "ROLE_ADMIN");
          userService.addRoleToUser("fazliddin", "ROLE_USER");
          userService.addRoleToUser("azamat", "ROLE_MANAGER");
          userService.addRoleToUser("jamshid", "ROLE_USER");
        };
    }
}
